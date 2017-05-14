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
		System.out.println("Initializing server on port 9090...");

		ServerSocket listener = new ServerSocket(9090);
		
		// we create an array of connections for easy reference
		Connection[] connections = new Connection[100];
		
		// we can just do a simple increment for our ids
		int clientIdIncrement = 0;
        
		try {
            while (true) {
                Socket socket = listener.accept();
                
                // we increment our ID to identify each connection
                clientIdIncrement++;
                
                // we create a new connection with a reference for the socket
                Connection connection = new Connection(socket, clientIdIncrement);

                // and finally store in our array of connections for future usage
                connections[clientIdIncrement] = connection;
                
                System.out.println("New connection. Connection ID: " + connection.clientId);

                try {
                	// Sending data out
                	PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                	
                	/* 
                	 * This part of the program sends data to the client.
                	 * 
                	 * We can follow this JSON formatting for sending data:
                	 *
                	 * Successful login: { "action": "login_success", "username": "spencer@gmail.com" }
                	 * Bad login: { "action": "login_error", "error_message": "Incorrect credentials." }
                	 * Send log: { "action": "log", "message": "Hi this is the server. You just connected!" }
                	 * New public message: { "action": "new_public_message", "message": "This is a message." }
                	 * */
                	
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
                	 * */
                	BufferedReader in =
            	            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                	
                	String incomingCommand = in.readLine();
                	
                	JSONParser parser = new JSONParser(); 
                	
                	try {
                		System.out.println(incomingCommand);
						JSONObject json = (JSONObject) parser.parse(incomingCommand);
						
						System.out.println("New command from client. The action from the command is:" + json.get("action"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                	
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
	}

}
