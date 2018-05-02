package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] SM_INFO = {
			{"김지훈", "01056441868", "S009490"}
			,{"최용석", "01022657017", "3315136"}
			,{"최수영", "01087323065", "3329225"}
			,{"나호경", "01052056759", "T000507"}
			,{"이문희", "01073390403", "T002569"}
			,{"김창순", "01086525655", "T000944"}
			,{"김현숙", "01095227780", "T002061"}
		};
		
		List<String[]> list = null;
		list = new ArrayList<String[]>(Arrays.asList(SM_INFO));
		
		for(String[] arr : list) {
//			System.out.println(arr);
			System.out.println(Arrays.asList(arr));
		}
	}

}
