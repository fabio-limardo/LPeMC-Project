package progettolpemc_estensione1;



public class BoolTypeNode extends Node {
  
  public BoolTypeNode(){
  }
  public String toPrint(){
    return "BoolType";
  }
  public String typeCheck(){
    return MiniFunLib.BOOL;
  } 
  public String codeGen(){
    return "";
  } 
}