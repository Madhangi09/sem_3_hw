import java.util.*;
import java.util.Stack;
public class SeminarRegistration{
	static final int MAX=5;
	static Stack<String> stack=new Stack<>();
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int choice;
		do{
			System.out.println("\n-----Seminar Registration Menu-----");
			System.out.println("1) Register Student ID(Push)");
			System.out.println("2) Cancel last registration(Pop)");
			System.out.println("3) View last registration(Peek)");
			System.out.println("4) Display all current registration");
			System.out.println("5) Exit!");
			System.out.println("Enter your choice (1-5)");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice){
				case 1:
				if(stack.size()>=MAX){
					System.out.println("Stack overflow!! Seminar full!!!");
				}else{
					System.out.println("Enter student ID to register:");
					String id=sc.nextLine();
					stack.push(id);
					System.out.println("Student ID"+id+"Registered successfully!!!");
				}
				break;
				case 2:
				if(stack.isEmpty()){
					System.out.println("Stack underflow! No registrations to remove");
				}else{
					String removed=stack.pop();
					System.out.println("Registration of Student ID"+removed+"Cancelled");
				}
				break;
				case 3:
				if(stack.isEmpty()){
					System.out.println("No registrations yet!");
				}else{
					System.out.println("last registrated Student ID:"+stack.peek());
				}
				break;
				case 4:
				if(stack.isEmpty()){
					System.out.println("No current registrations");
				}else{
					System.out.println("Current registrations(latest to earliest):");
					for(int i=stack.size()-1; i>=0; i--){
						System.out.println(stack.get(i));
					}
				}
				break;
				case 5:
				System.out.println("Invalid choice! Please select from 1 to 5");
			}
		}while(choice!=5);
		sc.close();
	}
}
