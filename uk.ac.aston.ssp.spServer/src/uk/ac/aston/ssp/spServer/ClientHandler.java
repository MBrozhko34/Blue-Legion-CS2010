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
	private Server server;
	private Double clientID;
	
	
	/**
	 * ClientHandler constructor
	 * 
	 * @param clientSocket is passed by the Server once a client connection is made
	 * @throws IOException
	 */
	public ClientHandler(Socket clientSocket, Double clientID) throws IOException{
		this.client = clientSocket;
		this.clientID = clientID;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
	}
	
	/**
	 * This method acts as a single Thread for each client, When the server accepts a client connection
	 * the server will call the ClientHandler class which will run this method.
	 * <p>
	 * This method reads in the client request and creates a server acknowledgement response
	 * which is then sent to the client.
	 */
	
	@Override
	public void run() {
		System.out.println("Launching new Thread for Client[" + client + "]");
		System.out.println();
			try {
				
				
				while(true){
				
					String clientRequest = in.readLine();
					
					if(clientRequest == null || clientRequest.equals("quit")){
						client.close();
						out.println("[SERVER]: Client connection terminated");
						System.out.println("Client " + client + "has disconnected");
						System.out.println();
						
						client.close();
						
						server.getClientList().remove(clientID);
						
						break;
						
					}
					out.println("[SERVER]: Client request " + clientRequest + " recieved");
				}

			}catch(IOException e) {
					
				System.err.println("IO exception in client handler");
				System.err.println(e.getStackTrace());
					
			}
		}
}
