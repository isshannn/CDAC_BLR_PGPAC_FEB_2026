import java.util.Scanner;

public class Entry {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		while(ch == 0) {
			System.out.println("\n\n\n===== STUDENT MANAGEMENT SYSTEM =====");
			System.out.println("1. Insert Student Record");			
			System.out.println("2. Update Student Record");			
			System.out.println("3. Delete Student Record");			
			System.out.println("4. Display All Student Records");			
			System.out.println("5. Search Student by ID");			
			System.out.println("6. Exit");
			System.out.println("Enter your Choice");
			ch = sc.nextInt();
			
		}
	}
}
