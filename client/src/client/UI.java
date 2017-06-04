package client;

import javax.swing.JFrame;


public class UI {
	
	JFrame mainFrame;
	
	public UI(){
		createView();
		
	}
	
	private void createView(){
		mainFrame = new JFrame();
		
		mainFrame.setSize(300, 500);
		
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setLocationRelativeTo(null);
		
		LoginScreen login = new LoginScreen();
		
		mainFrame.add(login);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
	}

}
