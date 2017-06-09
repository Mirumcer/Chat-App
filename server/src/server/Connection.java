package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Connection extends Thread{
	public Socket socket;
	public int clientId;
	private BufferedReader in;
	private PrintWriter out;
	public AllUsers allUsers;
	
	public Connection(Socket socket, int clientId, AllUsers allUsers) {
		
		// we set our unique connection properties
		this.socket = socket;
		this.clientId = clientId;
		this.allUsers = allUsers;
	}
	
	public void run(){
		
		System.out.println("connection is running");
		
		//make variables to send and receive messages 
		try {
			out =
			        new PrintWriter(socket.getOutputStream(), true);
		
			in =
		        new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			while(true){
				
				String incomingCommand = in.readLine();
				
				if(incomingCommand != null){
				
					JSONParser parser = new JSONParser();
					
					//parses the json object and generates object to interface with
            		JSONObject request = (JSONObject) parser.parse(incomingCommand);
					
					System.out.println("New command from client. The action from the command is:" + request.get("action"));
					
					//Now do the action that the client has asked.
					switch((String)request.get("action")){
					
					case"loginrequest":
						
						allUsers.loginRequestCheck(out, request);
						break;
						
					case"newaccount":
						
						allUsers.addUser(out, request);
						break;
					
					case"logout":
						return;
						
					}
				}

			}
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
