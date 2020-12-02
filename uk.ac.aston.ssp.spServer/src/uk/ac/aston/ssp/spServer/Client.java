package uk.ac.aston.ssp.spServer;

import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
	
	/*
	 * SERVER_IP & SERVER_PORT point to the single SERVER, in this case it points to the
	 * localhost address since the server is running on the same machine. The Port refers
	 * to the manually set PORT in the SERVER class.
	 */
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 43221;
	
	private static Client clientID;
	
	public static void main(String[] args) throws IOException{
		try(
				
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		){
			
		//Reads userInput
		System.out.println("INTER USER INPUT");
		String userInput = stdIn.readLine();
		String serverResponse;
		
		while(userInput != null) {
			
			System.out.println("request: " + userInput);
			//Sends out client request
			out.println(userInput);
			//Prints Server's response
			serverResponse = in.readLine();
			System.out.println(serverResponse);
			System.out.println();
			userInput = stdIn.readLine();
			
			}
		
		
		}catch(UnknownHostException e) {
			
			System.out.println("Unknown host Exception");
			System.exit(1);
			
		}catch(IOException e) {
			System.out.println("Coudn't get I/O for the connection to host");
			System.exit(1);
		}
		
	}
	


}
