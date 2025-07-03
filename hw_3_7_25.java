import java.util.Scanner;
import java.util.ArrayList;
public class StudentRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> studentIDs = new ArrayList<>();
        // Insertion
        System.out.print("Enter number of student IDs to add: ");
        int n = sc.nextInt();
        System.out.println("Enter student IDs:");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentIDs.add(id);
        }
        // Display all IDs
        System.out.println("Student List:");
        for (int id : studentIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
        // Deletion
        System.out.print("Enter student ID to delete: ");
        int deleteId = sc.nextInt();
        if (studentIDs.contains(deleteId)) {
            studentIDs.remove(Integer.valueOf(deleteId));
        } else {
            System.out.println("Student ID not found.");
        }
        // Display updated list
        System.out.println("Student List after deletion:");
        for (int id : studentIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
        sc.close();