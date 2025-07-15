public class HospitalOPD {
    // Inner class representing a patient node
    class Patient {
        int patientId;
        String name;
        String department;
        Patient prev, next;
        public Patient(int id, String name, String dept) {
            this.patientId = id;
            this.name = name;
            this.department = dept;
            this.prev = this.next = null;
        }
    }
    private Patient head = null;
    // Insert a patient at the end of the queue
    public void insertPatient(int id, String name, String department) {
        Patient newPatient = new Patient(id, name, department);
        if (head == null) {
            head = newPatient;
            head.next = head.prev = head;
        } else {
            Patient tail = head.prev;
            tail.next = newPatient;
            newPatient.prev = tail;
            newPatient.next = head;
            head.prev = newPatient;
        }
    }
    // Display patients in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Patients in queue (Forward):");
        Patient temp = head;
        do {
            System.out.println("ID: " + temp.patientId + ", Name: " + temp.name + ", Dept: " + temp.department);
            temp = temp.next;
        } while (temp != head);
    }
    // Display patients in reverse order
    public void displayReverse() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Patients in queue (Reverse):");
        Patient temp = head.prev;
        do {
            System.out.println("ID: " + temp.patientId + ", Name: " + temp.name + ", Dept: " + temp.department);
            temp = temp.prev;
        } while (temp != head.prev);
    }
    // Main method to test the queue
    public static void main(String[] args) {
        HospitalOPD opd = new HospitalOPD();
        opd.insertPatient(101, "Aisha", "General");
        opd.insertPatient(102, "Rahul", "ENT");
        opd.insertPatient(103, "Meena", "Cardiology");
        opd.displayForward();
        opd.displayReverse();
    }
}
