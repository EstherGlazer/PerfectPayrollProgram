package payrollProgram;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class PayStubPrinter {
	private Employee emp;
	private Pay pay;
	private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

	public PayStubPrinter(Employee emp) {
		this.emp = emp;
		this.pay = emp.getPay();
	}

	public PayStubPrinter(Employee emp, LocalDate date) {
		this.emp = emp;
		this.pay = emp.getPay();
		this.date = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
	}

	/**
	 * payStubPrinter prints a payStub.
	 * 
	 * @throws FileNotFoundException
	 */
	public void payStubPrinter() throws FileNotFoundException {
		File file = new File(emp.getFname() + "_" + emp.getLname() + "_" + date + ".txt");
		PrintWriter printWriter = new PrintWriter(file);

		printWriter.println("\t\t\t\t\t\t" + date);

		printWriter.println(emp.getFname() + " " + emp.getLname());
		printWriter.println(emp.getAddress());

		printWriter.printf("\n\n\n\nGross Pay:\n_______________________________\n  $%.2f\n\n\n\n\n", pay.getGrossPay());
		printWriter.printf("Net Pay:\n_______________________________\n $%.2f\n\n\n\n", pay.getNetPay());
		printWriter.printf("YTD Pay: $%.2f\n", emp.getYTDPay().getPay());
		printWriter.println("Benefits Package: " + emp.getBenefits().toString());
		printWriter.close();
	}
}
