import java.net.*;
import java.io.*;

class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9876);
        byte[] recv = new byte[1024];
        byte[] send;

        DatagramPacket rp = new DatagramPacket(recv, recv.length);
        server.receive(rp);
        String msg = new String(rp.getData()).trim();
        System.out.println("RECEIVED: " + msg);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Message");
        String reply = br.readLine();

        send = reply.getBytes();
        DatagramPacket sp = new DatagramPacket(send, send.length, rp.getAddress(), rp.getPort());
        server.send(sp);

        server.close();
    }
}