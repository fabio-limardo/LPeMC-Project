package progettolpemc_estensione1;


import java.util.ArrayList;

public class LetNode extends Node {

    private final ArrayList<Node> astList;
    private final Node exp;

    public LetNode(ArrayList<Node> list, Node exp) {
        this.astList = list;
        this.exp = exp;
    }

    @Override
    public String toPrint() {
        String left = "";
        for (Node obj : astList) {
            left += obj.toPrint().replace("]]", "]]\r\t");
        }
        return "LetNode[\r\t" + left + "\r" + exp.toPrint() + "\r]";
    }

    @Override
    public String typeCheck() {
        for (int i = 0; i < this.astList.size(); i++) {
            this.astList.get(i).typeCheck();
        }
        return this.exp.typeCheck();
    }

    @Override
    public String codeGen() {
        String code = "";
        // alloco le variabili
        for (int i = 0; i < this.astList.size(); i++) {
            code += this.astList.get(i).codeGen();
        }
        return code + this.exp.codeGen() + "halt\n" + MiniFunLib.getFunctionCode();
    }

}
