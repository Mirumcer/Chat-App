package server;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class AllUsers extends ArrayList<User>{
	
	//checks the username and password to see if they can be "loggedIn"
	public void loginRequestCheck(PrintWriter out, JSONObject request) {
		
		User toVerify = new User(request);
		
		//Checks all the users in the array to see if there is a match
		for(int i = 0; i < this.size(); i++){
			
			User toCheck = this.get(i);
			
			if(toCheck.isValid(toVerify)){
				JSONObject validLogin = new JSONObject();
				validLogin.put("action","valid Login");
				out.println(validLogin.toJSONString());
				return;
			}
		}
		
		//no match was found, send login failed
		JSONObject notValidLogin = new JSONObject();
		notValidLogin.put("action", "not Valid Login");
		out.println(notValidLogin.toJSONString());
	}

	//checks to see of the user should be added to the master list
	public void addUser(PrintWriter out, JSONObject request) {
		
		User toVerify = new User(request);
		
		//Checks all the users in the array to see if there is a match
		for(int i = 0; i < this.size(); i++){
			
			User toCheck = this.get(i);
			
			if(toCheck.isValid(toVerify)){
				JSONObject duplicateAccount = new JSONObject();
				duplicateAccount.put("action","duplicateaccount");
				out.println(duplicateAccount.toJSONString());
				return;
			}
			
			//else if the user was not found, add them to the list
			
			this.add(toVerify);
			return;
			
		}
		
	}
	
	

}
