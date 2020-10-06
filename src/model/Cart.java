package model;

import java.util.LinkedList;

import crud.Crud;

public class Cart {// 장바구니 객체
	// 상품 코드, 상품 갯수
	// 상품 코드 여러개를 저장하기 위해서 List, Set, Map 중의 하나를 사용해야 한다.
	private LinkedList<String> codeList = new LinkedList<String>();// 상품코드용
	private LinkedList<Integer> numList = new LinkedList<Integer>();// 상품갯수용
	private String id; // 계정

	public Cart(String id) {
		this.id = id; // 생성자
	}

	// 아래 메서드를 통해 값이 들어감
	public void addCart(String code, int num) {// codeList와 numList에 넣는 메서드
		for (int i = 0; i < codeList.size(); i++) {// 이미 codeList엥 담긴 상품인지 반복으로 검사
			if (codeList.get(i).equals(code)) {// codeList의 상품번호와 비교, 같은 경우
				numList.set(i, numList.get(i) + num);// 기존 상품의 갯수 + 1
				return;// 메서드 종료
			}
		} // 반복의 끝
		codeList.add(code);
		numList.add(num); // 반복이 끝난경우 즉, 새 상품이므로 저장
	}

	// 상품이 빈번히 장바구니에서 넣었다가, 삭제되는 경우 -> LinkedList
	public void deleteItem(String code) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code)) {// 삭제할 상품번호와 일치하는 경우
				codeList.remove(i); // i번째 상품 번호를 목록(codeList)에서 삭제
				numList.remove(i); // i번째 상품 갯수를 목록(numList)에서 삭제
				return; // 메서드 종료
			}
		} // codeList에 있는 모든 상품 번호와 비교해서 일치하는 경우, 해당 상품의 번호와 갯수를 삭제
	}
	// 장바구니에 상품의 변경이 거의 없는 경우 -> ArrayList

	public void modifyItem(String code, int num) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code)) {// 변경할 상품번호와 일치하는 경우
				numList.set(i, num);// 새로운 상품 갯수로 변경됨
				return; // 메서드 종료
			}
		}
	}

	public void saveDB() {// 로그아웃 할 때 호출된다. 상품번호와 갯수와 계정을 저장한다.
		Crud crud = new Crud();
		for (int i = 0; i < codeList.size(); i++) {
			String code = codeList.get(i);// 장바구니에서 i번째 상품번호를 가져옴
			Integer num = numList.get(i);// 장바구니에서 i번째 상품갯수를 가져옴
			CartItem item = new CartItem();// 모델을 생성
			item.setId(id);
			item.setCode(code);
			item.setNum(num);
			item.setSeqno(crud.getMaxSeqnoCart() + 1);
			crud.putCart(item); // DB에 해당상품과 갯수를 저장
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
