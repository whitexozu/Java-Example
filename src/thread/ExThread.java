package thread;

import java.util.ArrayList;

public class ExThread {
	
	public static void main(String[] args) {
		System.out.println("Main Thread Start");
		for (int i = 0; i < 10; i++) {
			new ChildThread().start();
		}
		System.out.println("Main Thread End");
	}
}
