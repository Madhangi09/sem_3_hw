import java.util.*;
public class ArrayImplementation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner object creation
		System.out.println("Enter the size:"); // Output statement
        int size = s.nextInt(); // Get the user input
		int[] array1 = new int[size]; // Array declaration
		System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            array1[i] = s.nextInt(); // Insert elements into array
        }
		Arrays.sort(array1); // Sort the array
		System.out.println("Sorted array elements are:");
        for (int i = 0; i < size; i++) {
            System.out.print(array1[i] + " "); // Print sorted elements
        }
    }
}


import java.util.*;
public class ArrayImplementation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner object creation
		System.out.println("Enter the size:"); // Output statement
        int size = s.nextInt(); // Get the user input
		int[] array1 = new int[size]; // Array declaration
		System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            array1[i] = s.nextInt(); // Insert elements into array
        }
		System.out.println("Enter the element to search:");
        int searchElement = s.nextInt(); // Element to search
		int index = -1; // Default value if not found
		for (int i = 0; i < size; i++) {
            if (array1[i] == searchElement) {
                index = i;
                break;
            }
        }
		if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}

