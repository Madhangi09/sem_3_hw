import java.util.*;
class Car {
    int id;
    String model;
    Car(int id, String model) {
        this.id = id;
        this.model = model;
    }
    void display() {
        System.out.println("Car ID: " + id + ", Model: " + model);
    }
}
class CarServiceCenter {
    private static final int MAX = 5;
    private Car[] stack = new Car[MAX];
    private int top = -1;
    Scanner sc = new Scanner(System.in);
    // Add a car to the service bay (push)
    public void addCar() {
        if (top == MAX - 1) {
            System.out.println("Service bay is full! Please wait.");
            return;
        }
        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter Car Model: ");
        String model = sc.nextLine();

        stack[++top] = new Car(id, model);
        System.out.println("Car added to the service bay.");
    }
    // Remove the last serviced car (pop)
    public void removeCar() {
        if (top == -1) {
            System.out.println("No cars in service.");
            return;
        }
        Car removed = stack[top--];
        System.out.println("Car serviced and removed:");
        removed.display();
    }
    // Display all cars in service
    public void displayCars() {
        if (top == -1) {
            System.out.println("No cars in service.");
            return;
        }
        System.out.println("\nCars currently in service (Top to Bottom):");
        for (int i = top; i >= 0; i--) {
            stack[i].display();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CarServiceCenter serviceCenter = new CarServiceCenter();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Car Service Center =====");
            System.out.println("1. Add a Car to Service Bay");
            System.out.println("2. Remove Last Serviced Car");
            System.out.println("3. Display Cars in Service");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: serviceCenter.addCar(); break;
                case 2: serviceCenter.removeCar(); break;
                case 3: serviceCenter.displayCars(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }
}
