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
		while (!exit ) {
			int choice = menu(input);
			switch (choice) {
			case 1:
				employees.add(createEmp(input));
				break;
			case 2:
				System.out.println("Which employee do you want to print?");
				int num = input.nextInt();
				PayStubPrinter p = new PayStubPrinter(employees.get(num));
				p.payStubPrinter();
				break;
			case 3:
				System.out.println("Which employee do you want to add pay information?");
				num = input.nextInt();
				addPayInfo(employees.get(num), input);
			case 4:
				exit = true;
				System.exit(0);
			}
		}
	}

	private static void addPayInfo(Employee employee, Scanner input) {
		switch(employee.getPayType()){
			case PayType.hourly:
				System.out.println("How many hours did this employee work?");
				double num = input.nextInt();
				HoursWorked h = new HoursWorked(num);
				Pay pay = new Pay(h.getHoursWorked(), employee.getTaxRate(), employee.getPayRate(), employee.getPayType());
				break;
			case PayType.monthlySalary:
				Pay pay = new Pay(employee.getRate(), employee.getTaxRate(), employee.getPayType());
				break;
			case PayType.YearlySalary:
				System.out.println("How many times a year does this employee get paid?");
				int howOften = keyboard.nextInt();
				Pay pay = new Pay(h.getHoursWorked()/howOften, employee.getTaxRate(), employee.getPayType());
				break;
		}				
		employee.setPay(pay);
	}

	private static Employee createEmp(Scanner input) {
		// Benefits benefits,
		System.out.println("What is the Employee's Name?");
		String name = input.nextLine();
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		System.out.println("What is the Employee's SSN?");
		int ssn = input.nextInt();
		input.nextLine();
		System.out.println("What is the employee's street address?");
		String street = input.nextLine().toUpperCase();
		System.out.println("City?");
		String city = input.nextLine();
		city = city.substring(0,1).toUpperCase() + city.substring(1).toLowerCase();
		System.out.println("State?");
		String state = input.nextLine().toUpperCase();
		System.out.println("Zip?");
		String zip = input.nextLine();
		Address add = new Address(street, city, state, zip);
		System.out.println("Paid Hourly or Salary? ('h' or 's')");
		String payTypeEntry = input.nextLine().toLowerCase();// make if else
		double rate;
		PayType payType;
		if (payTypeEntry.equals("h")) {
			payType = PayType.Hourly;
			System.out.println("What is the hourly rate?");// fix later, cuz might not be hourly rate
			rate = input.nextDouble();
		} else {
			payType = PayType.Salary;
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
		Employee employee1 = new Employee(ssn, name, add, LocalDate.now(), payType, rate, depend, b);
		return employee1;

	}

	public static int menu(Scanner input) {
		System.out.println("Please choose from the following options. ");

		System.out.println("1. Enter a new employee");
		System.out.println("2. Print a PayStub");
		System.out.println("3. Exit");
		// do validation in case it's not an int!

		int choice = input.nextInt();
		input.nextLine();
		// do switch statement in main using choice
		return choice;
	}
}
