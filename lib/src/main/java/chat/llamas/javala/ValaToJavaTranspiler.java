package chat.llamas.javala;

import org.antlr.v4.runtime.*;
import chat.llamas.javala.antlr.ValaLexer;
import chat.llamas.javala.antlr.ValaParser;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ValaToJavaTranspiler {
    public static void main(String[] args) throws Exception {
        String valaCode = """
                class Example { 
                    int x;
                    string name;
                }
                """;

        // Create ANTLR input stream
        CharStream input = CharStreams.fromString(valaCode);

        // Create lexer and parser
        ValaLexer lexer = new ValaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValaParser parser = new ValaParser(tokens);

        // Parse Vala code
        ParseTree tree = parser.classDeclaration();

        // Convert to Java
        ValaToJavaVisitor visitor = new ValaToJavaVisitor();
        String javaCode = visitor.visit(tree);

        // Print the transpiled Java code
        System.out.println(javaCode);
    }
}

