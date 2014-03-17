package progettolpemc_estensione1;



public class OrNode extends Node {
  private Node left;
  private Node right;
  
  public OrNode(Node l, Node r){
    left=l;
    right=r;
  }
  public String toPrint(){
    return "OrNode["+left.toPrint()+","
                      +right.toPrint()+"]";
  }
  public String typeCheck(){
    if ((MiniFunLib.isCompatible(left,new BoolTypeNode())) &&  
        (MiniFunLib.isCompatible(right,new BoolTypeNode())))
      return MiniFunLib.BOOL; 
    System.exit(0); 
    return"";
  }
  public String codeGen(){
    return left.codeGen()+right.codeGen()+"add\n"; 
  }  
  
}