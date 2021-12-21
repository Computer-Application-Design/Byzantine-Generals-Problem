import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

class Commander {
	static int PORT = 5000;
	static Semaphore mutex;
	static DatagramSocket socket;
	static DatagramPacket packet;
	static String msg = "Commander:고현석";
	static HashMap<Character, Integer> agreement;
	static int bc = 1;
	static int nodeNum = 0;
	
    public static void main(String[] args) throws IOException{
    	mutex = new Semaphore(1);
    	
    	byte[] buf = new byte[1000];
    	agreement = new HashMap<Character, Integer>();
    	agreement.put('n', 3);
    	agreement.put('f', 0);
    	
    	// n >= 3f+1 : 합
    	try {
    		socket = new DatagramSocket(PORT);
    		System.out.println("General을 기다리는 중...");
    		
    		while(true) {
    			packet = new DatagramPacket(buf, buf.length);
    			socket.receive(packet);
    			String account = new String(packet.getData());
    			System.out.println(account);
    			nodeNum++;
    			
    			if(nodeNum == 1)
    				break;
    		}
    		
    		
    		
    		
    		while(true) {
    			InetAddress hostAddr = packet.getAddress();
        		try {
        			if(bc==1) {
        				System.out.println("합의를 시작합니다.");
        				broadcast(socket, msg, hostAddr);
        				bc = 0;
        			}
        			byte[] recvBuf = new byte[1000];
        			
        			
        			mutex.acquire();
        			
        			DatagramPacket dPacket = new DatagramPacket(recvBuf, recvBuf.length);
            		socket.receive(dPacket);
            		String str = new String(dPacket.getData());
            		
            		System.out.println(str);
            		
            		if(str.substring(12) == "홍길동") {
            			int byzantine = agreement.get('f');
            			byzantine++;
            			agreement.replace('f', byzantine);
            		}
            		
            		nodeNum--;
            		mutex.release();
        		}catch(InterruptedException e) {
        			e.printStackTrace();
        		}
        		if(nodeNum == 0)
        			break;
    		}
    		int result = agreement.get('n') - ( 3*agreement.get('f') + 1 );
    		System.out.println(result);
    		
    		if(result >= 0)
    			System.out.println("합의 결과: 합의 가능");
    		else
    			System.out.println("합의 결과: 합의 불가능");
    		
    		socket.close();
    	}catch(SocketException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void broadcast(DatagramSocket sock, String broadcastMessage, InetAddress address) throws IOException {
    	sock.setBroadcast(true);

    	byte[] buffer = broadcastMessage.getBytes();
    	
    	packet = new DatagramPacket(buffer, buffer.length, address, PORT);
    	sock.send(packet);
    	System.out.println("합의 메세지 전송");
    }
}
