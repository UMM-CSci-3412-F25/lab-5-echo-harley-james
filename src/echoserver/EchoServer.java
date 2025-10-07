package echoserver;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(portNumber);

            while(true) {
                Socket client = sock.accept();
                System.out.println("bwoop");

                OutputStream out = client.getOutputStream();
                InputStream in = client.getInputStream();
                int curr;
                while ((curr = in.read()) != -1) {
                    out.write(curr);
                }
                out.flush();
                client.close();
            }
        } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
    }
}