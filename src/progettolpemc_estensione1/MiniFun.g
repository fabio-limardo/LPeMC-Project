grammar MiniFun;

@header {
import java.util.HashMap;
import java.util.ArrayList;
}

@members {
    private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();    
    private int nestingLevel = 0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog	returns [Node ast]
	: l=let
          {$ast= new ProgNode($l.ast);};
	
let	returns [Node ast]
	: LET 
	  {HashMap<String,STentry> hm = new HashMap<String,STentry>();
	  if (nestingLevel == 0) symTable.add(hm);} 
          d=declist IN e=exp SEMIC
          {$ast= new LetNode($d.astList, $e.ast);};
	
declist returns [ArrayList<Node> astList]
	: {$astList= new ArrayList<Node>();
	   int offSet;
	   if (nestingLevel==0) offSet = 1;
	   else offSet = 2;}
	  (VAR i=ID COL t=type ASS e=exp SEMIC
	   {DecVarNode vn = new DecVarNode($i.text,$t.ast,$e.ast);
	    STentry entry = new STentry(vn,offSet++);
	    HashMap<String,STentry> hm = symTable.get(nestingLevel);
	    if (hm.put($i.text,entry) != null) {
	    	System.out.println("Identifier "+$i.text+
	          " at line "+$i.line+" already defined");
	      	System.exit(0);
	    }
	    $astList.add(vn);}
	  |
	   FUN i=ID COL rt=type 
	   {DecFunNode fn = new DecFunNode($i.text,$rt.ast);
	    STentry entry = new STentry(fn,offSet++);
	    HashMap<String,STentry> hm = symTable.get(nestingLevel);
	    if (hm.put($i.text,entry) != null) {
	    	System.out.println("Identifier "+$i.text+
	          " at line "+$i.line+" already defined");
	      	System.exit(0);
	    }}
	    LPAR 
	       {ArrayList<Node> parList = new ArrayList<Node>();
	        int parOffSet=-1;
	        hm = new HashMap<String,STentry>();
	        symTable.add(hm);
	        nestingLevel++;} 
	       (fpi=ID COL fpt=type 
	         {DecParNode pn = new DecParNode($fpi.text,$fpt.ast);
	          entry = new STentry(pn,parOffSet--);
	          hm.put($fpi.text,entry);
	          parList.add(pn);}
	        (COMMA pi=ID COL pt=type 
	         {pn = new DecParNode($pi.text,$pt.ast);
	          entry = new STentry(pn,parOffSet--);
	          if (hm.put($pi.text,entry) != null) {
	          	System.out.println("Identifier "+$pi.text+
	             	   " at line "+$pi.line+" already defined");
	           	System.exit(0);
	          }
	          parList.add(pn);})*
	          {fn.addPar(parList);})?  
	      RPAR CLPAR
	      		//devo inserire un nuovo let per var e fun locali
	   		(e=let | e=exp) CRPAR SEMIC {fn.addBody($e.ast);
	       			 symTable.remove(nestingLevel--);
	       			 $astList.add(fn);}
	  )*;	
	  
exp	returns [Node ast] 
 	: f=term {$ast = $f.ast;}
 	    ((EQ l=term
 	     {$ast = new EqNode ($ast,$l.ast);}
 	     )*
 	|    MINORE l=term
 	     {$ast = new MinNode($ast, $l.ast);}
 	|    MAGGIORE l=term
 	     {$ast = new MagNode($ast, $l.ast);}
 	     );
 	
term	returns [Node ast]
	: f=value {$ast= $f.ast;}
	    (PLUS l=value
	     {$ast= new PlusNode ($ast,$l.ast);}
	|   MINUS l=value
 	     {$ast = new MinusNode($ast, $l.ast);}
	|   OR l=value
 	     {$ast = new OrNode($ast, $l.ast);}
 	     )*;
	
value	returns [Node ast]
	: f=fatt {$ast= $f.ast;}
	    (TIMES l=fatt 
	     {$ast= new TimesNode ($ast,$l.ast);}
	|   DIV l=fatt
 	     {$ast = new DivNode($ast, $l.ast);}
 	|   AND l=fatt
 	     {$ast = new AndNode($ast, $l.ast);}
 	     )*;	 	
 	
fatt	returns [Node ast]
	: n=NAT   
	  {$ast = new NatNode(Integer.parseInt($n.text));}  
	| TRUE 
	  {$ast = new BoolNode(true);}  
	| FALSE
	  {$ast = new BoolNode(false);} 
	| EMPTY
	  {$ast = new EmptyNode();}   
	| LPAR e=exp RPAR
	  {$ast= $e.ast;}  
	| i=ID
	  {HashMap<String,STentry> hm;
	   STentry entry=null;
	   int declNL;
	   for(declNL=nestingLevel; declNL>=0; declNL--) {
	        hm = symTable.get(declNL);
	   	entry = hm.get($i.text);
	       	if (entry != null) break;
	   } 
	   if (entry == null) {
	   	System.out.println("Identifier "+$i.text+
	          " at line "+$i.line+" is not defined");
	        System.exit(0);
	   }
	   $ast = new VarNode(entry,nestingLevel-declNL);   
	  } 
	  (LPAR 
	    {ArrayList<Node> parList = new ArrayList<Node>();}
	     (fp=exp {parList.add($fp.ast);}
	     (COMMA p=exp {parList.add($p.ast);} )*
	    )? 
	    RPAR 
	    {$ast = new FunNode(entry,nestingLevel-declNL,parList);}
	  )?
	| IF x=exp THEN CLPAR y=exp CRPAR 
		   ELSE CLPAR z=exp CRPAR 
	  {$ast= new IfNode($x.ast,$y.ast,$z.ast);}	 
	| SLPAR e1=exp DOUBLCOL e2=exp SRPAR
	  {$ast= new ListNode($e1.ast,$e2.ast);}
	| FIRST LPAR e=exp RPAR
	  {$ast= new FirstNode($e.ast);}
	| REST LPAR e=exp RPAR	
	  {$ast= new RestNode($e.ast);}
	| PRINT LPAR e=exp RPAR	
	  {$ast= new PrintNode($e.ast);}   	
	| NOT LPAR e=exp RPAR
	  {$ast = new NotNode($e.ast);}
 	; 
 
type	returns [Node ast]
	: INTTYPE  {$ast= new IntTypeNode();}  
  	| BOOLTYPE {$ast= new BoolTypeNode();}
  	| LISTTYPE SLPAR t=type SRPAR {$ast = new ListTypeNode($t.ast);}
  	;
  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
LET 	: 'let' ;
IN	: 'in' ;
SEMIC	: ';' ;
COL	: ':' ;
DOUBLCOL: '::' ;
COMMA	: ',' ;
ASS	: '=' ;
EQ	: '==' ;
MINORE	: '<='; //estensione1
MAGGIORE: '>='; //estensione1
PLUS	: '+' ;
TIMES	: '*' ;
MINUS	: '-'; //estensione1
OR	: '||'; //estensione1
AND	: '&&'; //estensione1
DIV	: '/'; //estensione1
NAT	: (('1'..'9')('0'..'9')*) | '0';
TRUE	: 'true' ;
FALSE	: 'false' ;
NOT	: 'not'; //estensione1
EMPTY   : 'empty';
VAR 	: 'var' ;
FUN 	: 'fun' ;
LPAR 	: '(' ;
RPAR	: ')' ;
CLPAR 	: '{' ;
CRPAR	: '}' ;
SLPAR 	: '[' ;
SRPAR	: ']' ;
IF 	: 'if' ;
THEN 	: 'then' ;
ELSE 	: 'else' ;
PRINT	: 'print' ;
FIRST   : 'first' ; 
REST    : 'rest' ; 
INTTYPE : 'int' ;
BOOLTYPE: 'bool' ;
LISTTYPE: 'list';

ID 	: ('a'..'z'|'A'..'Z')
 	  ('a'..'z'|'A'..'Z'|'0'..'9')* ;

WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+    { skip(); } ;
 
ERR   	 : . { System.out.println("Invalid char: "+$text); } ; 

