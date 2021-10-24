package payrollProgram;

public class Benefits {
	private boolean healthIns;
	private PTO payedTO;
	
	public Benefits(){
		healthIns=false;
		this.payedTO = new PTO(0,0);
	}
	
	public boolean isHealthIns() {
		return healthIns;
	}

	public void setHealthIns(boolean healthIns) {
		this.healthIns = healthIns;
	}

	public PTO getPTO() {
		return payedTO;
	}
}
