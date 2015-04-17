package es.us.mwm;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	String username;
	List<Task> tasks;
	
	public User(){
		username="";
		tasks = new ArrayList<Task>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
