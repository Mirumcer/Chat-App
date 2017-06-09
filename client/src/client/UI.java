package client;

import java.io.BufferedReader;

import javax.swing.JFrame;

import org.json.simple.JSONObject;


public class UI {
	
	JFrame mainFrame;
	LoginScreen login;
	
	public UI(){
		createView();
		
	}
	
	private void createView(){
		mainFrame = new JFrame();
		login = new LoginScreen();
		
		mainFrame.setSize(300, 500);
		
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
	
	}
	
	public void loginView (JSONObject loginRequest){
		
		System.out.println("adding loginview to mainFrame");
		
		mainFrame.add(login);
		mainFrame.setVisible(true);
		login.setVisible(true);
		
		login.submit = false;
		
		while(login.submit == false){
			System.out.println("login.submit is still" + login.submit);
			
		}
		
		System.out.println("adding username and password to JSONObject");
		
		loginRequest.put("action", login.action);
		loginRequest.put("username", login.usernameToSend);
		loginRequest.put("password", login.passwordToSend);
		
		return;
		
	}
	
	public void messagesView(BufferedReader in){
		
	}

}
