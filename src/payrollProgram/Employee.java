package payrollProgram;
import java.util.Date;

public class Employee extends Person {
	private Date dateHired;
	private PayType payType;
	private double payRate;
	private int dependents;
	private Benefits benefits;
	private double pay; //what they actually got
	private YTDPay YTDPay;
	private int hoursWorked;
	private TaxRate taxRate;
	
	public Employee(Date dateHired, PayType payType, double payRate, int dependents, Benefits benefits, Double pay,YTDPay YTDPay, int hoursWorked, TaxRate taxRate) {
		this(dateHired,payType, payRate, dependents, benefits, pay, YTDPay, hoursWorked, taxRate);
	}
	public void setDateHired(Date datehired) {
		this.dateHired=datehired;
	}
	public Date getDateHired() {
		return dateHired;
	}
	public void setPayType(PayType pt) {
		this.payType=pt;
	}
	public double getPayType() {
		return payType;
	}
	public void setDependent(int dep) {
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
	public void setPay(double pay) {
		this.pay=pay;
	}
	public double getPay() {
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
	

}
