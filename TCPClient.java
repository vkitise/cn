import java.net.*;
import java.io.*;
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("127.0.0.1", 4000);
        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("Enter file name: ");
        String fname = keyboard.readLine();
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        out.println(fname);     // send filename
        BufferedReader in = new BufferedReader(
                new InputStreamReader(sock.getInputStream()));
        String line;
        while ((line = in.readLine()) != null)
            System.out.println(line);
        in.close();
        out.close();
        keyboard.close();
        sock.close();
    }
}