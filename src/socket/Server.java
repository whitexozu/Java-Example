package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1 대 1 소켓 통신 서버 예제
 */
public class Server {
    private ServerSocket mServerSocket;
    private Socket mSocket;

    private BufferedReader mIn;    // 들어오는 통로
    private PrintWriter mOut;  // 나가는 통로

    public Server() {
        try {
            mServerSocket = new ServerSocket(5555);
            System.out.println("서버 시작!!!");
            // 스레드가 멈춰 있고

            // 연결 요청이 들어오면 연결
            mSocket = mServerSocket.accept();
            System.out.println("클라이언트와 연결 됨");

            mIn = new BufferedReader(
                    new InputStreamReader(mSocket.getInputStream()));

            mOut = new PrintWriter(mSocket.getOutputStream());

            // 클라이언트에서 보낸 문자열 출력
            System.out.println(mIn.readLine());

            // 클라이언트에 문자열 전송
            mOut.println("전송 잘 되었음");
            mOut.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 소켓 닫기 (연결 끊기)
            try {
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                mServerSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
