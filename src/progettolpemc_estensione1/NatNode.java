package progettolpemc_estensione1;



public class NatNode extends Node {
  private int val;
  
  public NatNode(int v){
    val=v;
  }
  public String toPrint(){
    return "NatNode["+val+"]";
  }
  public String typeCheck(){
    return MiniFunLib.INT;
  }
  public String codeGen(){
    return "push "+val+"\n";
  } 
}