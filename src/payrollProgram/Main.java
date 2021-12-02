package payrollProgram;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);

		ArrayList<Employee> employees = new ArrayList<Employee>();
		boolean exit = false;
		while (!exit) {
			int choice = menu(input);
			switch (choice) {
			case 1:
				employees.add(createEmp(input));
				System.out.println("Employee #" + (employees.size() - 1) + " added");
				break;
			case 2:
				for (int x = 0; x < employees.size(); x++)
					System.out.println(x + "\t" + employees.get(x).getFname()+" "+employees.get(x).getLname());
				break;
			case 3:
				System.out.println("Which employee do you want to add pay information?");
				int num = input.nextInt();
				addPayInfo(employees.get(num), input);
				System.out.println("Pay added to Employee " + num + " " + employees.get(num).getFname() + " "
						+ employees.get(num).getLname());
				break;
			case 4:
				System.out.println("Which employee do you want to print? Enter the employee number");
				num = input.nextInt();
				PayStubPrinter p = new PayStubPrinter(employees.get(num));
				p.payStubPrinter();
				System.out.println("Pay Stub printed for Employee " + num + " " + employees.get(num).getFname() + " "
						+ employees.get(num).getLname());
				System.out.println("It is saved in the PerfectPayrollProgram.");
				break;

			case 5:
				exit = true;
				break;

			}
		}
	}

	private static void addPayInfo(Employee employee, Scanner input) {
		Pay pay = null;
		switch (employee.getPayType()) {
		case Hourly:
			System.out.println("How many hours did this employee work?");
			double num = input.nextInt();
			HoursWorked h = new HoursWorked(num);
			pay = new Pay(h.getHoursWorked(), employee.getTaxRate(), employee.getPayRate(), employee.getPayType());
			break;
		case MonthlySalary:
			pay = new Pay(employee.getPayRate(), employee.getTaxRate(), employee.getPayType());
			break;
		case YearlySalary:
			System.out.println("How many times a year does this employee get paid?");
			int howOften = input.nextInt();
			pay = new Pay(employee.getPayRate() / howOften, employee.getTaxRate(), employee.getPayType());
			break;
		}
		employee.setPay(pay);
	}

	private static Employee createEmp(Scanner input) {
		// Benefits benefits,
		System.out.println("What is the Employee's First Name?");
		String fname = input.nextLine();
		System.out.println("What is the Employee's Last Name?");
		String lname = input.nextLine();
		System.out.println("What is the Employee's SSN?");
		int ssn = input.nextInt();
		input.nextLine();
		System.out.println("What is the employee's street address?");
		String street = input.nextLine();
		System.out.println("City?");
		String city = input.nextLine();
		System.out.println("State?");
		String state = input.nextLine();
		System.out.println("Zip?");
		String zip = input.nextLine();
		Address add = new Address(street, city, state, zip);
		System.out.println("Do you want to enter an hourly rate, a monthly rate, or a yearly rate? ('h' or 'm' or 'y')");
		String payTypeEntry = input.nextLine();// make if else
		double rate;
		PayType payType;
		if (payTypeEntry.equals("h")) {
			payType = PayType.Hourly;
			System.out.println("What is the hourly rate?");// fix later, cuz might not be hourly rate
			rate = input.nextDouble();
		} else if (payTypeEntry.equals("m")) {
			payType = PayType.MonthlySalary;
			System.out.println("What is your salary?");
			rate = input.nextDouble();
		} else {
			payType = PayType.YearlySalary;
			System.out.println("What is your salary?");
			rate = input.nextDouble();
		}
		input.nextLine();
		System.out.println("How many dependents are there, if any?");
		int depend = input.nextInt();
		input.nextLine();
		System.out.println("What are the included benefits?");
		String bf = input.nextLine();// create benefits option
		Benefits b = new Benefits();// fix
		Employee employee1 = new Employee(ssn, fname, lname, add, LocalDate.now(), payType, rate, depend, b);
		return employee1;

	}

	public static int menu(Scanner input) {
		System.out.println("Please choose from the following options. ");

		System.out.println("1. Enter a new employee");
		System.out.println("2. Display a list of employees");
		System.out.println("3. Add pay");
		System.out.println("4. Print a PayStub");
		System.out.println("5. Exit");
		// do validation in case it's not an int!

		int choice = input.nextInt();
		input.nextLine();
		// do switch statement in main using choice
		return choice;
	}
}
