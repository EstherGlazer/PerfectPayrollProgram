package payrollProgram;

public class Pay {
	private PayType payType;
	private double hoursWorked;
	private TaxRate taxRate;
	private double rate;

	private double grossPay;
	private double netPay;

	public Pay(double hoursWorked, TaxRate taxRate, double payRate, PayType payType) {
		this.hoursWorked = hoursWorked;
		this.payType = payType;
		this.taxRate = taxRate;
		this.rate = payRate;
	}

	public Pay(double rate, TaxRate taxRate, PayType payType) {
		this.rate = rate;
		this.payType = payType;
		this.taxRate = taxRate;

	}

	public void calculateGrossPay() {
		if (payType == PayType.Hourly) {
			grossPay = hoursWorked * rate;
		} else {
			grossPay = rate;
		}
	}

	public double getGrossPay() {
		calculateGrossPay();
		return grossPay;
	}

	public void calculateNetPay() {
		netPay = grossPay * (1 - taxRate.getTaxRate());
	}

	public double getNetPay() {
		calculateNetPay();
		return netPay;
	}
}
