package progettolpemc_estensione1;


public class ListTypeNode extends Node {

    private Node type;
    
    public ListTypeNode(Node t) {
        this.type = t;
    }

    public String toPrint() {
        return "ListType";
    }

    public String typeCheck() {
        return MiniFunLib.LIST+this.type.typeCheck();
    }

    public String codeGen() {
        return "";
    }
}
