import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class QuoteServer {

    //creates quotes array
    String[] quotes = new String[5];
    //When object is constructed it pushes quotes into quotes array.
    QuoteServer() {
        quotes[0] = "We cannot solve problems with the kind of thinking we employed when we came up with them. — Albert Einstein";
        quotes[1] = "Learn as if you will live forever, live like you will die tomorrow. — Mahatma Gandhi";
        quotes[2] = "Success is not final; failure is not fatal: It is the courage to continue that counts. — Winston S. Churchill";
        quotes[3] = "It is better to fail in originality than to succeed in imitation. — Herman Melville";
        quotes[4] = "Success usually comes to those who are too busy looking for it. — Henry David Thoreau";
    }
    
    private String getQuote() {
        //gets date and turns it into day of the month
        Date today = new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd");
        String dayOfMonthString = dateFormater.format(today);
    
        //turns day of month into string called day
        int day = Integer.parseInt(dayOfMonthString);
        
        //uses modulo to make cycle and ruturns quote
        int quoteOfDay = (day) % 5;
        return quotes[quoteOfDay]; 
    }

    public static void runServer() {
        try {
            //creates server socket and waits for client to connect
            ServerSocket serverSocket = new ServerSocket(6017);
            Socket clientSocket = serverSocket.accept();

            //creates PrintWriter to send quote to client
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            
            //gets quote and sends to client
            QuoteServer dailyQuotes = new QuoteServer();
            String quote = dailyQuotes.getQuote();

            output.println(quote);
            
            //close PrintWriter and socket
            output.close();
            clientSocket.close();
        }
        //incase of error
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
