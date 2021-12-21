import java.io.*;
import java.net.*;
import java.util.Timer;

public class General2 {
	static int PORT = 5000;
	static DatagramSocket socket;
	static DatagramPacket sendpacket;
	static DatagramPacket recvpacket;
	static String msg = "Commander:고현석";
	static String general2 = "<general2 : 홍길동>";
	
    public static void main(String[] args) throws IOException{
    	byte[] recvbuf;
    	byte[] sendbuf;
    	
    	// n >= 3f+1 : 합
    	try {
    		socket = new DatagramSocket();
    		System.out.println("General2 생성");
    		InetAddress hostAddr = InetAddress.getByName("localhost");	
    		
    		recvbuf = new byte[1000];
    		sendbuf = new byte[1000];
    		
    		// 1전
    		sendbuf = "2".getBytes();
    		sendpacket = new DatagramPacket(sendbuf, sendbuf.length, hostAddr, PORT);
    		socket.send(sendpacket);
    		
    		/// 합의 시작
    		recvpacket = new DatagramPacket(recvbuf, recvbuf.length, hostAddr, PORT);
            socket.receive(recvpacket);
            System.out.println("General2: Commander로부터 합의 명령을 받았습니다.");
            
            
            sendbuf = general2.getBytes();
            sendpacket = new DatagramPacket(sendbuf, sendbuf.length, hostAddr, PORT);
            socket.send(sendpacket);

    		socket.close();
    	}catch(SocketException e) {
    		e.printStackTrace();
    	}
    }

}
