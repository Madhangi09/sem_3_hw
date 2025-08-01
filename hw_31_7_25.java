class Task {
    int id;
    String name;
    Task next;
    Task(int id, String name) {
        this.id=id;
        this.name=name;
        this.next=null;
    }
}
public class TaskList {
    Task head;
    void addTask(int id, String name) {
        Task newTask=new Task(id, name);
        if (head==null) {
            head=newTask;
        } else {
            Task temp=head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=newTask;
        }
    }
    void deleteAtPosition(int pos) {
        if (pos<0||head==null) {
            System.out.println("Invalid position");
            return;
        }
        if (pos==0) {
            head=head.next;
            return;
        }
        Task current=head;
        for (int i=0;i<pos-1;i++) {
            if (current==null||current.next==null) {
                System.out.println("Invalid position");
                return;
            }
            current=current.next;
        }
        if (current.next==null) {
            System.out.println("Invalid position");
        } else {
            current.next=current.next.next;
        }
    }
    void printList() {
        Task temp=head;
        while (temp!=null) {
            System.out.println(temp.id+""+temp.name);
            temp=temp.next;
        }
    }
    public static void main(String[] args) throws Exception {
        TaskList list=new TaskList();
        byte[] input=new byte[10000];
        int len=System.in.read(input);
        String[] lines=(new String(input, 0, len)).trim().split("\n");
        if (lines.length<2) {
            System.out.println("Invalid position");
            return;
        }
        int n=Integer.parseInt(lines[0].trim());
        if (n==0||lines.length<n+2) {
            System.out.println("Invalid position");
            return;
        }
        for (int i=1;i<=n;i++) {
            String[] parts=lines[i].trim().split(" ");
            int id=Integer.parseInt(parts[0]);
            String name=parts[1];
            list.addTask(id, name);
        }
        int pos=Integer.parseInt(lines[n+1].trim());
        if (pos<0||pos>=n) {
            System.out.println("Invalid position");
        } else {
            list.deleteAtPosition(pos);
            list.printList();
        }
    }
}
