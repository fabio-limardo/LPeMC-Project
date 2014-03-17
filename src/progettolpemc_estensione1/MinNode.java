

public class MinNode extends Node {

    private Node left;
    private Node right;

    public MinNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public String toPrint() {
        return "MinNode[" + this.left.toPrint() + "," + this.right.toPrint() + "]";
    }

    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {
            return MiniFunLib.BOOL;
        }
        System.exit(0);
        return "";
    }

    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return this.left.codeGen() + this.right.codeGen()
                + "bless " + lab1 + "\n"
                + "push " + MiniFunLib.FALSE + "\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "push " + MiniFunLib.TRUE + "\n"
                + lab2 + ":\n";
    }
}