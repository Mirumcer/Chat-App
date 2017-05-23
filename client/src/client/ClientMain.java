package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ClientMain {


	public static void main(String[] args) throws IOException {
		
		UI UserInterface = new UI();
		
		
		// TODO Auto-generated method stub
		Socket s = new Socket("127.0.0.1", 9090);
		
		/* 
		 * This part of the client handle incoming commands.
		 * 
		 * Action:
		 * - log: displays a message
		 * - login_error: login was unsuccessful
		 * - login_success: login successful
		 * - new_public_message: receives a new public message
		 * */
		
		BufferedReader input =
	            new BufferedReader(new InputStreamReader(s.getInputStream()));

    	String incomingCommand = input.readLine();
    	
    	JSONParser parser = new JSONParser(); 
    	
    	try {
			JSONObject json = (JSONObject) parser.parse(incomingCommand);
			
			String action = (String) json.get("action");
			
			System.out.println("New incoming action from server: " + action);
			System.out.println();
			
			switch (action) {
				case "log":
					System.out.println("New log from server: " + json.get("message"));
					break;
					
				case "login_success":
					// ok we were able to login, continue with whav
					break;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    	JSONObject task = createTask();
    	
    	PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);
    	
    	out.println(task.toJSONString());
    	
    	
    	/*
    	// Now we send something to the server
		PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);
		
		JSONObject helloLog = new JSONObject();
		helloLog.put("action", "message");
		helloLog.put("message", "It's nice to connect to the server");
		
		out.println(helloLog.toJSONString());
		
		//out.println("Hi server. Thanks for connecting!");
		 */
		 

		System.exit(0);
	}
	
	public static JSONObject createTask() throws IOException{
		//create the buffered stream reader
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//prompt user to specify the task
		System.out.print("Task:");
		String response = in.readLine();
		
		switch (response){
		case"login":
			System.out.println("Username:");
			String username = in.readLine();
			System.out.println("Password:");
			String password = in.readLine();
			
			JSONObject task = new JSONObject();
			
			task.put("action", "login");
			task.put("username", username);
			task.put("password", password);
			
			return task;
		case"message":
			Message toSend = new Message();
			toSend.fillMessage();
			
			
		//handle the other cases like sending a message and stuff
			
		
		
			
		}
		
		
		return null;
	}

}
