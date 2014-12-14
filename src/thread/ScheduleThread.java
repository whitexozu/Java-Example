package thread;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScheduleThread {
	
	private static ArrayList<Object> mArrayList;
	
	public static void setSchedule(){
		mArrayList = new ArrayList<Object>();
		mArrayList.add(new String[]{"U,http://www....."});
		mArrayList.add(new String[]{"J,javascript:...1"});
		mArrayList.add(new String[]{"J,javascript:...2-1", "J,javascript:...2-2", "J,javascript:...2-3"});
		mArrayList.add(new String[]{"J,javascript:...3", "S,sleep:3"});
		mArrayList.add(new String[]{"J,javascript:...4", "S,sleep:2"});
		mArrayList.add(new String[]{"J,javascript:...5"});
		mArrayList.add(new String[]{"A"});
		mArrayList.add(new String[]{"U,http://www....."});
		mArrayList.add(new String[]{"J,javascript:...6"});
		mArrayList.add(new String[]{"J,javascript:...7-1", "J,javascript:...7-2"});
		mArrayList.add(new String[]{"J,javascript:...8", "S,sleep:3"});
		mArrayList.add(new String[]{"A"});
		mArrayList.add(new String[]{"U,http://www....."});
		mArrayList.add(new String[]{"J,javascript:...9", "S,sleep:5"});
	}
	
	public static void runSchedule(int sNum){
//		System.out.println(mArrayList.get(sNum).getClass());
//		System.out.println(mArrayList.get(sNum) instanceof String);
//		System.out.println(mArrayList.get(sNum) instanceof String[]);
		
		
		
//		System.out.println(mArrayList.get(sNum));
		if(sNum < mArrayList.size()){
			new ScheduleRunThread(mArrayList.get(sNum), sNum).start();
		}
	}
	
	public static void main(String[] args) {
		setSchedule();
		runSchedule(0);
	}
}
