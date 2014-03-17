package progettolpemc_estensione1;


import java.util.ArrayList;

public class DecFunNode extends Node {

    private String id;
    private Node retType;
    private ArrayList<Node> parList;
    private Node body;
    private boolean typeChecked = false;
    private String typeString = "";

    public DecFunNode(String i, Node rt) {
        id = i;
        retType = rt;
    }

    public void addPar(ArrayList<Node> pl) {
        this.parList = pl;
    }

    public void addBody(Node b) {
        body = b;
    }

    public ArrayList<Node> getPar() {
        return this.parList;
    }

    public String getType() {
        return this.retType.typeCheck();
    }

    public String toPrint() {
        String parString = "";
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        return "DecFunNode[" + id + ","
                + retType.toPrint() + ","
                + parString + ","
                + body.toPrint() + "]";
    }

    public String typeCheck() {
        if (!typeChecked) {
            if (MiniFunLib.isCompatible(this.retType, this.body)) {
                typeChecked = true;
                typeString = this.body.typeCheck();
            } else {
                System.out.println("Type Error");
                System.exit(0);
            }
        }
        return typeString;
    }

    public String codeGen() {

        String labelFun = MiniFunLib.newLabel();

        String popParSequence = "";

        for (int i = 0; i < parList.size(); i++) {
            popParSequence += "pop\n";
        }

        MiniFunLib.addFunctionCode(
                labelFun + ":\n"
                + "cfp\n"
                + "lra\n"
                + body.codeGen()
                + "srv\n"
                + "sra\n"
                + "pop\n"
                + popParSequence
                + "sfp\n"
                + "lrv\n"
                + "lra\n"
                + "js\n"
        );

        return "push " + labelFun + "\n";
    }
}
