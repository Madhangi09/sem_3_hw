// Node class to represent each answer script
class ScriptNode {
    String scriptID;
    String studentName;
    ScriptNode next;

    public ScriptNode(String scriptID, String studentName) {
        this.scriptID = scriptID;
        this.studentName = studentName;
        this.next = null;
    }
}

// Stack class using linked list
public class AnswerScriptStack {
    private ScriptNode top;

    public AnswerScriptStack() {
        this.top = null;
    }

    // Push: Add a new script to the stack
    public void push(String scriptID, String studentName) {
        ScriptNode newScript = new ScriptNode(scriptID, studentName);
        newScript.next = top;
        top = newScript;
        System.out.println("Script pushed: " + scriptID + " - " + studentName);
    }

    // Pop: Remove and process the top script
    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty. No script to process.");
            return;
        }
        System.out.println("Processing script: " + top.scriptID + " - " + top.studentName);
        top = top.next;
    }

    // Peek: View the most recently collected script
    public void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top script: " + top.scriptID + " - " + top.studentName);
    }

    // Display: Print all scripts from top to bottom
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty. No scripts to display.");
            return;
        }
        System.out.println("All collected scripts (Top to Bottom):");
        ScriptNode current = top;
        while (current != null) {
            System.out.println(current.scriptID + " - " + current.studentName);
            current = current.next;
        }
    }

    // Main method to test the operations
    public static void main(String[] args) {
        AnswerScriptStack stack = new AnswerScriptStack();

        stack.push("EX101", "Ani");
        stack.push("EX102", "kam");
        stack.push("EX103", "Bal");

        stack.display();  // Display all
        stack.peek();     // Peek top
        stack.pop();      // Process top
        stack.display();  // Display remaining
    }
}
