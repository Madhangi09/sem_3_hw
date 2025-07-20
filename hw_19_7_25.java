import java.util.Scanner;

public class HelpDeskSimple {
    static final int SIZE = 100;
    static String[] queue = new String[SIZE];
    static int front = -1, rear = -1;

    // Raise a Ticket
    static void raiseTicket(String query) {
        if (rear == SIZE - 1) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) front = 0;
        rear++;
        queue[rear] = query;
        System.out.println("Ticket raised.");
    }

    // Resolve a Ticket
    static void resolveTicket() {
        if (front == -1 || front > rear) {
            System.out.println("No tickets to resolve.");
            return;
        }
        System.out.println("Resolved: " + queue[front]);
        front++;
        if (front > rear) {
            front = rear = -1; // reset queue
        }
    }

    // Display All Tickets
    static void displayTickets() {
        if (front == -1 || front > rear) {
            System.out.println("No pending tickets.");
            return;
        }
        System.out.println("Pending Tickets:");
        for (int i = front; i <= rear; i++) {
            System.out.println((i - front + 1) + ". " + queue[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String query;

        do {
            System.out.println("\n--- College Help Desk ---");
            System.out.println("1. Raise a Ticket");
            System.out.println("2. Resolve a Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter your query: ");
                    query = sc.nextLine();
                    raiseTicket(query);
                    break;
                case 2:
                    resolveTicket();
                    break;
                case 3:
                    displayTickets();
                    break;
                case 4:
                    System.out.println("Thank you. Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
