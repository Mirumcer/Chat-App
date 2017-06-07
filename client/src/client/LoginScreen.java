package client;



import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

public class LoginScreen extends JPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton login;
	private JButton newAccount;
	private JTextField username;
	private JTextField password;
	
	public String passwordToSend;
	public String usernameToSend;
	
	
	//this is a bool to determine weather the submit button has been pressed or not
	public boolean submit = false;
	
	public String action;
	
	
	//Constructor
	public LoginScreen(){
		createView();
	return;		
	}
	
	
	//initializes the login screen view
	private void createView(){
		
		System.out.println("creating loginscreen.");
		
		login = new JButton("LOGIN");
		newAccount = new JButton("NEW ACCOUNT");
		username = new JTextField("Username");
		password = new JTextField("Password");
		
		
		username.setPreferredSize(new Dimension(300,35));
		password.setPreferredSize(new Dimension(300,35));
		
		login.addActionListener(
				new loginActionListener()
				);
		newAccount.addActionListener(
				new AccountActionListener()
				);
		
		
		this.setBackground(java.awt.Color.black);;
		
		this.add(username);
		this.add(password);
		this.add(login);
		this.add(newAccount);

	}
	
	//Login Action listener for sending log-in request
	private class loginActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			action = "loginrequest";
			passwordToSend = password.getText();
			usernameToSend = username.getText();
			submit = true;
			System.out.println("sumbit has been pressed");
			System.out.println(submit);
		
		
		}
	}
	
	private class AccountActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			action = "newaccount";
			passwordToSend = password.getText();
			usernameToSend = username.getText();
			submit = true;
			System.out.println("sumbit has been pressed");
			System.out.println(submit);			
		}
	}
	
}
