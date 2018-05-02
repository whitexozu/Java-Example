package linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinuxCommander {
	public static void main(String[] args) {
		LinuxCommander lc = new LinuxCommander();
		System.out.println("========== start ==========");
		try {
			String output = lc.executeCommand("/fsdata/batch/work/script/test/src/test.sh");
//			String output = lc.executeCommand("/fsdata/batch/work/script/compare/src/compareStt2Db.sh S seoul 20180322000000 20180322085959");
			
//			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("========== finish ==========");
	}
	
	public String executeCommand(String command) throws Exception {
		StringBuffer errOutPut = new StringBuffer();
		StringBuffer intOutput = new StringBuffer();

		Process p;
		BufferedReader error = null;
		BufferedReader reader = null;
		try {
			p = Runtime.getRuntime().exec(command);
			String line = null;
			
			error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = error.readLine()) != null) {
				errOutPut.append(line + "\n");
			}
			
			int wf = p.waitFor();
			System.out.println("wf : " + wf);
			int ev = p.exitValue();
			System.out.println("ev : " + ev);
//			output.append("Process exit code is [" + p.exitValue()	+ "]" + "\n");
			
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = reader.readLine()) != null) {
				intOutput.append(line + "\n");
			}
			System.out.println("errOutPut : " + errOutPut.toString());
			System.out.println("errOutPut index : " + errOutPut.toString().indexOf("Exception"));
			System.out.println("intOutput : " + intOutput.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			error.close();
			reader.close();
		}

		return intOutput.toString();
	}
}
