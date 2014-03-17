
public class IntTypeNode extends Node {

    public IntTypeNode() {
    }

    public String toPrint() {
        return "IntType";
    }

    public String typeCheck() {
        return MiniFunLib.INT;
    }

    public String codeGen() {
        return "";
    }
}
