
import java.util.ArrayList;

public class FunNode extends Node {

    private STentry decl;
    private int diffNesting;
    private ArrayList<Node> parList;

    public FunNode(STentry d, int dn, ArrayList<Node> pl) {
        decl = d;
        diffNesting = dn;
        parList = pl;
    }

    public String toPrint() {
        String parString = "";
        for (int i = 0; i < parList.size(); i++) {
            if (i == 0) {
                parString = parString + (parList.get(i)).toPrint();
            } else {
                parString = parString + "," + (parList.get(i)).toPrint();
            }
        }
        return "FunNode[" + diffNesting + "," + (decl.getOffSet()) + "," + parString + "]";
    }

    public String typeCheck() {
        boolean ret = true;
        ArrayList<Node> decPar = ((DecFunNode) this.decl.getDecl()).getPar();
        for (int i = 0; i < decPar.size(); i++) {
            if (!MiniFunLib.isCompatible(decPar.get(i), this.parList.get(i))) {
                ret = false;
            }
        }
        if (ret) {
            return ((DecFunNode) this.decl.getDecl()).getType();
        }
        System.out.println("Type Error");
        System.exit(0);
        return "";
    }

    public String codeGen() {

        String parCode = "";

        for (int i = parList.size() - 1; i >= 0; i--) {
            parCode += (parList.get(i)).codeGen();
        }

        String lookupAL = "";

        for (int i = 0; i < diffNesting; i++) {
            lookupAL += "lw\n";
        }

        return "lfp\n"
                + parCode
                + "lfp\n"
                + lookupAL
                + "lfp\n"
                + lookupAL
                + "push " + decl.getOffSet() + "\n"
                + "sub\n"
                + "lw\n"
                + "js\n";
    }

}
