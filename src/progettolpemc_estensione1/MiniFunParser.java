package progettolpemc_estensione1;

// $ANTLR 3.5.1 /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g 2014-03-14 12:43:56

import java.util.HashMap;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MiniFunParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASS", "BOOLTYPE", "CLPAR", 
		"COL", "COMMA", "CRPAR", "DIV", "DOUBLCOL", "ELSE", "EMPTY", "EQ", "ERR", 
		"FALSE", "FIRST", "FUN", "ID", "IF", "IN", "INTTYPE", "LET", "LISTTYPE", 
		"LPAR", "MAGGIORE", "MINORE", "MINUS", "NAT", "NOT", "OR", "PLUS", "PRINT", 
		"REST", "RPAR", "SEMIC", "SLPAR", "SRPAR", "THEN", "TIMES", "TRUE", "VAR", 
		"WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASS=5;
	public static final int BOOLTYPE=6;
	public static final int CLPAR=7;
	public static final int COL=8;
	public static final int COMMA=9;
	public static final int CRPAR=10;
	public static final int DIV=11;
	public static final int DOUBLCOL=12;
	public static final int ELSE=13;
	public static final int EMPTY=14;
	public static final int EQ=15;
	public static final int ERR=16;
	public static final int FALSE=17;
	public static final int FIRST=18;
	public static final int FUN=19;
	public static final int ID=20;
	public static final int IF=21;
	public static final int IN=22;
	public static final int INTTYPE=23;
	public static final int LET=24;
	public static final int LISTTYPE=25;
	public static final int LPAR=26;
	public static final int MAGGIORE=27;
	public static final int MINORE=28;
	public static final int MINUS=29;
	public static final int NAT=30;
	public static final int NOT=31;
	public static final int OR=32;
	public static final int PLUS=33;
	public static final int PRINT=34;
	public static final int REST=35;
	public static final int RPAR=36;
	public static final int SEMIC=37;
	public static final int SLPAR=38;
	public static final int SRPAR=39;
	public static final int THEN=40;
	public static final int TIMES=41;
	public static final int TRUE=42;
	public static final int VAR=43;
	public static final int WHITESP=44;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public MiniFunParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public MiniFunParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return MiniFunParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g"; }


	    private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();    
	    private int nestingLevel = 0;



	// $ANTLR start "prog"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:17:1: prog returns [Node ast] : l= let ;
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:18:2: (l= let )
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:18:4: l= let
			{
			pushFollow(FOLLOW_let_in_prog32);
			l=let();
			state._fsp--;

			ast = new ProgNode(l);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "let"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:21:1: let returns [Node ast] : LET d= declist IN e= exp SEMIC ;
	public final Node let() throws RecognitionException {
		Node ast = null;


		ArrayList<Node> d =null;
		Node e =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:22:2: ( LET d= declist IN e= exp SEMIC )
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:22:4: LET d= declist IN e= exp SEMIC
			{
			match(input,LET,FOLLOW_LET_in_let58); 
			HashMap<String,STentry> hm = new HashMap<String,STentry>();
				  if (nestingLevel == 0) symTable.add(hm);
			pushFollow(FOLLOW_declist_in_let79);
			d=declist();
			state._fsp--;

			match(input,IN,FOLLOW_IN_in_let81); 
			pushFollow(FOLLOW_exp_in_let85);
			e=exp();
			state._fsp--;

			match(input,SEMIC,FOLLOW_SEMIC_in_let87); 
			ast = new LetNode(d, e);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "let"



	// $ANTLR start "declist"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:28:1: declist returns [ArrayList<Node> astList] : ( VAR i= ID COL t= type ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fpi=null;
		Token pi=null;
		Node t =null;
		Node e =null;
		Node rt =null;
		Node fpt =null;
		Node pt =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:29:2: ( ( VAR i= ID COL t= type ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )* )
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:29:4: ( VAR i= ID COL t= type ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			{
			astList = new ArrayList<Node>();
				   int offSet;
				   if (nestingLevel==0) offSet = 1;
				   else offSet = 2;
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:33:4: ( VAR i= ID COL t= type ASS e= exp SEMIC | FUN i= ID COL rt= type LPAR (fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==VAR) ) {
					alt4=1;
				}
				else if ( (LA4_0==FUN) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:33:5: VAR i= ID COL t= type ASS e= exp SEMIC
					{
					match(input,VAR,FOLLOW_VAR_in_declist119); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist123); 
					match(input,COL,FOLLOW_COL_in_declist125); 
					pushFollow(FOLLOW_type_in_declist129);
					t=type();
					state._fsp--;

					match(input,ASS,FOLLOW_ASS_in_declist131); 
					pushFollow(FOLLOW_exp_in_declist135);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_declist137); 
					DecVarNode vn = new DecVarNode((i!=null?i.getText():null),t,e);
						    STentry entry = new STentry(vn,offSet++);
						    HashMap<String,STentry> hm = symTable.get(nestingLevel);
						    if (hm.put((i!=null?i.getText():null),entry) != null) {
						    	System.out.println("Identifier "+(i!=null?i.getText():null)+
						          " at line "+(i!=null?i.getLine():0)+" already defined");
						      	System.exit(0);
						    }
						    astList.add(vn);
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:44:5: FUN i= ID COL rt= type LPAR (fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )* )? RPAR CLPAR (e= let |e= exp ) CRPAR SEMIC
					{
					match(input,FUN,FOLLOW_FUN_in_declist154); 
					i=(Token)match(input,ID,FOLLOW_ID_in_declist158); 
					match(input,COL,FOLLOW_COL_in_declist160); 
					pushFollow(FOLLOW_type_in_declist164);
					rt=type();
					state._fsp--;

					DecFunNode fn = new DecFunNode((i!=null?i.getText():null),rt);
						    STentry entry = new STentry(fn,offSet++);
						    HashMap<String,STentry> hm = symTable.get(nestingLevel);
						    if (hm.put((i!=null?i.getText():null),entry) != null) {
						    	System.out.println("Identifier "+(i!=null?i.getText():null)+
						          " at line "+(i!=null?i.getLine():0)+" already defined");
						      	System.exit(0);
						    }
					match(input,LPAR,FOLLOW_LPAR_in_declist178); 
					ArrayList<Node> parList = new ArrayList<Node>();
						        int parOffSet=-1;
						        hm = new HashMap<String,STentry>();
						        symTable.add(hm);
						        nestingLevel++;
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:59:9: (fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )* )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ID) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:59:10: fpi= ID COL fpt= type ( COMMA pi= ID COL pt= type )*
							{
							fpi=(Token)match(input,ID,FOLLOW_ID_in_declist203); 
							match(input,COL,FOLLOW_COL_in_declist205); 
							pushFollow(FOLLOW_type_in_declist209);
							fpt=type();
							state._fsp--;

							DecParNode pn = new DecParNode((fpi!=null?fpi.getText():null),fpt);
								          entry = new STentry(pn,parOffSet--);
								          hm.put((fpi!=null?fpi.getText():null),entry);
								          parList.add(pn);
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:64:10: ( COMMA pi= ID COL pt= type )*
							loop1:
							while (true) {
								int alt1=2;
								int LA1_0 = input.LA(1);
								if ( (LA1_0==COMMA) ) {
									alt1=1;
								}

								switch (alt1) {
								case 1 :
									// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:64:11: COMMA pi= ID COL pt= type
									{
									match(input,COMMA,FOLLOW_COMMA_in_declist234); 
									pi=(Token)match(input,ID,FOLLOW_ID_in_declist238); 
									match(input,COL,FOLLOW_COL_in_declist240); 
									pushFollow(FOLLOW_type_in_declist244);
									pt=type();
									state._fsp--;

									pn = new DecParNode((pi!=null?pi.getText():null),pt);
										          entry = new STentry(pn,parOffSet--);
										          if (hm.put((pi!=null?pi.getText():null),entry) != null) {
										          	System.out.println("Identifier "+(pi!=null?pi.getText():null)+
										             	   " at line "+(pi!=null?pi.getLine():0)+" already defined");
										           	System.exit(0);
										          }
										          parList.add(pn);
									}
									break;

								default :
									break loop1;
								}
							}

							fn.addPar(parList);
							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_declist285); 
					match(input,CLPAR,FOLLOW_CLPAR_in_declist287); 
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:76:7: (e= let |e= exp )
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==LET) ) {
						alt3=1;
					}
					else if ( (LA3_0==EMPTY||(LA3_0 >= FALSE && LA3_0 <= FIRST)||(LA3_0 >= ID && LA3_0 <= IF)||LA3_0==LPAR||(LA3_0 >= NAT && LA3_0 <= NOT)||(LA3_0 >= PRINT && LA3_0 <= REST)||LA3_0==SLPAR||LA3_0==TRUE) ) {
						alt3=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}

					switch (alt3) {
						case 1 :
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:76:8: e= let
							{
							pushFollow(FOLLOW_let_in_declist308);
							e=let();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:76:16: e= exp
							{
							pushFollow(FOLLOW_exp_in_declist314);
							e=exp();
							state._fsp--;

							}
							break;

					}

					match(input,CRPAR,FOLLOW_CRPAR_in_declist317); 
					match(input,SEMIC,FOLLOW_SEMIC_in_declist319); 
					fn.addBody(e);
						       			 symTable.remove(nestingLevel--);
						       			 astList.add(fn);
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astList;
	}
	// $ANTLR end "declist"



	// $ANTLR start "exp"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:81:1: exp returns [Node ast] : f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term ) ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:82:3: (f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term ) )
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:82:5: f= term ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term )
			{
			pushFollow(FOLLOW_term_in_exp348);
			f=term();
			state._fsp--;

			ast = f;
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:83:7: ( ( EQ l= term )* | MINORE l= term | MAGGIORE l= term )
			int alt6=3;
			switch ( input.LA(1) ) {
			case COMMA:
			case CRPAR:
			case DOUBLCOL:
			case EQ:
			case RPAR:
			case SEMIC:
			case SRPAR:
			case THEN:
				{
				alt6=1;
				}
				break;
			case MINORE:
				{
				alt6=2;
				}
				break;
			case MAGGIORE:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:83:8: ( EQ l= term )*
					{
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:83:8: ( EQ l= term )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==EQ) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:83:9: EQ l= term
							{
							match(input,EQ,FOLLOW_EQ_in_exp360); 
							pushFollow(FOLLOW_term_in_exp364);
							l=term();
							state._fsp--;

							ast = new EqNode (ast,l);
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:86:8: MINORE l= term
					{
					match(input,MINORE,FOLLOW_MINORE_in_exp392); 
					pushFollow(FOLLOW_term_in_exp396);
					l=term();
					state._fsp--;

					ast = new MinNode(ast, l);
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:88:8: MAGGIORE l= term
					{
					match(input,MAGGIORE,FOLLOW_MAGGIORE_in_exp414); 
					pushFollow(FOLLOW_term_in_exp418);
					l=term();
					state._fsp--;

					ast = new MagNode(ast, l);
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:92:1: term returns [Node ast] : f= value ( PLUS l= value | MINUS l= value | OR l= value )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:93:2: (f= value ( PLUS l= value | MINUS l= value | OR l= value )* )
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:93:4: f= value ( PLUS l= value | MINUS l= value | OR l= value )*
			{
			pushFollow(FOLLOW_value_in_term453);
			f=value();
			state._fsp--;

			ast = f;
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:94:6: ( PLUS l= value | MINUS l= value | OR l= value )*
			loop7:
			while (true) {
				int alt7=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt7=1;
					}
					break;
				case MINUS:
					{
					alt7=2;
					}
					break;
				case OR:
					{
					alt7=3;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:94:7: PLUS l= value
					{
					match(input,PLUS,FOLLOW_PLUS_in_term463); 
					pushFollow(FOLLOW_value_in_term467);
					l=value();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:96:6: MINUS l= value
					{
					match(input,MINUS,FOLLOW_MINUS_in_term482); 
					pushFollow(FOLLOW_value_in_term486);
					l=value();
					state._fsp--;

					ast = new MinusNode(ast, l);
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:98:6: OR l= value
					{
					match(input,OR,FOLLOW_OR_in_term502); 
					pushFollow(FOLLOW_value_in_term506);
					l=value();
					state._fsp--;

					ast = new OrNode(ast, l);
					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "value"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:102:1: value returns [Node ast] : f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* ;
	public final Node value() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:103:2: (f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )* )
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:103:4: f= fatt ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			{
			pushFollow(FOLLOW_fatt_in_value541);
			f=fatt();
			state._fsp--;

			ast = f;
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:104:6: ( TIMES l= fatt | DIV l= fatt | AND l= fatt )*
			loop8:
			while (true) {
				int alt8=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt8=1;
					}
					break;
				case DIV:
					{
					alt8=2;
					}
					break;
				case AND:
					{
					alt8=3;
					}
					break;
				}
				switch (alt8) {
				case 1 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:104:7: TIMES l= fatt
					{
					match(input,TIMES,FOLLOW_TIMES_in_value551); 
					pushFollow(FOLLOW_fatt_in_value555);
					l=fatt();
					state._fsp--;

					ast = new TimesNode (ast,l);
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:106:6: DIV l= fatt
					{
					match(input,DIV,FOLLOW_DIV_in_value571); 
					pushFollow(FOLLOW_fatt_in_value575);
					l=fatt();
					state._fsp--;

					ast = new DivNode(ast, l);
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:108:7: AND l= fatt
					{
					match(input,AND,FOLLOW_AND_in_value592); 
					pushFollow(FOLLOW_fatt_in_value596);
					l=fatt();
					state._fsp--;

					ast = new AndNode(ast, l);
					}
					break;

				default :
					break loop8;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "value"



	// $ANTLR start "fatt"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:112:1: fatt returns [Node ast] : (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR );
	public final Node fatt() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Node e =null;
		Node fp =null;
		Node p =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node e1 =null;
		Node e2 =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:113:2: (n= NAT | TRUE | FALSE | EMPTY | LPAR e= exp RPAR |i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )? | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | SLPAR e1= exp DOUBLCOL e2= exp SRPAR | FIRST LPAR e= exp RPAR | REST LPAR e= exp RPAR | PRINT LPAR e= exp RPAR | NOT LPAR e= exp RPAR )
			int alt12=12;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt12=1;
				}
				break;
			case TRUE:
				{
				alt12=2;
				}
				break;
			case FALSE:
				{
				alt12=3;
				}
				break;
			case EMPTY:
				{
				alt12=4;
				}
				break;
			case LPAR:
				{
				alt12=5;
				}
				break;
			case ID:
				{
				alt12=6;
				}
				break;
			case IF:
				{
				alt12=7;
				}
				break;
			case SLPAR:
				{
				alt12=8;
				}
				break;
			case FIRST:
				{
				alt12=9;
				}
				break;
			case REST:
				{
				alt12=10;
				}
				break;
			case PRINT:
				{
				alt12=11;
				}
				break;
			case NOT:
				{
				alt12=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:113:4: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_fatt635); 
					ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:115:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fatt650); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:117:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fatt663); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:119:4: EMPTY
					{
					match(input,EMPTY,FOLLOW_EMPTY_in_fatt674); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:121:4: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fatt687); 
					pushFollow(FOLLOW_exp_in_fatt691);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt693); 
					ast = e;
					}
					break;
				case 6 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:123:4: i= ID ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_fatt707); 
					HashMap<String,STentry> hm;
						   STentry entry=null;
						   int declNL;
						   for(declNL=nestingLevel; declNL>=0; declNL--) {
						        hm = symTable.get(declNL);
						   	entry = hm.get((i!=null?i.getText():null));
						       	if (entry != null) break;
						   } 
						   if (entry == null) {
						   	System.out.println("Identifier "+(i!=null?i.getText():null)+
						          " at line "+(i!=null?i.getLine():0)+" is not defined");
						        System.exit(0);
						   }
						   ast = new VarNode(entry,nestingLevel-declNL);   
						  
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:139:4: ( LPAR (fp= exp ( COMMA p= exp )* )? RPAR )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==LPAR) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:139:5: LPAR (fp= exp ( COMMA p= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_fatt719); 
							ArrayList<Node> parList = new ArrayList<Node>();
							// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:141:7: (fp= exp ( COMMA p= exp )* )?
							int alt10=2;
							int LA10_0 = input.LA(1);
							if ( (LA10_0==EMPTY||(LA10_0 >= FALSE && LA10_0 <= FIRST)||(LA10_0 >= ID && LA10_0 <= IF)||LA10_0==LPAR||(LA10_0 >= NAT && LA10_0 <= NOT)||(LA10_0 >= PRINT && LA10_0 <= REST)||LA10_0==SLPAR||LA10_0==TRUE) ) {
								alt10=1;
							}
							switch (alt10) {
								case 1 :
									// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:141:8: fp= exp ( COMMA p= exp )*
									{
									pushFollow(FOLLOW_exp_in_fatt738);
									fp=exp();
									state._fsp--;

									parList.add(fp);
									// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:142:7: ( COMMA p= exp )*
									loop9:
									while (true) {
										int alt9=2;
										int LA9_0 = input.LA(1);
										if ( (LA9_0==COMMA) ) {
											alt9=1;
										}

										switch (alt9) {
										case 1 :
											// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:142:8: COMMA p= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_fatt749); 
											pushFollow(FOLLOW_exp_in_fatt753);
											p=exp();
											state._fsp--;

											parList.add(p);
											}
											break;

										default :
											break loop9;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_fatt774); 
							ast = new FunNode(entry,nestingLevel-declNL,parList);
							}
							break;

					}

					}
					break;
				case 7 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:147:4: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_fatt793); 
					pushFollow(FOLLOW_exp_in_fatt797);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_fatt799); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt801); 
					pushFollow(FOLLOW_exp_in_fatt805);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt807); 
					match(input,ELSE,FOLLOW_ELSE_in_fatt815); 
					match(input,CLPAR,FOLLOW_CLPAR_in_fatt817); 
					pushFollow(FOLLOW_exp_in_fatt821);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_fatt823); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 8 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:150:4: SLPAR e1= exp DOUBLCOL e2= exp SRPAR
					{
					match(input,SLPAR,FOLLOW_SLPAR_in_fatt836); 
					pushFollow(FOLLOW_exp_in_fatt840);
					e1=exp();
					state._fsp--;

					match(input,DOUBLCOL,FOLLOW_DOUBLCOL_in_fatt842); 
					pushFollow(FOLLOW_exp_in_fatt846);
					e2=exp();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_fatt848); 
					ast = new ListNode(e1,e2);
					}
					break;
				case 9 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:152:4: FIRST LPAR e= exp RPAR
					{
					match(input,FIRST,FOLLOW_FIRST_in_fatt858); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt860); 
					pushFollow(FOLLOW_exp_in_fatt864);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt866); 
					ast = new FirstNode(e);
					}
					break;
				case 10 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:154:4: REST LPAR e= exp RPAR
					{
					match(input,REST,FOLLOW_REST_in_fatt876); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt878); 
					pushFollow(FOLLOW_exp_in_fatt882);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt884); 
					ast = new RestNode(e);
					}
					break;
				case 11 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:156:4: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_fatt895); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt897); 
					pushFollow(FOLLOW_exp_in_fatt901);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt903); 
					ast = new PrintNode(e);
					}
					break;
				case 12 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:158:4: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_fatt918); 
					match(input,LPAR,FOLLOW_LPAR_in_fatt920); 
					pushFollow(FOLLOW_exp_in_fatt924);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fatt926); 
					ast = new NotNode(e);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "fatt"



	// $ANTLR start "type"
	// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:162:1: type returns [Node ast] : ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= type SRPAR );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node t =null;

		try {
			// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:163:2: ( INTTYPE | BOOLTYPE | LISTTYPE SLPAR t= type SRPAR )
			int alt13=3;
			switch ( input.LA(1) ) {
			case INTTYPE:
				{
				alt13=1;
				}
				break;
			case BOOLTYPE:
				{
				alt13=2;
				}
				break;
			case LISTTYPE:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:163:4: INTTYPE
					{
					match(input,INTTYPE,FOLLOW_INTTYPE_in_type949); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:164:6: BOOLTYPE
					{
					match(input,BOOLTYPE,FOLLOW_BOOLTYPE_in_type961); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /home/edoardo/NetBeansProjects/ProgettoLPeMC/src/MiniFun.g:165:6: LISTTYPE SLPAR t= type SRPAR
					{
					match(input,LISTTYPE,FOLLOW_LISTTYPE_in_type970); 
					match(input,SLPAR,FOLLOW_SLPAR_in_type972); 
					pushFollow(FOLLOW_type_in_type976);
					t=type();
					state._fsp--;

					match(input,SRPAR,FOLLOW_SRPAR_in_type978); 
					ast = new ListTypeNode(t);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"

	// Delegated rules



	public static final BitSet FOLLOW_let_in_prog32 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_let58 = new BitSet(new long[]{0x0000080000480000L});
	public static final BitSet FOLLOW_declist_in_let79 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_IN_in_let81 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_let85 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_SEMIC_in_let87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist119 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_declist123 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_declist125 = new BitSet(new long[]{0x0000000002800040L});
	public static final BitSet FOLLOW_type_in_declist129 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASS_in_declist131 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_declist135 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist137 = new BitSet(new long[]{0x0000080000080002L});
	public static final BitSet FOLLOW_FUN_in_declist154 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_declist158 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_declist160 = new BitSet(new long[]{0x0000000002800040L});
	public static final BitSet FOLLOW_type_in_declist164 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_declist178 = new BitSet(new long[]{0x0000001000100000L});
	public static final BitSet FOLLOW_ID_in_declist203 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_declist205 = new BitSet(new long[]{0x0000000002800040L});
	public static final BitSet FOLLOW_type_in_declist209 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_COMMA_in_declist234 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_declist238 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_declist240 = new BitSet(new long[]{0x0000000002800040L});
	public static final BitSet FOLLOW_type_in_declist244 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_RPAR_in_declist285 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLPAR_in_declist287 = new BitSet(new long[]{0x0000044CC5364000L});
	public static final BitSet FOLLOW_let_in_declist308 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_exp_in_declist314 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_declist317 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist319 = new BitSet(new long[]{0x0000080000080002L});
	public static final BitSet FOLLOW_term_in_exp348 = new BitSet(new long[]{0x0000000018008002L});
	public static final BitSet FOLLOW_EQ_in_exp360 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_term_in_exp364 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_MINORE_in_exp392 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_term_in_exp396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAGGIORE_in_exp414 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_term_in_exp418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term453 = new BitSet(new long[]{0x0000000320000002L});
	public static final BitSet FOLLOW_PLUS_in_term463 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_value_in_term467 = new BitSet(new long[]{0x0000000320000002L});
	public static final BitSet FOLLOW_MINUS_in_term482 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_value_in_term486 = new BitSet(new long[]{0x0000000320000002L});
	public static final BitSet FOLLOW_OR_in_term502 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_value_in_term506 = new BitSet(new long[]{0x0000000320000002L});
	public static final BitSet FOLLOW_fatt_in_value541 = new BitSet(new long[]{0x0000020000000812L});
	public static final BitSet FOLLOW_TIMES_in_value551 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_fatt_in_value555 = new BitSet(new long[]{0x0000020000000812L});
	public static final BitSet FOLLOW_DIV_in_value571 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_fatt_in_value575 = new BitSet(new long[]{0x0000020000000812L});
	public static final BitSet FOLLOW_AND_in_value592 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_fatt_in_value596 = new BitSet(new long[]{0x0000020000000812L});
	public static final BitSet FOLLOW_NAT_in_fatt635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fatt650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fatt663 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_fatt674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt687 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt691 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fatt707 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_LPAR_in_fatt719 = new BitSet(new long[]{0x0000045CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt738 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_COMMA_in_fatt749 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt753 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_RPAR_in_fatt774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_fatt793 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt797 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_fatt799 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLPAR_in_fatt801 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt805 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_fatt807 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ELSE_in_fatt815 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLPAR_in_fatt817 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt821 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_fatt823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLPAR_in_fatt836 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt840 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_DOUBLCOL_in_fatt842 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt846 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SRPAR_in_fatt848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIRST_in_fatt858 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt860 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt864 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_fatt876 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt878 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt882 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_fatt895 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt897 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt901 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_fatt918 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_fatt920 = new BitSet(new long[]{0x0000044CC4364000L});
	public static final BitSet FOLLOW_exp_in_fatt924 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RPAR_in_fatt926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTTYPE_in_type949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLTYPE_in_type961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LISTTYPE_in_type970 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SLPAR_in_type972 = new BitSet(new long[]{0x0000000002800040L});
	public static final BitSet FOLLOW_type_in_type976 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SRPAR_in_type978 = new BitSet(new long[]{0x0000000000000002L});
}
