package model;

import java.util.LinkedList;

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
	// 장바구니에 상품의 변경이 거의 없는 경우 -> ArrayList

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
