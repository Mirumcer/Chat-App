package client;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginScreen extends JPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton login;
	private JButton newAccount;
	
	private String username, password;
	
	
	
	//Constructor
	public LoginScreen(){
		createView();
	return;		
	}
	
	
	//initializes the login screen view
	private void createView(){
		
		login = new JButton("LOGIN");
		newAccount = new JButton("NEW ACCOUNT");
		
		login.addActionListener(
				new loginActionListener()
				);
		
		this.setBackground(java.awt.Color.black);;
		
		this.add(login);
		this.add(newAccount);
		
	}
	
	//Login Action listener for sending log-in request
	private class loginActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		
		}
	}
	
}
