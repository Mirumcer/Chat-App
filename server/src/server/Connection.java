package server;

import java.net.Socket;

public class Connection {
	public Socket socket;
	public int clientId;
	
	public Connection(Socket socket, int clientId) {
		// we set our unique connection properties
		this.socket = socket;
		this.clientId = clientId;
	}
}
