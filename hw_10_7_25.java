class Student {
    int roll;
    String name;
    Student prev;
    Student next;
    public Student(int roll, String name) {
        this.roll=roll;
        this.name =name;
        this.prev=null;
        this.next=null;
    }}
class StudentQueue {
    private Student head;
    public void insertAtFront(int roll, String name) {
        Student newStudent=new Student(roll, name);
        newStudent.next=head;
        if (head!=null) {
            head.prev=newStudent;
        }
        head = newStudent;
        System.out.println("Inserted"+name+"(Roll:"+roll+") at front");
    }
    public void insertAtPosition(int pos, int roll, String name) {
        if (pos<=1 || head==null) {
            insertAtFront(roll, name);
            return;
        }
        Student newStudent=new Student(roll, name);
        Student temp  head;
        int count=1;
        while (temp.next!=null && count<pos-1) {
            temp=temp.next;
            count++;
        }
        newStudent.next=temp.next;
        newStudent.prev=temp;
        if (temp.next!=null) {
            temp.next.prev=newStudent;
        }
        temp.next=newStudent;
        System.out.println("Inserted"+name+"(Roll:"+roll+") at position"+pos+"");
    }
    public void deleteFromFront() {
        if (head==null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Deleted"+head.name+"(Roll:"+head.roll+") from front");
        head=head.next;
        if (head!=null) {
            head.prev=null;
        }
    }
    public void deleteFromEnd() {
        if (head==null) {
            System.out.println("Queue is empty");
            return;
        }
        Student temp=head;
        if (temp.next==null) {
            System.out.println("Deleted"+temp.name+"(Roll:"+temp.roll+") from end");
            head=null;
            return;
        }
        while (temp.next!=null) {
            temp=temp.next;
        }
        System.out.println("Deleted"+temp.name+"(Roll:"+temp.roll+") from end");
        temp.prev.next=null;
    }
    public void displayBackward() {
        if (head==null) {
            System.out.println("Queue is empty");
            return;
        }
        Student temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        System.out.println("Queue in reverse:");
        while (temp!=null) {
            System.out.println("Roll:"+ temp.roll+", Name:"+temp.name);
            temp=temp.prev;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        StudentQueue queue=new StudentQueue();
        queue.insertAtFront(101, "Alice");
        queue.insertAtFront(102, "Bob");
        queue.insertAtPosition(2, 103, "Charlie");
        queue.deleteFromFront();
        queue.insertAtPosition(2, 104, "Daisy");
        queue.deleteFromEnd();
        queue.displayBackward();
    }
}
