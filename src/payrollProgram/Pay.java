package payrollProgram;

public class Pay {
	private PayType payType;
	private double hoursWorked;
	private double taxRate;
	private double rate;
	
	private Employee employee;
	private double grossPay;
	private double netPay;
	
	public Pay(Employee employee) {
		this.employee=employee;
		this.hoursWorked=employee.getHoursWorked();
		this.payType=employee.getPayType();
		this.taxRate=employee.getTaxRate();
		this.rate=employee.getRate();
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
