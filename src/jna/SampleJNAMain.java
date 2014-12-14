package jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * JNA ���� �ڵ� �ۼ�
 */
public class SampleJNAMain {
	// DLL �ε�
	static {
		System.loadLibrary("mfcdll1");
	}

	public interface SampleJNA extends Library {
		public int MyFunc(int a, int b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleJNA sample = (SampleJNA) Native.loadLibrary("mfcdll1", SampleJNA.class);
		System.out.println("Result = " + sample.MyFunc(2, 3));
	}
}
