package cz.uhk.dordb;

import java.util.Random;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String login;
	private String password;
	
	
	public User() {
		generateRole();
	}
	
	private void generateRole() {
		Random r = new Random();
		Double d = r.nextDouble();
		
		if(d < 0.1) {
			role = "Manager";
		}else if(d > 0.2 && d < 0.6){
			role = "Office";
		}else {
			role = "Worker";
		}
	}
	
	
	public User(String firstName, String lastName, String email, String role, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.login = login;
		this.password = password;
		generateRole();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
