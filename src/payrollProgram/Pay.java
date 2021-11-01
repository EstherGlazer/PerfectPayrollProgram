package payrollProgram;

public class Pay {
	private PayType payType;
	private double hoursWorked;
	private TaxRate taxRate;
	private double rate;
	
	private double grossPay;
	private double netPay;
	
	public Pay(double hoursWorked, TaxRate taxRate, double payRate, PayType payType ) {
		this.hoursWorked=hoursWorked;
		this.payType=payType;
		this.taxRate=taxRate;
		this.rate=payRate;
	}
	
	public void calculateGrossPay() {
		grossPay=hoursWorked*rate;
	}
	
	public double getGrossPay() {
		calculateGrossPay();
		return grossPay;
	}
	
	public void calculateNetPay() {
		netPay=grossPay*taxRate.getTaxRate();
	}
	
	public double getNetPay() {
		return netPay;
	}
}
