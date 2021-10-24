package payrollProgram;

import java.util.Date;

public class YTDPay {
	private Date year;
	double YTDPay;
	
	public YTDPay() {
		YTDPay=0;
		
	}
	
	public void addPay(double pay) {
		YTDPay+=pay;
	}
	
	public double getYTDPay() {
		return YTDPay;
	}
}
