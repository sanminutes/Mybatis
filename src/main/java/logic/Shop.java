package logic;

import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

public interface Shop {
	Integer calculateTotal(List<ItemSet> itemList);//구매금액 총액계산
	Cart getCart();//장바구니 정보 출력
	void checkout(User user, Cart cart);//장바구니 상품 구매(매출정보 저장)	
	
	List<Item> getItems(); //과일 목록
	Item getItem(Integer id); //과일 상세 정보
	User getUser(User user); //가입자 검색
	void putUser(User user); //가입자 등록
}





