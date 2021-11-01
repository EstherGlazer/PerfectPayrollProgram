package payrollProgram;

public class PTO extends Benefits{
	private int vacationDays;
	private int sickDays;
	
	public PTO(int v, int s) {
		this.vacationDays = v;
		this.sickDays = s;
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

}
