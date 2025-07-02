import java.util.*;
public class SimpleAttendance {
    static String[][] data = new String[10][3]; // [ID, Name, Status]
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1) Insert\n2) Display\n3) Update\n4) Delete\n5) Exit");
            System.out.print("Choose:");
            int ch = sc.nextInt();
            sc.nextLine(); // clear input
            if (ch==1) {
                System.out.print("Enter ID:");
                data[n][0]=sc.nextLine();
                System.out.print("Enter Name:");
                data[n][1]=sc.nextLine();
                System.out.print("Enter Status(Present/Absent):");
                data[n][2]=sc.nextLine();
                n++;
                System.out.println("Added.");
            } else if (ch==2) {
                System.out.println("\nID\tName\tStatus");
                for (int i=0;i<n;i++) {
                    System.out.println(data[i][0]+"\t"+data[i][1]+"\t"+data[i][2]);
                }
            } else if (ch==3) {
                System.out.print("Enter ID to update:");
                String id=sc.nextLine();
                for (int i=0;i<n;i++) {
                    if (data[i][0].equals(id)) {
                        System.out.print("New Status:");
                        data[i][2]=sc.nextLine();
                        System.out.println("Updated.");
                        break;
                    }
                }
            } else if (ch==4) {
                System.out.print("Enter ID to delete:");
                String id=sc.nextLine();
                for (int i=0;i<n;i++) {
                    if (data[i][0].equals(id)) {
                        for (int j=i;j<n-1;j++) {
                            data[j]=data[j+1];
                        }
                        n--;
                        System.out.println("Deleted.");
                        break;
                    }
                }
            } else if (ch==5) {
                break;
            } else {
                System.out.println("Invalid.");
            }
        }
    }
}


import java.util.*;
public class SimpleMarks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] marks=new int[3][2]; // 3 students, 2 subjects
        System.out.println("Enter marks for 3 students in 2 subjects (Math, Science):");
        for (int i=0;i<3;i++) {
            System.out.println("Student"+(i+1)+":");
            System.out.print("Math:");
            marks[i][0]=sc.nextInt();
            System.out.print("Science:");
            marks[i][1]=sc.nextInt();
        }
        System.out.println("\nStudent\tMath\tScience");
        for (int i=0;i<3;i++) {
            System.out.println("S"+(i+1)+"\t"+marks[i][0]+"\t"+marks[i][1]);
        }
    }
}
