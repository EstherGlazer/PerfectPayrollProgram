package payrollProgram;
import java.time.LocalDate;

public class Employee extends Person {
	private LocalDate dateHired;
	private PayType payType;
	private double payRate;
	private int dependents;
	private Benefits benefits;
	private Pay pay; //what they actually got
	private YTDPay YTDPay;
	private int hoursWorked;
	private TaxRate taxRate;
	
	public Employee(int SSN, String name, Address address,LocalDate localDate, PayType payType, double payRate, int dependents, Benefits benefits) {
		super(SSN, name, address);
		this.dateHired=localDate;
		this.payType=payType;
		this.payRate=payRate;
		this.dependents=dependents;
		this.benefits = benefits;
		//this.pay=pay;
		//this.YTDPay=YTDPay;
		this.hoursWorked=hoursWorked;
		//this.taxRate=taxRate;
	}

	public void setDateHired(LocalDate datehired) {
		this.dateHired=datehired;
	}
	public LocalDate getDateHired() {
		return dateHired;
	}
	public void setPayType(PayType pt) {
		this.payType=pt;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayRate(double payRate) {
		this.payRate=payRate;
	}
	public double getPayRate() {
		return payRate;
	}
	public void setDependents(int dep) {
		this.dependents=dep;
	}
	public int getDependents() {
		return dependents;
	}
	public void setBenefits(Benefits ben) {
		this.benefits=ben;
	}
	public Benefits getBenefits() {
		return benefits;
	}
//	public void setPay(double pay) {
//		this.pay=pay;
//	}
	public Pay getPay() {
		//Pay pay = new Pay(hoursWorked, taxRate, payRate, payType);
		return pay;
		}
	public void setYTDPay(YTDPay ytd) {
		this.YTDPay=ytd;
	}
	public YTDPay getYTDPay() {
		return YTDPay;
	}
	public void setHoursWorked(int hours) {
		this.hoursWorked=hours;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setTaxRate(TaxRate tr) {
		this.taxRate=tr;
	}
	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}
	

}
