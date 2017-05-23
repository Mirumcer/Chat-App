package client;

import javax.swing.JFrame;


public class UI {
	
	JFrame mainFrame;
	
	public UI(){
		
		mainFrame = new JFrame();
		
		LoginScreen logScreen = new LoginScreen();
		
		mainFrame.setVisible(true);
		mainFrame.setSize(300, 500);
		
		LoginScreen login = new LoginScreen();
		
		mainFrame.add(login);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
