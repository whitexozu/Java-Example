package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample {
	public static void main(String[] args) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {

			String content = "This is the content to write into file";

			File file = new File("filename.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(content);
			
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}
}
