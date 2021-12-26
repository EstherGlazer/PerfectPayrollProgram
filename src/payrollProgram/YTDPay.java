package payrollProgram;

public class YTDPay {
	double YTDPay;

	public YTDPay() {
		YTDPay = 0;

	}

	public void addPay(double pay) {
		YTDPay += pay;
	}

	public double getYTDPay() {
		return YTDPay;
	}
}
