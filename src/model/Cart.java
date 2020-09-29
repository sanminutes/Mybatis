package model;

import java.util.LinkedList;

public class Cart {// ��ٱ��� ��ü
	// ��ǰ �ڵ�, ��ǰ ����
	// ��ǰ �ڵ� �������� �����ϱ� ���ؼ� List, Set, Map ���� �ϳ��� ����ؾ� �Ѵ�.
	private LinkedList<String> codeList = new LinkedList<String>();// ��ǰ�ڵ��
	private LinkedList<Integer> numList = new LinkedList<Integer>();// ��ǰ������
	private String id; // ����

	public Cart(String id) {
		this.id = id; // ������
	}

	// �Ʒ� �޼��带 ���� ���� ��
	public void addCart(String code, int num) {// codeList�� numList�� �ִ� �޼���
		for (int i = 0; i < codeList.size(); i++) {// �̹� codeList�� ��� ��ǰ���� �ݺ����� �˻�
			if (codeList.get(i).equals(code)) {// codeList�� ��ǰ��ȣ�� ��, ���� ���
				numList.set(i, numList.get(i) + num);// ���� ��ǰ�� ���� + 1
				return;// �޼��� ����
			}
		} // �ݺ��� ��
		codeList.add(code);
		numList.add(num); // �ݺ��� ������� ��, �� ��ǰ�̹Ƿ� ����
	}
	// ��ǰ�� ����� ��ٱ��Ͽ��� �־��ٰ�, �����Ǵ� ��� -> LinkedList
	// ��ٱ��Ͽ� ��ǰ�� ������ ���� ���� ��� -> ArrayList

	public LinkedList<String> getCodeList() {
		return codeList;
	}

	public LinkedList<Integer> getNumList() {
		return numList;
	}

	public String getId() {
		return id;
	}

}
