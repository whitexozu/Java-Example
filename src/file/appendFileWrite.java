package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class appendFileWrite {

	public static void main(String[] args) {
		PrintWriter out = null;
		try {
		    out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Dev/workspace/javaExample/src/file/log2.txt", true)));
		    out.println("the text");
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		} finally {
			out.close();
		}
	}

}
