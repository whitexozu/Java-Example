package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 폴더 안에 있는 파일들을 다른 폴더로 옮기는 샘플
		 */

		// 이동전의 폴더
		String inFolder = "C:/Users/BLOW/Downloads/tmp1/tmp1/org";
		// 이동후의 폴더
		String outFolder = "C:\\Users\\BLOW\\Desktop";

		// 이동전의 폴더에 있는 파일들을 읽는다.
		List<File> dirList = getDirFileList(inFolder);

		// 폴더의 사이즈만큼 돌면서 파일을 이동시킨다.
		for (int i = 0; i < dirList.size(); i++) {
			// i번째 저장되어 있는 파일을 불러온다.
			String fileName = dirList.get(i).getName();

			// 파일 삭제를 원한다면
			// fileDelete(inFolder+"\\"+fileName);

			// 파일 복사을 원한다면
			// fileCopy(inFolder+"\\"+fileName, outFolder+"\\"+fileName);

			// 파일 이동을 원한다면
			// fileMove(inFolder+"\\"+fileName, outFolder+"\\"+fileName);

			// 파일 생성을 원한다면
			// fileMake("C:/Users/INTERPARK/Desktop/test.txt");
		}

		String makeFile = "C:/Users/INTERPARK/Desktop/test.txt";

		// 파일의 존재 여부 확인
		if (fileIsLive(makeFile)) {
			// 파일이 존재할땐 파일을 불러옵니다.
			File f1 = new File(makeFile);
		} else {
			// 파일이 없을땐 파일을 생성합니다.
			fileMake(makeFile);
		}

	}

	// 파일을 존재여부를 확인하는 메소드
	public static Boolean fileIsLive(String isLivefile) {
		File f1 = new File(isLivefile);

		if (f1.exists()) {
			return true;
		} else {
			return false;
		}
	}

	// 파일을 생성하는 메소드
	public static void fileMake(String makeFileName) {
		File f1 = new File(makeFileName);
		try {
			f1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 파일을 삭제하는 메소드
	public static void fileDelete(String deleteFileName) {
		File I = new File(deleteFileName);
		I.delete();
	}

	// 파일을 복사하는 메소드
	public static void fileCopy(String inFileName, String outFileName) {
		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 파일을 이동하는 메소드
	public static void fileMove(String inFileName, String outFileName) {
		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

			// 복사한뒤 원본파일을 삭제함
			fileDelete(inFileName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 디렉토리의 파일 리스트를 읽는 메소드
	public static List<File> getDirFileList(String dirPath) {
		// 디렉토리 파일 리스트
		List<File> dirFileList = null;

		// 파일 목록을 요청한 디렉토리를 가지고 파일 객체를 생성함
		File dir = new File(dirPath);

		// 디렉토리가 존재한다면
		if (dir.exists()) {
			// 파일 목록을 구함
			File[] files = dir.listFiles();

			// 파일 배열을 파일 리스트로 변화함
			dirFileList = Arrays.asList(files);
		}

		return dirFileList;
	}

}
