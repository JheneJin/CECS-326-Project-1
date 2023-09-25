import java.net.*;
import java.io.*;
import java.util.Scanner;

public class QuoteClient {
    public static void run() {
        try {
            //links to server socket
            Socket serverSocket = new Socket("localhost", 6017);
            
            //captures server output (PrintWriter)
            BufferedReader serverOutput = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            String quote = serverOutput.readLine();

            System.out.println(quote);

            //close the socket
            serverSocket.close();

        }
        //incase of error
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
