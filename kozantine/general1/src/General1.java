import java.io.*;
import java.net.*;

public class General1 {
	static int PORT = 5000;
	static DatagramSocket socket;
	static DatagramPacket sendpacket;
	static DatagramPacket recvpacket;
	static String msg = "Commander:고현석";
	static String general1 = "<general1 : 고현석>";
	
    public static void main(String[] args) throws IOException{
    	byte[] recvbuf;
    	byte[] sendbuf;
    	
    	// n >= 3f+1 : 합
    	try {
    		socket = new DatagramSocket();
    		System.out.println("General1 생성");
    		InetAddress hostAddr = InetAddress.getByName("localhost");	
    		
    		recvbuf = new byte[1000];
    		sendbuf = new byte[1000];
    		recvpacket = new DatagramPacket(recvbuf, recvbuf.length, hostAddr, PORT);
    		
    		// 1전
    		sendbuf = "1".getBytes();
    		sendpacket = new DatagramPacket(sendbuf, sendbuf.length, hostAddr, PORT);
    		socket.send(sendpacket);
    		
    		/// 합의 시작
    		
            socket.receive(recvpacket);
            System.out.println("General1: Commander로부터 합의 명령을 받았습니다.");
            
            sendbuf = general1.getBytes();
            sendpacket = new DatagramPacket(sendbuf, sendbuf.length, hostAddr, PORT);
            socket.send(sendpacket);

    		socket.close();
    	}catch(SocketException e) {
    		e.printStackTrace();
    	}
    }

}
