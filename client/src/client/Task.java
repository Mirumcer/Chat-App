package client;

import org.json.simple.JSONObject;

public class Task extends JSONObject {

	public Task(){
		
	}
	
	//
	public void createLoginRequest(String username, String password){
		this.put("action", "login");
		this.put("username", username);
		this.put("password", password);
	}

	//returns false if the message was not formatted correctly
	public boolean createMessage(String sender, String receiver, String content){
		
		if(!sender.isEmpty() & !receiver.isEmpty() & !content.isEmpty()){
			this.put("action", "message");
			this.put("sender", sender);
			this.put("receiver", receiver);
			this.put("content", content);
			
			return true;
		}
		return false;
		
	}

	
}
