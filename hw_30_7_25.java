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
    Node head = null;
    public void addTask(int taskId) {
        Node newNode = new Node(taskId);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void deleteAtPosition(int position) {
        if (head == null) return;
        // Deleting head node
        if (position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) return;
        current.next = current.next.next;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class TaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of tasks
        TaskList taskList = new TaskList();
        for (int i = 0; i < n; i++) {
            int taskId = sc.nextInt();
            taskList.addTask(taskId);
        }
        int position = sc.nextInt(); // position to delete
        taskList.deleteAtPosition(position);
        taskList.printList();
        sc.close();
    }
}
