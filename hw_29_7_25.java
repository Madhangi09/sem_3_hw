import java.util.*;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class TaskList {
    Node head;
    public void insertAtBeginning(int taskId) {
        Node newNode = new Node(taskId);
        newNode.next = head;
        head = newNode;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // ensure the output ends with a newline
    }
}
public class TaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TaskList taskList = new TaskList();
        for (int i = 0; i < n; i++) {
            int taskId = sc.nextInt();
            taskList.insertAtBeginning(taskId);
		}
        taskList.printList();
        sc.close();
    }
}
