package uk.ac.aston.ssp.spServer;

import java.net.*;
import java.io.*;
import java.util.*;

	/**
	 * "ClientHandler" class is responsible for initiating dedicated threads to each client connections
	 * Once the client sends a request the server will send a ACK response.
	 */

public class ClientHandler extends Thread {
	
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	public String serverResponse;
	
	
	public ClientHandler(Socket clientSocket) throws IOException{
		
		this.client = clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream());
	}

	@Override
	public void run() {
		
		System.out.println("Launching new Thread for Client[" + client + "]");
		
		while(true) {
			
		try {
	
			String clientRequest = in.readLine();
			
			String serverResponse = "[SERVER]: Client request " + "[" + clientRequest + "]" + " recieved!";
					
			out.println(serverResponse);

	
		}catch(IOException e) {
			
			System.err.println("IO exception in client handler");
			System.err.println(e.getStackTrace());
		
			
		}
		
		}
		
	}
	
}
