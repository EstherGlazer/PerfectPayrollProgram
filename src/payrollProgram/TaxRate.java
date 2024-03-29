package payrollProgram;

public class TaxRate {
	private double federalTax;
	private double stateTax;
	private int dependents;

	public TaxRate() {
		federalTax = .12;
		stateTax = .04;
		dependents = 0;
	}

	public TaxRate(int dependents) {
		federalTax = .12;
		stateTax = .04;
		this.dependents = dependents;
	}

	public TaxRate(double stateTax, int dependents) {
		federalTax = .12;
		this.stateTax = stateTax;
		this.dependents = dependents;
	}

	public TaxRate(double federalTax, double stateTax, int dependents) {
		this.federalTax = federalTax;
		this.stateTax = stateTax;
		this.dependents = dependents;
	}

	public double getFederalTax() {
		return federalTax;
	}

	public double getStateTax() {
		return stateTax;
	}

	public int getDependents() {
		return dependents;
	}

	public double getTaxRate() {
		return federalTax + stateTax;
	}
}
