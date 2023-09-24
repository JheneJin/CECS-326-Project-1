/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */
// buffer
// uses Buffered Reader
// INput Stream
import java.net.*;
import java.io.*;

public class  EchoServer
{
    //goes to the client side
    public static void main(String[] args) throws IOException {
        try {
        //creates server socket
		ServerSocket ss = new ServerSocket(6007);
        // connects socket s to server socket
        Socket s = ss.accept();
        //when it connects this message is prompted
        System.out.println("client connected");
        // send data to the socket's output stream, going to the client side
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //reads input from socket
        //helps read the data in chracter level, goes to the client side
        //wraps around inputstreamreader by reading in large chunks instead of one character at a time
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //gets the client's input
        String clientInput;
        while((clientInput= in.readLine()) != null){
            //prints out the clientInput on the server
            System.out.println("On Server :" + clientInput);
            //echos back to the client
            out.println(clientInput);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
	}

}
