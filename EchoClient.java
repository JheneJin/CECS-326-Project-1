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
		try{
		Socket s = new Socket("localhost", 6007);
		// send data to the socket's output stream, going to the server side
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		//wraps around inputstreamreader by reading in large chunks instead of one character at a time
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//makes life easier?
        // BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Plrease Enter text: ");
			String input = scan.nextLine();
			if ("exit".equalsIgnoreCase(input)){
				break;
			}
			out.println(input);
			//takes input from the server side
			String response = in.readLine();
			System.out.println("server response is: " + response);
		}
	} catch (IOException e){
		e.printStackTrace();
	}
	}
}
