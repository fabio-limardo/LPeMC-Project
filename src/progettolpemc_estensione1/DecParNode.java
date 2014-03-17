package progettolpemc_estensione1;


public class DecParNode extends Node {

    private String id;
    private Node type;
    private boolean typeChecked = false;
    private String typeString = "";

    public DecParNode(String i, Node t) {
        id = i;
        type = t;
    }
    
    public String toPrint() {
        return "DecParNode[" + id + ","
                + type.toPrint() + "]";
    }

    public String typeCheck() {
        if (!typeChecked) {
            typeChecked = true;
            typeString = type.typeCheck();
        }
        return typeString;
    }

    public String codeGen() {
        return "";
    }
}
