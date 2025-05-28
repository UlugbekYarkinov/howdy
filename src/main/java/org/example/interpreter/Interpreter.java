package org.example.interpreter;

import org.example.*;

import java.util.*;

public class Interpreter {
    private final Map<String, String> variables = new HashMap<>();

    public void execute(SimpleNode node) {
        visit(node);
    }

    private Object visit(SimpleNode node) {
        switch (node.toString()) {
            case "Script":
            case "Statements":
                for (int i = 0; i < node.jjtGetNumChildren(); i++) {
                    visit((SimpleNode) node.jjtGetChild(i));
                }
                break;

            case "Statement":
                visit((SimpleNode) node.jjtGetChild(0));
                break;

            case "Assignment": {
                // IDENTIFIER token is the first token of this node
                String varName = node.jjtGetFirstToken().image;

                // The right-hand side (Value) is the only child
                SimpleNode valueNode = (SimpleNode) node.jjtGetChild(0);
                Object valObj = evaluateValue(valueNode);

                variables.put(varName, valObj.toString());
                break;
            }

            case "Print": {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < node.jjtGetNumChildren(); i++) {
                    Object val = evaluateValue((SimpleNode) node.jjtGetChild(i));
                    output.append(val);
                }
                System.out.println(output);
                break;
            }

            case "If": {
                if (evaluateCondition((SimpleNode) node.jjtGetChild(0))) {
                    visit((SimpleNode) node.jjtGetChild(1));
                } else if (node.jjtGetNumChildren() == 3) {
                    visit((SimpleNode) node.jjtGetChild(2));
                }
                break;
            }

            case "While": {
                while (evaluateCondition((SimpleNode) node.jjtGetChild(0))) {
                    visit((SimpleNode) node.jjtGetChild(1));
                }
                break;
            }
        }
        return null;
    }

    private boolean evaluateCondition(SimpleNode conditionNode) {
        // First token is the variable name
        String left = conditionNode.jjtGetFirstToken().image;

        // Only one child: the value to compare
        SimpleNode rightNode = (SimpleNode) conditionNode.jjtGetChild(0);
        Object rightVal = evaluateValue(rightNode);

        String leftVal = variables.getOrDefault(left, left);
        return leftVal.equals(rightVal.toString());
    }

    private Object evaluateValue(SimpleNode valueNode) {
        String token = valueNode.jjtGetFirstToken().image;

        if (token.startsWith("\"")) {
            // Remove surrounding quotes and unescape
            return token.substring(1, token.length() - 1)
                    .replace("\\\"", "\"")
                    .replace("\\\\", "\\");
        } else {
            // Identifier: return variable value or name itself
            return variables.getOrDefault(token, token);
        }
    }
}
