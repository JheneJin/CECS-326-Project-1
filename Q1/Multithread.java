
class Multithread extends Thread {
    //When it runs QuoteServer is made and ran
    public void run() {
        QuoteServer server = new QuoteServer();
        server.runServer();
    }
}
