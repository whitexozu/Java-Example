package execute;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShellComand {

	public static void main(String[] args) {

		ExecuteShellComand obj = new ExecuteShellComand();

		String domainName = "google.com";

		// in mac oxs
//		String command = "ping -c 3 " + domainName;
		String command = "/Users/whitexozu/dev/Apps/spark-2.1.0-bin-hadoop2.7/bin/spark-submit /Users/whitexozu/dev/pycharm_workspace/pythonExample/spark/extractionIVTable/createIVTable.py yarn 201709";

		// in windows
		// String command = "ping -n 3 " + domainName;

		String output = obj.executeCommand(command);

		System.out.println(">>>" + output);
		
		System.out.println("done");

	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			
			System.out.println("finish executeCommand");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

}