import java.util.ArrayList;
class Patient {
    int patientId;
    String name;
    String severityLevel;
    public Patient(int patientId, String name, String severityLevel) {
        this.patientId = patientId;
        this.name = name;
        this.severityLevel = severityLevel;
    }
    public String toString() {
        return "ID: " + patientId + ", Name: " + name + ", Severity: " + severityLevel;
    }
}
class EmergencyRoomQueue {
    ArrayList<Patient> queue = new ArrayList<>();
    public void insertPatient(int id, String name, String severity) {
        queue.add(new Patient(id, name, severity));
        System.out.println("Patient " + name + " added to the queue.");
    }
    public void deletePatient(int position) {
        if (position >= 0 && position < queue.size()) {
            Patient removed = queue.remove(position);
            System.out.println("Removed patient: " + removed.name);
        } else {
            System.out.println("Invalid position. No patient removed.");
        }
    }
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("\nCurrent Patient Queue:");
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(i + ". " + queue.get(i));
            }
        }
    } // losing bracket for displayQueue()
}     // losing bracket for EmergencyRoomQueue
public class Main {
    public static void main(String[] args) {
        EmergencyRoomQueue er = new EmergencyRoomQueue();
        // Inserting patients
        er.insertPatient(1, "Alice", "High");
        er.insertPatient(2, "Bob", "Medium");
        er.insertPatient(3, "Charlie", "Low");
        // Displaying queue
        er.displayQueue();
        // Deleting a patient at position 1 (B
        
        
