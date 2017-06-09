package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerMain {


	public static void main(String[] args) throws IOException {
		
		//creates the array list of all the users
		AllUsers allUsers = new AllUsers();
		
		System.out.println("Initializing server on port 9090...");

		ServerSocket listener = new ServerSocket(9090);
		
		System.out.println("Server Initialized");
		
		// we can just do a simple increment for our ids
		int clientIdIncrement = 0;
        
		try {
			while(true){
				Socket socket = listener.accept();
				
				new Connection(socket, clientIdIncrement, allUsers).start();
				
				// we increment our ID to identify each connection
	            clientIdIncrement++;
	            
	            System.out.println("New connection. Connection ID: " + clientIdIncrement);
				
			}
			
			/*
			 
	
            while (true) {


                try {
                	
                	
                	 * This part of the program sends data to the client.
                	 * 
                	 * We can follow this JSON formatting for sending data:
                	 *
                	 * Successful login: { "action": "login_success", "username": "spencer@gmail.com" }
                	 * Bad login: { "action": "login_error", "error_message": "Incorrect credentials." }
                	 * Send log: { "action": "log", "message": "Hi this is the server. You just connected!" }
                	 * New public message: { "action": "new_public_message", "message": "This is a message." }
                	 *
                	
                	// As soon as the client is connected, let's just send a quick message to the client saying hi
                	JSONObject helloLog = new JSONObject();
                	helloLog.put("action", "log");
                	helloLog.put("message", "Hello client " + connection.clientId + ". The server is ready to receive commands.");
                	
                	// finally, we send out JSON object out to the client
                	out.println(helloLog.toJSONString());

                	
                	/* 
                	 * This part of the program handles data from the client.
                	 * 
                	 * On every JSON object from the client, we can have a common data format:
                	 *
                	 * Login format: { "action": "login", "username": "spencer@gmail.com", "password": "123456" }
                	 * Registration format: { "action": "register", "username": "spencer@gmail.com", "password": "123456" }
                	 * Message format: { "action": "message", "message": "Hello world!" }
                	 * 
                	 * *
                	BufferedReader in =
            	            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                	
                	String incomingCommand = in.readLine();
                	
                	JSONParser parser = new JSONParser(); 
                	
                	try {
                		//prints the JSON object
                		System.out.println(incomingCommand);
						
                		//parses the json object and greates object to interface with
                		JSONObject request = (JSONObject) parser.parse(incomingCommand);
						
                		//
						System.out.println("New command from client. The action from the command is:" + request.get("action"));
						
						//Now do the action that the client has asked.
						switch((String)request.get("action")){
						
						case"loginrequest":
							
							allUsers.loginRequestCheck(out, request);
							break;
							
						case"newaccount":
							
							allUsers.addUser(out, request);
							break;
							
						}
						
					allUsers.print();
						
						
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                	*/

                	
                	
                }finally{
                	listener.close();
			}
        }
	}
