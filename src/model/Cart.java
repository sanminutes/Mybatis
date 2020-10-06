package model;

import java.util.LinkedList;

import crud.Crud;

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
	public void deleteItem(String code) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code)) {// ������ ��ǰ��ȣ�� ��ġ�ϴ� ���
				codeList.remove(i); // i��° ��ǰ ��ȣ�� ���(codeList)���� ����
				numList.remove(i); // i��° ��ǰ ������ ���(numList)���� ����
				return; // �޼��� ����
			}
		} // codeList�� �ִ� ��� ��ǰ ��ȣ�� ���ؼ� ��ġ�ϴ� ���, �ش� ��ǰ�� ��ȣ�� ������ ����
	}
	// ��ٱ��Ͽ� ��ǰ�� ������ ���� ���� ��� -> ArrayList

	public void modifyItem(String code, int num) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code)) {// ������ ��ǰ��ȣ�� ��ġ�ϴ� ���
				numList.set(i, num);// ���ο� ��ǰ ������ �����
				return; // �޼��� ����
			}
		}
	}

	public void saveDB() {// �α׾ƿ� �� �� ȣ��ȴ�. ��ǰ��ȣ�� ������ ������ �����Ѵ�.
		Crud crud = new Crud();
		for (int i = 0; i < codeList.size(); i++) {
			String code = codeList.get(i);// ��ٱ��Ͽ��� i��° ��ǰ��ȣ�� ������
			Integer num = numList.get(i);// ��ٱ��Ͽ��� i��° ��ǰ������ ������
			CartItem item = new CartItem();// ���� ����
			item.setId(id);
			item.setCode(code);
			item.setNum(num);
			item.setSeqno(crud.getMaxSeqnoCart() + 1);
			crud.putCart(item); // DB�� �ش��ǰ�� ������ ����
		}
	}

	public void deleteDB(String id) {
		Crud crud = new Crud();
		crud.deleteCart(id);
	}

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
