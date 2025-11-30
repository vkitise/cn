import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4000);
        System.out.println("Server ready...");
        Socket sock = server.accept();
        System.out.println("Client connected.");
        BufferedReader in = new BufferedReader( new InputStreamReader(sock.getInputStream()));
        String fname = in.readLine();       // get filename
        BufferedReader file = new BufferedReader(new FileReader(fname));
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        String line;
        while ((line = file.readLine()) != null)
            out.println(line);
        file.close();
        in.close();
        out.close();
        sock.close();
        server.close();
    }
}