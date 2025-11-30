import java.io.*;
import java.math.BigInteger;
import java.util.Random;
public class RSA{
    BigInteger p, q, N, phi, e, d;
    Random r = new Random();
    RSA() {
        int bits = 512; 
        p = BigInteger.probablePrime(bits, r);
        q = BigInteger.probablePrime(bits, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bits / 2, r);
        while (!phi.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }
    byte[] encrypt(byte[] msg) {
        return new BigInteger(msg).modPow(e, N).toByteArray();
    }
    byte[] decrypt(byte[] msg) {
        return new BigInteger(msg).modPow(d, N).toByteArray();
    }
    static String bytesToString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte x : b) sb.append(x);   // exact same output format
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        RSA rsa = new RSA();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the plain text:");
        String text = br.readLine();
        System.out.println("Encrypting String: " + text);
        System.out.println("String in Bytes: " + bytesToString(text.getBytes()));
        byte[] enc = rsa.encrypt(text.getBytes());
        byte[] dec = rsa.decrypt(enc);
        System.out.println("Decrypting Bytes: " + bytesToString(dec));
        System.out.println("Decrypted String: " + new String(dec));
    }
}