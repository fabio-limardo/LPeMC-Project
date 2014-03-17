
public class ListNode extends Node {
    
    private Node first;
    private Node rest;
    private boolean typeChecked = false;
    private String typeString = "";
    
    public ListNode(Node f, Node r) {
        first = f;
        rest = r;
    }
    
    public String toPrint() {
        return "ListNode[" + first.toPrint() + ","
                + rest.toPrint() + "]";
    }
    
    public String typeCheck() {
        if (!this.typeChecked) {
            this.typeChecked = true;
            String listRest = this.rest.typeCheck();
            String listFirst = MiniFunLib.LIST + this.first.typeCheck();
            
            if (this.rest instanceof EmptyNode || (listFirst).equals(listRest)) {
                return listFirst;
            }
        } else {
            System.out.println("LIST Type Error");
            System.exit(0);
        }
        return "";
    }
    
    public String codeGen() {
        return first.codeGen()
                + rest.codeGen()
                + "push 1\n" + "lhp\n" + "add\n" + "sw\n"
                + "lhp\n" + "sw\n"
                + "lhp\n"
                + "push 2\n" + "lhp\n" + "add\n" + "shp\n";
    }
    
}
