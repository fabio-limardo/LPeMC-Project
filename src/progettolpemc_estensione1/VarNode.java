package progettolpemc_estensione1;


public class VarNode extends Node {

    private STentry decl;
    private int diffNesting;

    public VarNode(STentry d, int dn) {
        decl = d;
        diffNesting = dn;
    }

    public String toPrint() {
        return "VarNode[" + diffNesting + "," + decl.getOffSet() + "]";
    }

    public String typeCheck() {
        return decl.getDecl().typeCheck();
    }

    public String codeGen() {

        String lookupAL = "";

        for (int i = 0; i < diffNesting; i++) {
            lookupAL += "lw\n";
        }

        return "lfp\n"
                + lookupAL
                + "push " + decl.getOffSet() + "\n"
                + "sub\n"
                + "lw\n";
    }

}
