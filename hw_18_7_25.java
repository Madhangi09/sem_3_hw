import java.util.*;
import java.util.Stack;
public class PostfixEvaluator {
    // Method to evaluate a single postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("\nEvaluating: " + expression);
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // If operand, push to stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to int
                System.out.println("Pushed " + ch + " → Stack: " + stack);
            }
            // If operator, pop 2 operands and apply operation
            else if (isOperator(ch)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, ch);
                stack.push(result);
                System.out.println("Applied " + a + " " + ch + " " + b + " = " + result + " → Stack: " + stack);
            }
        }
        return stack.pop(); // Final result
    }
    // Helper: Check if a character is an operator
    public static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
    // Helper: Apply operator to two operands
    public static int applyOperator(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // Assuming b ≠ 0
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Postfix Expression Evaluator");
        System.out.println("Enter postfix expressions (type 'exit' to stop):");
        while (true) {
            System.out.print("\nEnter expression: ");
            String input = scanner.nextLine().replaceAll("\\s+", "");
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int result = evaluatePostfix(input);
                System.out.println("Result = " + result);
            } catch (Exception e) {
                System.out.println("Invalid expression. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Evaluation ended.");
    }
}
