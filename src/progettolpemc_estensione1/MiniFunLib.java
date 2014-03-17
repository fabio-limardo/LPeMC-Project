package progettolpemc_estensione1;


public class MiniFunLib {

    public static final String INT = "Int";
    public static final String BOOL = "Bool";
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public static final int NULLPOINTER = -1;
    public static final String EMPTY = "Empty";
    public static final String LIST="List:";

    private static int labIndex = 0;
    private static String functionCode = "";

    public static boolean isCompatible(Node n1, Node n2) {
        if ((n1.typeCheck().equals(n2.typeCheck())
            || (n1.typeCheck().indexOf(MiniFunLib.LIST)==0 && n2.typeCheck().equals(MiniFunLib.EMPTY)))
            || (n2.typeCheck().indexOf(MiniFunLib.LIST)==0 && n1.typeCheck().equals(MiniFunLib.EMPTY))) {
            return true;
        }
        return false;
    }

    public static String newLabel() {
        return "lab" + labIndex++;
    }

    public static void addFunctionCode(String code) {
        functionCode += code;
    }

    public static String getFunctionCode() {
        return functionCode;
    }

}
