package payrollProgram;

public class PTO {
	private int vacationDays;
	private int sickDays;

	public PTO(int s, int v) {
		this.sickDays = s;
		this.vacationDays = v;

	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	public void subtractSickDay() {
		sickDays--;
	}

	public void subtractVacationDay() {
		vacationDays--;
	}

}
