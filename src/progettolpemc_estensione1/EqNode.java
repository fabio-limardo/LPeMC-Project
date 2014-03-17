package progettolpemc_estensione1;



public class EqNode extends Node {

    private Node left;
    private Node right;

    public EqNode(Node l, Node r) {
        left = l;
        right = r;
    }

    public String toPrint() {
        return "EqNode[" + left.toPrint() + ","
                + right.toPrint() + "]";
    }

    public String typeCheck() {
        if (MiniFunLib.isCompatible(left, right)) {
            return MiniFunLib.BOOL;
        } else if (MiniFunLib.isCompatible(right, left)) {           
            return MiniFunLib.BOOL;
        }
        System.out.println("EQ Type Error");
        System.exit(0);
        return "";
    }

    public String codeGen() {
        String lab1 = MiniFunLib.newLabel();
        String lab2 = MiniFunLib.newLabel();
        return left.codeGen() + right.codeGen()
                + "beq " + lab1 + "\n"
                + "push " + MiniFunLib.FALSE + "\n"
                + "b " + lab2 + "\n"
                + lab1 + ":\n"
                + "push " + MiniFunLib.TRUE + "\n"
                + lab2 + ":\n";
    }
}
