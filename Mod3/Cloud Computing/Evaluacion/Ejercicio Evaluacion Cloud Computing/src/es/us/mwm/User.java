package es.us.mwm;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String username;
	private List<Entrance> entradas;
	
	public User(){
		username="";
		entradas = new ArrayList<Entrance>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Entrance> getEntrances() {
		return entradas;
	}
	
	public void setEntrances(List<Entrance> entradas) {
		this.entradas = entradas;
	}

}
