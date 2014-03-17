
public class RestNode extends Node {

    private Node exp;

    public RestNode(Node e) {
        exp = e;
    }

    public String toPrint() {
        return "RestNode[" + exp.toPrint() + "]";
    }

    public String typeCheck() {
        return this.exp.typeCheck();
    }

    public String codeGen() {
        return "push 1\n"
                + exp.codeGen()
                + "add\n"
                + "lw\n";
    }
}
