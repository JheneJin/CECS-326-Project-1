/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */
// buffer
// uses Buffered Reader
// INput Stream
import java.net.*;
import java.io.*;

public class  EchoServer{
    //goes to the client side
    public static void main(String[] args) throws IOException {

        try {
        //creates server socket
		ServerSocket ss = new ServerSocket(6007);
        // connects both client and server sockets initialized as s(not to be confused with the other socket s on the client side)
        Socket s = ss.accept();
        //when it connects this message is prompted
        System.out.println("Client Connected to Server");
        // send data from the socket's output stream(server), going to the client side
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //send data to the socket's input stream(server), coming from the client side
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String clientInput; 
        //loops echos between the server and client side until the user enters LEAVE or enters a blank space
        //gets the client's input(client output stream) into the server socket input streamm
        while((clientInput = in.readLine()) != "LEAVE"){
            //prints out the clientInput on the server
            System.out.println("On Server :" + clientInput);
            //echos back to the client from the server side
            out.println(clientInput);
            }
        } 

        // //catches socket closed error, and makes the console output more clear
        // catch (SocketException e) {
        //     System.out.println("Client disconnected because they entered the word LEAVE");
        // }   

        catch(IOException e){
            System.out.println("Client disconnected because they entered the word LEAVE");
        }
	}
}
