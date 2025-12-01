import java.net.*;
import java.io.*;

class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        byte[] send = "Hello Server".getBytes();
        byte[] recv = new byte[1024];

        DatagramPacket sp = new DatagramPacket(send, send.length, ip, 9876);
        client.send(sp);

        DatagramPacket rp = new DatagramPacket(recv, recv.length);
        client.receive(rp);

        System.out.println("FROM SERVER:" + new String(rp.getData()).trim());
        client.close();
    }
}