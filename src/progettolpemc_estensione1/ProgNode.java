package progettolpemc_estensione1;


import java.util.ArrayList;

public class ProgNode extends Node {

    private Node let;

    public ProgNode(Node l) {
        this.let = l;

    }

    public String toPrint() {
        return "ProgNode[" + this.let.toPrint() + "]";
    }

    public String typeCheck() {
        return this.let.typeCheck();
    }

    public String codeGen() {
        return  this.let.codeGen();
    }

}