package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 1 대 1 소켓 통신 클라이언트 예제
 */
public class Client {

	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;

	public Client(String ip, int port) {
		try {
			socket = new Socket(ip, port);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 메세지 전달
//			bw.write("응답하라!!");
//			bw.flush();

			// 응답 출력
			System.out.println(br.readLine());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// 소켓 닫기 (연결 끊기)
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {

		String ip = "localhost";
		int port = 12345;

		new Client(ip, port);
	}
}
