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
		FileWriter out = new FileWriter(filePath); // ���Ϸ� ����ϴ� ��ü ����
		out.write(msg); // msg�� ������ ���Ϸ� ���
		out.close(); // ������ ����
		System.out.println("���� ���� �Ϸ�.");
	}

}
