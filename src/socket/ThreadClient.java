package socket;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ThreadClient {
	public static void main(String[] args) {
		Socket socket = null;
		GetThread gt = null;
		PostThread pt = null;
		
		String serverIp = "localhost";
		int serverPort = 12345;
		InetAddress inetaddr = null;
		
		try {
			inetaddr = InetAddress.getByName(serverIp); // IP
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			// [1]소켓구하기(클 : 자기ip, port : 임의 포트, 프로토콜(Socket-tcp)
			socket = new Socket(serverIp, serverPort);
			gt = new GetThread(socket);
			// pt = new PostThread(socket);

			gt.start(); // start()메소드가 하는일 : 1.run큐, sleep큐 준비.
			// pt.start(); // 2.run()메소드를 call함.

		} catch (Exception e) {
			System.out.println("소켓을 구하지 못했습니다." + e.getMessage());
		}
	}
}

// 네트워크로 받고 모니터로 출력.
class GetThread extends Thread {
	// 필드로 올리면 힙으로 올라가기때문에 this로 접근 가능
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private Socket socket = null;
	private PrintWriter monitor = null;
	private PrintWriter pw = null;

	// 생성자 함수.
	public GetThread(Socket socket) {
		try {
			JSONObject jo = new JSONObject();
			jo.put("team", new Integer(3)); 
			jo.put("hi", "hello");
			String strJson = JSONValue.toJSONString(jo.toString());
//			String strJson = "123123";
			
			System.out.println("strJson : " + strJson);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			pw.println(strJson);
			pw.flush();
			
			// [1]네트워크로 받기.
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// [2]모니터로 출력.
			// OutputStreamWriter osw = new OutputStreamWriter(System.out);
			// this.monitor = new PrintWriter(osw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String msg = null;
			while ((msg = this.br.readLine()) != null) {
				System.out.println(">>>" + msg);
				// this.monitor.println(msg);
				// this.monitor.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 키보드로 받고 네트워크로 출력.
class PostThread extends Thread {
	private PrintWriter pw = null;
	private BufferedReader keyboard = null;

	public PostThread(Socket socket) {
		try {
			OutputStream os = socket.getOutputStream();
			this.pw = new PrintWriter(new OutputStreamWriter(os));

			InputStreamReader isr = new InputStreamReader(System.in);
			this.keyboard = new BufferedReader(isr);
		} catch (Exception e) {
			System.out.println("예외" + e.getMessage());
		}
	}

	public void run() {
		try {
			// 동시작업 쓰레드 코드
			String msg = null;
			while ((msg = keyboard.readLine()) != null) {
				if (msg.equals("quit"))
					break;
				this.pw.println(msg);
				this.pw.flush();
			}
		} catch (Exception e) {

		} finally {
			try {
				pw.close();
				keyboard.close();
			} catch (Exception e) {
			}
		}
	}
}

//javac -cp /Users/whitexozu/dev/hadoop_workspace/javaExample/lib/json-simple-1.1.1.jar:./ -d . ThreadClient.java
//java -cp "/Users/whitexozu/dev/hadoop_workspace/javaExample/lib/json-simple-1.1.1.jar:./" socket.ThreadClient