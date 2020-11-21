package uk.ac.aston.ssp.spServer;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 * This class listens for client connections to accept and then pass to the ClientHandler
 * 
 * @author Blue Legion
 * 
 * @since November 2020
 */

public class Server {

	/*
	 * Manually initialising the SERVER PORT NUMBER
	 */

	private static final int SERVER_PORT = 43221;
	
	/*
	 * HashMap that the Server uses to store each client and their associated clientID
	 */
	private static HashMap<Double, ClientHandler> clientList = new HashMap<Double, ClientHandler> (); 
	
	public static void main(String[] args) throws IOException {
	
		//Creating ServerSocket object that the server will listen on for client connections on the specified PORT
		ServerSocket listener = new ServerSocket(SERVER_PORT);
		
		System.out.println("[SERVER] Waiting for client connections... ");
		
		while(true) {
			
			// Server accepts client connection
			Socket clientSocket = listener.accept();
			System.out.println("[SERVER] Connected to client ");
			
			//ClientHandler object is created to create a separate thread for the client.
			ClientHandler clientThread = new ClientHandler(clientSocket);
			clientThread.start();
			
			clientList.put(generateClientID(), clientThread);
			System.out.println("Client List: " + getClientList());
		
		}	

	}
	/*
	 * generateClientID() Method to randomly generate a unique identifier for each client.
	 */
	public static double generateClientID() {
		double clientID = Math.random();
		if(clientList.containsKey(clientID)) {
			
			clientID = Math.random();
		}
		return clientID;
	}
	
	/*
	 * 
	 */
	
	public static HashMap<Double, ClientHandler> getClientList() {
		
		return clientList;
	}
	
	

}
