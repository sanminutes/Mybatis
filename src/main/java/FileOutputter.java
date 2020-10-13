import java.io.FileWriter;
import java.io.IOException;

import sample4.Outputter;

public class FileOutputter implements Outputter {
	private String filePath;

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void output(String msg) throws IOException {
		FileWriter out = new FileWriter(filePath); // 파일로 출력하는 객체 생성
		out.write(msg); // msg의 내용을 파일로 출력
		out.close(); // 파일을 닫음
		System.out.println("파일 생성 완료.");
	}

}
