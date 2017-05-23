package client;



import javafx.scene.paint.Color;

import javax.swing.JButton;

//import javax.swing.JOptionPane;
//import javax.swing.JPanel;

public class LoginScreen extends javax.swing.JPanel {
	

	public JButton login;
	public JButton newAccount;
	
	
	//function that builds the login screen
	public LoginScreen(){
		
		login = new JButton("LOGIN");
		newAccount = new JButton("NEW ACCOUNT");
	
		
		login.setVisible(true);
		
		this.setBackground(java.awt.Color.black);;
		
	
		//login.setAlignmentX(CENTER_ALIGNMENT);
		//newAccount.setAlignmentX(CENTER_ALIGNMENT);
		
		this.setLayout(null);
		
		newAccount.setLocation(200, 50);
		
		this.add(login);
		this.add(newAccount);
		
		newAccount.setLocation(200, 200);
		
	return;	
		
	}
	
	

}
