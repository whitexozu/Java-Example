package thread;

import java.util.Random;

public class ChildThread extends Thread {
	private volatile boolean running = true;
    public static int _TOTAL = 0;
    public int mCurrentNumber = -1;
    public int mLogCount = 0;
    
    public ChildThread() {
        mCurrentNumber = ++_TOTAL;
    }
    
    public void terminate() {
    	running = false;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            try {
//            	if(mLogCount > 5) terminate();
                int randNum = random.nextInt(10);
                System.out.println(mCurrentNumber +    
                        " Thread Log // Count : " +    (mLogCount++) +
                        " // randNum : " + randNum);
                Thread.sleep(randNum * 1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
