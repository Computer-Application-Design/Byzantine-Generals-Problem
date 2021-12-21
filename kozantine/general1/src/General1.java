import java.io.*;
import java.net.*;

public class General1 {
	static int PORT = 5000;
	static DatagramSocket socket;
	static DatagramPacket packet;
	static String msg = "Commander:고현석";
	static String general1 = "<general1 : 고현석>";
	
    public static void main(String[] args) throws IOException{
    	byte[] recvbuf = new byte[1000];
    	byte[] sendbuf;
    	
    	// n >= 3f+1 : 합
    	try {
    		socket = new DatagramSocket();
    		System.out.println("General1 생성");
    		InetAddress hostAddr = InetAddress.getByName("localhost");	
    		
    		sendbuf = "1".getBytes();
    		packet = new DatagramPacket(sendbuf, sendbuf.length);
    		socket.send(packet);
    		
        	packet = new DatagramPacket(recvbuf, recvbuf.length);
            socket.receive(packet);
            System.out.println("General1: Commander로부터 합의 명령을 받았습니다.");
            
            sendbuf = general1.getBytes();
            packet = new DatagramPacket(sendbuf, sendbuf.length, hostAddr, PORT);
            socket.send(packet);

    		socket.close();
    	}catch(SocketException e) {
    		e.printStackTrace();
    	}
    }

}
