package payrollProgram;

import java.time.LocalDate;

public class YTDPay {
	double pay;
	private int year;

	public YTDPay() {
		pay = 0;
		LocalDate currentDate = LocalDate.now();
		year = currentDate.getYear();

	}

	public void addPay(double pay) {
		this.pay += pay;
		LocalDate currentDate = LocalDate.now();
		year = currentDate.getYear();
	}

	public double getYTDPay() {
		return pay;
	}

	public int getYear() {
		return year;
	}

	public double getPay() {
		return pay;
	}
}
