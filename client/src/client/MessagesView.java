package client;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MessagesView extends JPanel {
	
	public JButton send;
	public JTextArea messageDisplayPane;
	public JScrollPane messageDisplayContainer;
	

	public MessagesView(){
		
		messageDisplayPane = new JTextArea();
		messageDisplayContainer = new JScrollPane();
		send = new JButton();
		
		messageDisplayPane.setEditable(false);
		messageDisplayContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		messageDisplayContainer.add(messageDisplayPane);
		
		
	}
}
