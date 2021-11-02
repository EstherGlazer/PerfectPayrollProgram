package payrollProgram;

import java.time.LocalTime;

public class HoursWorked {
	private LocalTime clocked_in;
	private LocalTime clocked_out;
	private double hoursWorked;
	private Employee emp;
	
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}
	
	public Employee getEmployee() {
		return emp;
	}
	
	public LocalTime getClocked_in() {
		return clocked_in;
	}
	public void setClocked_in(LocalTime clocked_in) {
		this.clocked_in = clocked_in;
	}
	public LocalTime getClocked_out() {
		return clocked_out;
	}
	public void setClocked_out(LocalTime clocked_out) {
		this.clocked_out = clocked_out;
	}
	
	public HoursWorked(LocalTime i, LocalTime o) {
		this.clocked_in = o;
		this.clocked_out = i;
		long diffInMinutes = java.time.Duration.between(o, i).toMinutes();
		long hoursWorked = diffInMinutes / 60;
		this.hoursWorked = (double) hoursWorked;
	}
	
	public HoursWorked(double i) {
		this.hoursWorked = i;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public void setHoursWorked(LocalTime i, LocalTime o) {
		this.clocked_in = o;
		this.clocked_out = i;
		long diffInMinutes = java.time.Duration.between(o, i).toMinutes();
		long hoursWorked = diffInMinutes / 60;
		this.hoursWorked = (double) hoursWorked;
	}
}
