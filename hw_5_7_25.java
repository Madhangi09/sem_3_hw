// Node class for each patient
class PatientNode {
    int patientId;
    String name;
    PatientNode next;

    public PatientNode(int id, String name) {
        this.patientId = id;
        this.name = name;
        this.next = null;
    }
}

// Class to manage the patient queue
class PatientQueue {
    private PatientNode head;

    // Insert at the end
    public void insertAtEnd(int id, String name) {
        PatientNode newNode = new PatientNode(id, name);
        if (head == null) {
            head = newNode;
        } else {
            PatientNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Inserted: ID = " + id + ", Name = " + name);
        display();
    }

    // Delete from the front
    public void deleteFromFront() {
        if (head == null) {
            System.out.println("Queue is empty. Nothing to delete from front.");
            return;
        }
        System.out.println("Deleted from front: ID = " + head.patientId + ", Name = " + head.name);
        head = head.next;
        display();
    }

    // Delete at a specific position (1-based index)
    public void deleteAtPosition(int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (head == null) {
            System.out.println("Queue is empty. Nothing to delete.");
            return;
        }
        if (pos == 1) {
            System.out.println("Deleted at position 1:
