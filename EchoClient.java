/**
import java.io.*;

public class  EchoServer
{
    //goes to the client side
    public static void main(String[] args) throws IOException {
        try {
        //creates server socket
		ServerSocket ss = new ServerSocket(6007);
        // connects both client and server sockets initialized as s(not to be confused with the other socket s on the client side)
        Socket s = ss.accept();
        //when it connects this message is prompted
        System.out.println("client connected");
        // send data to the socket's output stream(server), going to the client side
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //recieve data to the socket's input stream(client), coming to the server side
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String clientInput; 
        //loops echos between the server and client side until the user enters LEAVE or enters a blank space
        //gets the client's input
        while((clientInput = in.readLine()) != "LEAVE"){
            //prints out the clientInput on the server
            System.out.println("On Server :" + clientInput);
            //echos back to the client
            out.println(clientInput);
            }
        } 
        //catches socket closed error, and makes the console output more clear
        catch (SocketException e) {
            System.out.println("Client disconnected because they entered the word LEAVE");
        }   
	}
}
