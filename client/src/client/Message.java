package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Message {
	
	String content;
	String destination;
	String sender;
	String Date;
	
	public Message(){
		
	}
	
	public void fillMessage() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Who would you like to send a message to? ");
		destination = in.readLine();
		
		System.out.print("What is your message?");
		content = in.readLine();

	}
	

}
