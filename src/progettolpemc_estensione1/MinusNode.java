package progettolpemc_estensione1;



public class MinusNode extends Node {
  private Node left;
  private Node right;
  
  public MinusNode(Node l, Node r){
    left=l;
    right=r;
  }
  public String toPrint(){
    return "MinusNode["+left.toPrint()+","
                      +right.toPrint()+"]";
  }
  public String typeCheck(){
    if ((MiniFunLib.isCompatible(left,new IntTypeNode())) &&  
        (MiniFunLib.isCompatible(right,new IntTypeNode())))
      return MiniFunLib.INT; 
    System.exit(0); 
    return"";
  }
  public String codeGen(){
    return left.codeGen()+right.codeGen()+"sub\n"; 
  }  
  
}