
public class main {
    public static void main(String args[]) {
        //creates and runs server
        Multithread server = new Multithread(); 
        server.start();
        //creates and runs client
        QuoteClient client = new QuoteClient();
        client.run();
    }
}
