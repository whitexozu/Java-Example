package socket;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadServer {

	public final static int PORT = 12345;

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(50);
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try{
					Socket connection = server.accept();
					Callable<Void> task = new DaytimeTask(connection);
					pool.submit(task);
				}catch(IOException e){}
			}
		}catch(IOException e){
			System.err.println("스타트 서버에 연결할 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	private static class DaytimeTask implements Callable<Void> {
		
		private Socket connection = null;
		private boolean flag = false;
		private BufferedReader br = null;
		private BufferedWriter bw = null;
		
		DaytimeTask(Socket connection) throws IOException {
			this.connection = connection;
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
		}
	
		public Void call() throws IOException{
			try{
				String msg = br.readLine();
				System.out.println(">>>>" + msg);
				
				while (!this.flag) {
					try {
						Thread.sleep(1000); 
						Date now = new Date();
//							this.bw.write(now.toString() + msg + "\r\n");
						this.bw.write(now.toString() + "\r\n");
						this.bw.flush();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

//					String msg = br.readLine();
//					if ( msg != null && !msg.equals("") ) {
//						Date now = new Date();
//						this.bw.write(now.toString() + msg + "\r\n");
//						this.bw.flush();
//					} else {
//						this.flag = true;
//					}
				}
			}catch(IOException e){
				System.err.println(e);
			}finally{
				br.close();
				bw.close();
				connection.close();
			}
			return null;
		}
	}
}

//javac -cp . -d . ThreadServer.java
//java -cp . socket.ThreadServer