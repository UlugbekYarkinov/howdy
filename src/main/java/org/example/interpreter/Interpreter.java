package org.example.interpreter;

import org.example.*;

import java.util.*;

public class Interpreter {
    private final Map<String, String> variables = new HashMap<>();
    private final Stack<Set<String>> declaredVars = new Stack<>();

    public Interpreter() {
        // Initialize with global scope
        declaredVars.push(new HashSet<>());
    }

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

            case "Block":
                // Create new scope for tracking declarations
                declaredVars.push(new HashSet<>());
                visit((SimpleNode) node.jjtGetChild(0));
                // Remove scope when done
                declaredVars.pop();
                break;

            case "Assignment": {
                // IDENTIFIER token is the first token of this node
                String varName = node.jjtGetFirstToken().image;

                // The right-hand side (Value) is the only child
                SimpleNode valueNode = (SimpleNode) node.jjtGetChild(0);
                Object valObj = evaluateValue(valueNode);

                // Store in variables map and mark as declared in current scope
                variables.put(varName, valObj.toString());
                declaredVars.peek().add(varName);
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

        String leftVal = getVariableValue(left);
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
            return getVariableValue(token);
        }
    }

    private String getVariableValue(String varName) {
        // Check if variable exists in any scope
        for (int i = declaredVars.size() - 1; i >= 0; i--) {
            if (declaredVars.get(i).contains(varName)) {
                return variables.get(varName);
            }
        }
        return "null"; // Return "null" if variable not found
    }
}
