/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
// socket
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClient
{	
	// everything goes to the server side
	public static void main(String[] args) throws IOException {
		//create a socket called s on port 6007
		Socket s = new Socket("localhost", 6007);
		// send data to the socket's output stream(client), going to the server side
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		//take in data efficiently using InputStreamReader
		//recieve data from the socket's input stream(server), coming into the client side
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//creates a new scanner object for client input
		Scanner scan = new Scanner(System.in);
		//keeps asking for the client input of the user
		System.out.println("To disconnect the server from the client, enter the word LEAVE in all caps.");
		// loops while the input doesnt equal LEAVE, which is flagged and break through the if case
		while (true) {
			//asks the user to enter input
			System.out.print("Please Enter Text: ");
			//gets the client input
			String clientInput = scan.nextLine();
			//exits the loop if user inputs LEAVE
			if (clientInput.equals("LEAVE")){
				System.out.println("Socket closed");
				break;
			}
			//sends socket output stream, which goes go to the server socket
			out.println(clientInput);
			//takes input from the server side (which is the echo)
			String response = in.readLine();
			System.out.println("Server echoes back: " + response);
		}
	}
}
