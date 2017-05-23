package server;

import org.json.simple.JSONObject;

/*
 * Client requests to the server:
 * 
 * 1. I need to register a user, I am sending you a disared username and password;
 * 2. I need to login as a specific user that I have the password and username;
 * */

public class User {
	
	public String username;
	protected String password;
	
	
	
	
	public User(JSONObject newUser){
		this.username = (String) newUser.get("username");
		this.password = (String) newUser.get("password");
	}
	
	//checks to see if the username and password are valid
	public  boolean isValid(User toVerify){
		if(this.username == toVerify.username){
			if(toVerify.comparePassword(this.password)){
				return true;
			}
		}
		return false;
	}
	
	//checks the password strings to see of they are the same
	public boolean comparePassword(String toCompare){
		if(this.password == toCompare){
			return true;
		}
		
		return false;
	}
}
