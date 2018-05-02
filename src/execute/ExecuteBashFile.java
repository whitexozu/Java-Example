package execute;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class ExecuteBashFile {

	public static void main(String[] args) {
		try {

			ProcessBuilder pb = new ProcessBuilder("/Users/whitexozu/dev/hadoop_workspace/javaExample/src/execute/test.sh");

			Map<String, String> env = pb.environment();
			// env.put("PATH", "myValue");
			// env.remove("OTHERVAR");
			// env.put("VAR2", env.get("VAR1") + "suffix");
			env.put("PATH", "/Users/whitexozu/dev/Apps/oozie-4.3.0/bin"
					+ ":/Users/whitexozu/dev/Apps/sqoop-1.4.6.bin__hadoop-2.0.4-alpha/bin"
					+ ":/Users/whitexozu/dev/Apps/apache-mahout-distribution-0.13.0/bin"
					+ ":/Users/whitexozu/dev/Apps/scala-2.11.8/bin"
					+ ":/Users/whitexozu/anaconda/bin"
					+ ":/Users/whitexozu/dev/Apps/apache-hive-2.1.1-bin/bin"
					+ ":/Users/whitexozu/dev/Apps/apache-maven-3.5.0/bin"
					+ ":/usr/local/Cellar/node/5.7.0/bin"
					+ ":/usr/bin"
					+ ":/bin"
					+ ":/usr/sbin"
					+ ":/sbin"
					+ ":/Users/whitexozu/dev/Apps/hadoop-2.7.3/bin"
					+ ":/Users/whitexozu/dev/Apps/hadoop-2.7.3/sbin"
					+ ":/Users/whitexozu/dev/Apps/spark-2.1.0-bin-hadoop2.7/bin");
			
			env.put("SPARK_HOME", "/Users/whitexozu/dev/dev/Apps/spark-2.1.0-bin-hadoop2.7");
			env.put("HADOOP_HOME", "/Users/whitexozu/dev/dev/Apps/hadoop-2.7.3");
			
			pb.directory(new File("/Users/whitexozu/dev/hadoop_workspace/javaExample/src/execute/"));

			File log = new File("/Users/whitexozu/dev/hadoop_workspace/javaExample/src/execute/log.txt");
			pb.redirectErrorStream(true);
			pb.redirectOutput(Redirect.appendTo(log));
			Process p = pb.start();
			p.waitFor();
			
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
		    char[] buf = new char[1024];
		    while (isr.read(buf) != -1) {
		        System.out.println(buf);
		    }
			
			System.out.println("Done");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
