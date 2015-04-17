package es.us.mwm;

public class Task {
	
	public int hours;
	
	public Task(){
		this.hours = 0;
		this.name = "";
	}
	
	public Task(String name, int hours) {
		super();
		this.hours = hours;
		this.name = name;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String name;
}
