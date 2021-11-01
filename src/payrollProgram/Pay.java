package payrollProgram;

public class Pay {
	private PayType payType;
	private double hoursWorked;
	private double taxRate;
	private double rate;
	
	private double grossPay;
	private double netPay;
	
	public Pay(double hoursWorked, double taxRate, double payRate, PayType payType ) {
		this.hoursWorked=hoursWorked;
		this.payType=payType;
		this.taxRate=taxRate;
		this.rate=payRate;
	}
	
	public void calculateGrossPay() {
		grossPay=hoursWorked*rate;
	}
	
	public double getGrossPay() {
		return grossPay;
	}
	
	public void calculateNetPay() {
		netPay=grossPay*taxRate;
	}
	
	public double getNetPay() {
		return netPay;
	}
}
