
import java.io.*;
import org.antlr.runtime.*;

public class Test {

    public static void main(String[] args) throws Exception {
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        MiniFunLexer lexer = new MiniFunLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniFunParser parser = new MiniFunParser(tokens);
        Node ast = parser.prog();

        //System.out.println(ast.toPrint());
        //System.out.println(ast.typeCheck());  
        String asm = ast.codeGen();

        FileWriter fstream = new FileWriter(args[0] + ".asm");
        try (BufferedWriter out = new BufferedWriter(fstream)) {
            out.write(asm);
        }

        VMLexer lex = new VMLexer(new ANTLRFileStream(args[0] + ".asm"));
        CommonTokenStream tokensVM = new CommonTokenStream(lex);
        VMParser parserVM = new VMParser(tokensVM);

        ExecuteVM vm = new ExecuteVM(parserVM.createCode());
        vm.cpu();
    }
}
