class Student {
    // Static inner Node class
    static class Node {
        int rollNumber;
        String name;
        Node next;
    }

    Node head;

    // Insert at front
    void insertAtFront(int rollNumber, String name) {
        Node newNode = new Node();
        newNode.rollNumber = rollNumber;
        newNode.name = name;
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int rollNumber, String name) {
        Node newNode = new Node();
        newNode.rollNumber = rollNumber;
        newNode.name = name;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Insert at specific position
    void insertAtPosition(int rollNumber, String name, int position) {
        if (position < 0) {
            System.out.println("Invalid Position: Cannot insert at negative index.");
            return;
        }

        Node newNode = new Node();
        newNode.rollNumber = rollNumber;
        newNode.name = name;

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int index = 0;
        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            System.out.println("Invalid Position: List is shorter than the given position.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display the list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print("Rollno: " + temp.rollNumber + ", Name: " + temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        Student list = new Student();
        list.insertAtFront(2, "Mad");
        list.insertAtEnd(3, "Ani");
        list.insertAtEnd(1, "Bal");
        list.insertAtPosition(5, "Kam", 1);
        list.insertAtPosition(4, "Lak", 0);
        list.insertAtPosition(6, "Gow", 10); // Invalid position

        System.out.println("List after Insertion:");
        list.display();
    }
}
