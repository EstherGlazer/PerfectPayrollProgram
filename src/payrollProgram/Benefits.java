package payrollProgram;

public class Benefits {
	private boolean healthIns;
	private PTO payedTO;
	private char type;
	
	public Benefits(char type){
		this.setType(type);
		this.setType(type);
		if(type=='B') {
			healthIns=true;
			this.payedTO = new PTO(0,0);
		}
		else if(type=='S') {
			healthIns=true;
			this.payedTO = new PTO(4,3);
		}
		else if(type=='G') {
			healthIns=true;
			this.payedTO = new PTO(10,5);
		}
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

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		if(type=='B') {
			str.append("Bronze");
		}
		else if(type=='S') {
			str.append("Silver");
		}
		else if(type=='G') {
			str.append("Gold");
		}
		if(healthIns) {
			str.append("\nYou are enrolled in a health insurance plan.");
		}
		str.append("\nVacation days: "+payedTO.getVacationDays()+" Sick days: "+payedTO.getSickDays());
		return str.toString();
	}
}
