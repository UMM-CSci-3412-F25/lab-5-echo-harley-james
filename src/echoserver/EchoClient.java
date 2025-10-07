package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException {
        String server;
        if (args.length == 0) {
            server = "127.0.0.1";
        } else {
            server = args[0];
        }
// System.out.println("hello? is anyone there?");
        try {
            // System.out.println("started running client");
            Socket socket = new Socket(server, portNumber);
            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();
            int out;
            int curr;
            while ((out = System.in.read()) != -1) {
                output.write(out);
                if ((curr = input.read()) != -1) {
                    System.out.write(curr);
                }
                
            }
            // System.out.println("Reached end of input");
            output.flush();
            input.close();        
            output.close();
            socket.close();

        } catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }

    }
}