package thread;

import java.util.logging.Logger;

public class ScheduleRunThread extends Thread {
	private volatile boolean running = true;
    public static String[] strArray;
    public static int sNum;
    
    public ScheduleRunThread(Object obj, int sNum) {
    	this.strArray = (String[])obj;
    	this.sNum = sNum;
    }
    
    public void terminate() {
    	running = false;
    }
    
    @Override
    public void run() {
    	System.out.println(sNum + " thread start");
        while (running) {
            try {
               for(String s : strArray){
            	   System.out.println("\ts substring : "+s.substring(0, 1));
            	   if(s.substring(0, 1).equals("S")){
            		   System.out.println("\tsleep : " + s.substring(2).split(":")[1]);
            		   Thread.sleep(Integer.parseInt(s.substring(2).split(":")[1]) * 1000);
            	   }else if(s.substring(0, 1).equals("J")){
            		   System.out.println("\tjavascript : " + s.substring(2));
            	   }else if(s.substring(0, 1).equals("A")){
            		   System.out.println("\tchange air port");
            	   }else if(s.substring(0, 1).equals("U")){
            		   System.out.println("\turl : " + s.substring(2));            		   
            	   }
               }
               terminate();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(sNum + " thread end");
        ScheduleThread.runSchedule(sNum + 1);
    }
}
