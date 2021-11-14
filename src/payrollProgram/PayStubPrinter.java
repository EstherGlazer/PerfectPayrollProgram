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
	
	

	public void payStubPrinter() throws FileNotFoundException {
		File file = new File(emp.getName() + "_" + date + ".txt");
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.println("\t\t\t\t\t\t" + date);
		printWriter.println(emp.getName() + "\n\n");
		printWriter.println(emp.getAddress());
		printWriter.println("\n\n\n\nGross Pay: " + pay.getGrossPay() + "\n\n\n\n");
		printWriter.println("Net Pay:\n_______________________________\n " + pay.getNetPay() + "\n\n\n");
		printWriter.close();
	}
}
