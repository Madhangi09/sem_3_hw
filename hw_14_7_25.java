class EmployeeNode {
    String name;
    EmployeeNode next;

    public EmployeeNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class EmployeeRoster {
    private EmployeeNode head = null;

    // Insert employee at the end of the circular list
    public void insertEmployee(String name) {
        EmployeeNode newNode = new EmployeeNode(name);

        if (head == null) {
            head = newNode;
            head.next = head; // Circular link
        } else {
            EmployeeNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Display all employee names in rotation order
    public void displayRoster() {
        if (head == null) {
            System.out.println("Roster is empty.");
            return;
        }

        EmployeeNode temp = head;
        do {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster();

        roster.insertEmployee("Alice");
        roster.insertEmployee("Bob");
        roster.insertEmployee("Charlie");

        roster.displayRoster();  // Output: Alice -> Bob -> Charlie -> (back to start)
    }
}
