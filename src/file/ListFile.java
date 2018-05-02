package file;

import java.io.File;
import java.io.IOException;

public class ListFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initialize File object
		File file = new File("/Users/whitexozu/dev/batch/TA/work/script/extraction/temp2");

		// check if the specified pathname is directory first
		System.out.println(">>>" +file.isDirectory());
		if (file.isDirectory()) {
			// list all files on directory
			File[] files = file.listFiles();
			for (File f : files) {
				try {
					System.out.println(f.getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
