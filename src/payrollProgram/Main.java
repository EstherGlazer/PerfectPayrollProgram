package payrollProgram;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	/**
	 * We wrote most of our code in the main.
	 * 
	 * @param args
	 * @throws FileNotFoundException this is for the PayStub printer
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// this is for the users input
		Scanner input = new Scanner(System.in);

		// this variable is to keep track of the last employee the user used...
		int lastEmpUsed = -1;

		ArrayList<Employee> employees = new ArrayList<Employee>();

		boolean exit = false; // Instantiate
		while (!exit) {
			int choice = menu(input);

			switch (choice) {

			case 1:
				employees.add(createEmp(input));
				System.out.println("Employee #" + (employees.size()) + " added");

				// save the current employee in case the user wants to use the same one.
				lastEmpUsed = employees.size() - 1;

				break;

			case 2:

				// loop through employees to print them.
				for (int x = 0; x < employees.size(); x++) {
					System.out
							.println((x + 1) + "\t" + employees.get(x).getFname() + " " + employees.get(x).getLname());
				}
				break;

			case 3:
				if (employees.isEmpty()) {
					System.out.println("No employees exist\nReturning to main menu.....");
				} else {
					System.out.println(
							"Which employee do you want to add pay information? (Enter 0 to use the same employee)");

					int num = input.nextInt() - 1;
					if (num == -1) {
						num = lastEmpUsed;
					}

					// validate
					if (num > employees.size() || num < 0) {
						System.out.println("Sorry, no such employee.\nReturning to main menu......");
					} else {
						lastEmpUsed = num;
						addPayInfo(employees.get(num), input);
						System.out.println("Pay added to Employee " + (num + 1) + " " + employees.get(num).getFname()
								+ " " + employees.get(num).getLname());
					}
				}
				break;

			case 4:
				if (employees.isEmpty()) {
					System.out.println("No employees exist\nReturning to main menu.....");
				} else {
					System.out.println(
							"Which employee do you want to print? Enter the employee number  (Enter 0 to use the same employee)");

					int num = input.nextInt() - 1;
					if (num == -1) {
						num = lastEmpUsed;
					}

					if (num >= employees.size() || num < 0) {
						System.out.println("Sorry, no such employee.\nReturning to main menu......");

					} else if (employees.get(num).getPay() == null) {
						System.out.println("No pay added to employee " + (num + 1)
								+ ". Please add pay before printing a stub.\nReturning to main menu.\n");

					} else {
						lastEmpUsed = num;
						PayStubPrinter p = new PayStubPrinter(employees.get(num));
						p.payStubPrinter();
						System.out.println("Pay Stub printed for Employee " + (num + 1) + " "
								+ employees.get(num).getFname() + " " + employees.get(num).getLname());
						System.out.println("It is saved in the PerfectPayrollProgram folder.\n");
					}
				}
				break;

			case 5:
				if (employees.isEmpty()) {
					System.out.println("No employees exist\nReturning to main menu.....");
				} else {
					System.out.println("Which employee? Enter the employee number (Enter 0 to use the same employee)");

					int num = input.nextInt() - 1;
					if (num == -1) {
						num = lastEmpUsed;
					}

					// validate
					if (num >= employees.size() || num < 0) {
						System.out.println("Sorry, no such employee. Returning to main menu......");

					} else {
						lastEmpUsed = num;
						char dayType = 0;// Initialize

						System.out.println("Employee " + (num + 1) + employees.get(num));

						// Print what this employee has
						System.out.println("Sick days: \t" + employees.get(num).getBenefits().getPTO().getSickDays()
								+ " \nVacation Days: \t" + employees.get(num).getBenefits().getPTO().getVacationDays());
						input.nextLine();

						// if not days left
						if (employees.get(num).getBenefits().getPTO().getSickDays() == 0
								&& employees.get(num).getBenefits().getPTO().getVacationDays() == 0) {
							System.out.println("Employee " + (num + 1) + " has no sick/vacation days");

						} else if (employees.get(num).getBenefits().getPTO().getSickDays() == 0) {
							System.out.println("Employee " + (num + 1)
									+ " has no sick days. Would you like to use a vacation day?");
							System.out.println("'Y'es or 'N'o?");
							char useVacationDay = input.nextLine().toUpperCase().charAt(0);

							while (useVacationDay != 'Y' && useVacationDay != 'N') {
								System.out.println("Invalid entry. Enter 'Y' for Yes and 'N' for No");
								useVacationDay = input.nextLine().toUpperCase().charAt(0);
							}

							if (useVacationDay == 'Y') {
								dayType = 'v';
							}

						} else if (employees.get(num).getBenefits().getPTO().getVacationDays() == 0) {

							System.out.println("Employee " + (num + 1)
									+ " has no vacation days. Would you like to use a sick day?");
							System.out.println("'Y'es or 'N'o?");

							char useSickDay = input.nextLine().toUpperCase().charAt(0);

							while (useSickDay != 'Y' && useSickDay != 'N') {
								System.out.println("Invalid entry. Enter 'Y' for Yes and 'N' for No");
								useSickDay = input.nextLine().toUpperCase().charAt(0);
							}

							if (useSickDay == 'Y') {
								dayType = 's';
							}

						} else {

							System.out.println("Do you want to use a sick day or a vacation day? ('s' or 'v')");
							dayType = input.nextLine().toLowerCase().charAt(0);

							while (dayType != 's' && dayType != 'v') {
								System.out.println("Invalid entry. Enter 's' for sick day and 'v' for vacation day");
								dayType = input.nextLine().toLowerCase().charAt(0);
							}

						}

						if (dayType == 's') {
							employees.get(num).getBenefits().getPTO().subtractSickDay();
							System.out.println("Sick day subtracted from Employee " + (num + 1) + employees.get(num));

						} else if (dayType == 'v') {
							employees.get(num).getBenefits().getPTO().subtractVacationDay();
							System.out
									.println("Vacation day subtracted from Employee " + (num + 1) + employees.get(num));

						} else {
							System.out.println("No adjustment was made. Returning to main menu.");
						}
					}
				}
				break;
			case 6:
				exit = true;
				break;

			}
		}
	}

	/**
	 * addPayInfo adds the pay information for a requested employee
	 * 
	 * @param employee sends in which employee info should be updated
	 * @param input    Scanner for the keyboard user input
	 */
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

	/**
	 * createEmp method creates an employee
	 * 
	 * @param input Scanner for the user to enter input.
	 * @return returns the created employee to be added to the arrayList.
	 */
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

		System.out
				.println("Do you want to enter an hourly rate, a monthly rate, or a yearly rate? ('h' or 'm' or 'y')");
		char payTypeEntry = input.nextLine().toLowerCase().charAt(0);// make if else

		while (payTypeEntry != 'h' && payTypeEntry != 'm' && payTypeEntry != 'y') {
			System.out.println("Invalid entry. Enter 'h' for hourly, 'm' for monthly, or 'y' for yearly");
			payTypeEntry = input.nextLine().toLowerCase().charAt(0);
		}

		double rate = 0;

		PayType payType = null;

		if (payTypeEntry == 'h') {
			payType = PayType.Hourly;
			System.out.println("What is the hourly rate?");
			rate = input.nextDouble();

		} else if (payTypeEntry == 'm') {
			payType = PayType.MonthlySalary;
			System.out.println("What is the monthly salary?");
			rate = input.nextDouble();

		} else if (payTypeEntry == 'y') {
			payType = PayType.YearlySalary;
			System.out.println("What is the yearly salary?");
			rate = input.nextDouble();

		} else {
			System.out.println("Invalid entry.");
		}
		input.nextLine();

		System.out.println("How many dependents are there, if any?");
		int depend = input.nextInt();
		input.nextLine();

		System.out.println("Which benefits package?\n'B'ronze, 'S'ilver, 'G'old, or 'C'ustom");
		char benefits = input.nextLine().toUpperCase().charAt(0);

		// validate
		while (benefits != 'B' && benefits != 'S' && benefits != 'G' && benefits != 'C') {
			System.out.println("Invalid entry. Enter 'B' for Bronze, 'S' for Silver, 'G' for Gold, and 'C' for Custom");
			benefits = input.nextLine().toUpperCase().charAt(0);
		}

		Benefits b = null;
		if (benefits == 'B' || benefits == 'S' || benefits == 'G') {
			b = new Benefits(benefits);

		} else if (benefits == 'C') {
			System.out.println("How many sick days do you want to include?");
			int sickDays = input.nextInt();

			while (sickDays < 0) {
				System.out.println("Invalid entry. Entry cannot be negative");
				System.out.println("How many sick days do you want to include?");
				sickDays = input.nextInt();
			}

			System.out.println("How many vacation days do you want to include?");
			int vacationDays = input.nextInt();

			while (vacationDays < 0) {
				System.out.println("Invalid entry. Entry cannot be negative");
				System.out.println("How many vacation days do you want to include?");
				vacationDays = input.nextInt();
			}

			System.out.println("Do you want to include a health insurance plan? Enter 'Y' for Yes and 'N' for No");
			input.nextLine();

			char healthInsurance = input.nextLine().toUpperCase().charAt(0);
			while (healthInsurance != 'Y' && healthInsurance != 'N') {
				System.out.println("Invalid entry. Enter 'Y' for Yes and 'N' for No");
				healthInsurance = input.nextLine().toUpperCase().charAt(0);
			}

			b = new Benefits(sickDays, vacationDays, healthInsurance);

		} else {
			System.out.println("Invalid entry.");
		}

		Employee employee1 = new Employee(ssn, fname, lname, add, LocalDate.now(), payType, rate, depend, b);
		return employee1;

	}

	/**
	 * the menu method allows the user to decide what he would like to choose.
	 * 
	 * @param input Scanner to take user's input
	 * @return the choice of the user to the menu
	 */
	public static int menu(Scanner input) {
		System.out.println("\n\nPlease choose from the following options. \n");

		System.out.println("1. Enter a new employee");
		System.out.println("2. Display a list of employees");
		System.out.println("3. Add pay");
		System.out.println("4. Print a PayStub");
		System.out.println("5. Use a sick/vacation day");
		System.out.println("6. Exit");

		// InputMismatchException - validation in case it's not an int!
		int choice = 0;

		try {
			choice = input.nextInt();
			input.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Not a valid choice.");
			input.nextLine();
			choice = menu(input);
		}

		return choice;
	}
}
