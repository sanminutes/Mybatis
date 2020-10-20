package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return itemList;
	}// 게터 메서드

	public void push(ItemSet pushedItemSet) {
		boolean itemExistInCart = false; // 이미 장바구니에 담긴 물건인지 검사용 변수
		Item pushedItem = pushedItemSet.getItem();// 장바구니에 담을 물건을 불러옴
		int pushedItemId = pushedItem.getItemId().intValue();// 물건 번호를 불러옴
		for (ItemSet cartItemSet : this.itemList) {
			Item cartItem = cartItemSet.getItem();// 장바구니에서 물건을 불러옴
			int cartItemId = cartItem.getItemId().intValue();// 물건 번호를 불러옴
			if (cartItemId == pushedItemId) {
				cartItemSet.addQuantity(pushedItemSet.getQuantity());// 갯수증가
				itemExistInCart = true;// 이미 장바구니에 담긴 물건임을 설정
				break;// 동일한 물건인 경우 처리가 끝났으므로 반복 종료
			} // 장바구니에 있는 물건의 번호와 장바구니에 담을 물건의 번호가 같은 경우
		} // 이미 장바구니에 담긴 물건인지 반복해서 검사
		if (!itemExistInCart)
			this.itemList.add(pushedItemSet); // 장바구니에 추가
	}// 물건을 장바구니에 담는 메서드

	public boolean isEmpty() {
		if (this.itemList == null || this.itemList.isEmpty())
			return true;
		return false;

	}// 장바구니가 비어있는지 확인하는 메서드(비어있으면 true, 비어있지 않으면 false)

	public void clearAll() {
		this.itemList = new ArrayList<ItemSet>();// 새 객체 생성
	}// 장바구니를 비우는 메서드
}
