package payrollProgram;

import java.time.LocalDate;
import java.io.PrintWriter;
import java.io.File;

public class PayStubPrinter {

	public PayStubPrinter() {
	}

	public PayStubPrinter(Employee emp, Address address, Pay pay, LocalDate date) {
		File file = new File(emp.getName() + "_" + date + ".txt");
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.println(date);
		printWriter.println(emp.getName());
		printWriter.println(emp.getAddress());
		printWriter.println(pay.getPay());
		printWriter.close();
	}
}
