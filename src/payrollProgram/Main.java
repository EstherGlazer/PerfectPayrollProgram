package payrollProgram;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice= menu(input);
		
		switch (choice) {
		case 1:
			Employee employee1 = createEmp(input);
			break;
		}
		
		
		
		//Address address= new Address("84-54 118th street", "Kew Gardens", "NY", "11415");
		//Employee employee1= new Employee(111001234, "RenaTanenbaum", address, LocalDate.now(), PayType.Hourly, 20.00, 0,   );
	}
	private static Employee createEmp(Scanner input) {
		// Benefits benefits,
		System.out.println("What is the Employee's Name?");
		String name = input.nextLine();
		System.out.println("What is the Employee's SSN?");
		int ssn = input.nextInt();
		System.out.println("What is the employee's street address?");
		String street = input.nextLine();
		System.out.println("City?");
		String city = input.nextLine();
		System.out.println("State?");
		String state = input.nextLine();
		System.out.println("Zip?");
		String zip = input.nextLine();
		Address add = new Address(street, city, state, zip);
		System.out.println("Paid Hourly or Salary? ('h' or 's'");
		String payType = input.nextLine();//make if else
		System.out.println("What is the hourly rate?");//fix later, cuz might not be hourly rate
		Double rate = input.nextDouble();
		System.out.println("How many dependents are there, if any?");
		int depend = input.nextInt();
		System.out.println("What are the included benefits?");
		String bf = input.nextLine();//create benefits option
		Benefits b = new Benefits();//fix
		Employee employee1 = new Employee(ssn, name, add, LocalDate.now(), PayType.Hourly, rate, depend, b);
		return employee1;
		
	}

	public static int menu(Scanner input) {
		System.out.println("Please choose from the following options. ");
		
		System.out.println("1. Enter a new employee");
		//do validation in case it's not an int!
		
		int choice = input.nextInt();
		
		//do switch statement in main using choice
		return choice;
	}
}
