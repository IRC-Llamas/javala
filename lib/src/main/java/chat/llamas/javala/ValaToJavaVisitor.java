package chat.llamas.javala;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
// Ensure ANTLR-generated classes are included:
import chat.llamas.javala.antlr.ValaBaseVisitor;
import chat.llamas.javala.antlr.ValaParser;

public class ValaToJavaVisitor extends ValaBaseVisitor<String> {
    @Override
    public String visitClassDeclaration(ValaParser.ClassDeclarationContext ctx) {
        String className = ctx.Identifier().getText();
        StringBuilder javaClass = new StringBuilder("public class " + className + " {\n");

        for (ValaParser.PropertyDeclarationContext prop : ctx.propertyDeclaration()) {
            javaClass.append(visit(prop)).append("\n");
        }

        javaClass.append("}");
        return javaClass.toString();
    }

    @Override
    public String visitPropertyDeclaration(ValaParser.PropertyDeclarationContext ctx) {
        String javaType = switch (ctx.type().getText()) {
            case "int" -> "int";
            case "string" -> "String";
            case "bool" -> "boolean";
            default -> "Object";
        };
        String varName = ctx.Identifier().getText();
        return "    private " + javaType + " " + varName + ";";
    }
}
