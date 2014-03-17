package progettolpemc_estensione1;



public class BoolNode extends Node {
  private boolean val;
  
  public BoolNode(boolean v){
    val=v;
  }
  public String toPrint(){
    return "BoolNode["+val+"]";
  }
  public String typeCheck(){
    return MiniFunLib.BOOL;
  } 
  public String codeGen(){
    if (val) return "push "+MiniFunLib.TRUE+"\n";
    return "push "+MiniFunLib.FALSE+"\n";
  } 
}