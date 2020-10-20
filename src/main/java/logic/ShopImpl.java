package logic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.Sale;
import model.SaleDetail;
import model.User;

@Service
public class ShopImpl implements Shop {
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private SaleCatalog saleCatalog;

	//////// 장바구니 관련 메서드 시작
	public Integer calculateTotal(List<ItemSet> itemList) {
		int totalAmount = 0;
		for (ItemSet itemSet : itemList) {
			int price = itemSet.getItem().getPrice().intValue();// 상품의 가격 추출
			int quantity = itemSet.getQuantity().intValue();// 상품의 갯수 추출
			totalAmount = totalAmount + (price * quantity); // 총합 누적
		}
		return new Integer(totalAmount);
	}

	public Cart getCart() {
		return new Cart(); // 새 장바구니 객체 리턴
	}

	public void checkout(User user, Cart cart) {
		Sale sale = createSale(user, cart);
		entrySale(sale);
	}

	private void entrySale(Sale sale) {
		this.saleCatalog.entrySale(sale);// DB에 매출 정보 삽입
	}

	private Integer getNewSaleId() {
		Integer id = this.saleCatalog.getNewSaleId();
		return id;
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}// 현재 시간을 리턴(1970년 1월 1일부터 현재까지 진행된 초를 연월일시분초로 변환하여 리턴)

	private Sale createSale(User user, Cart cart) {
		Sale sale = new Sale(); // 매출 객체 생성
		sale.setSaleId(getNewSaleId()); // 매출번호 설정
		sale.setUser(user); // 구매자 설정
		sale.setUserId(user.getUserId()); // 구매자 번호 설정
		Timestamp currentTime = getCurrentTime(); // 현재 연월일시분초 생성
		sale.setUpdateTime(currentTime);// 구매 시간을 설정
		List<ItemSet> itemList = cart.getItemList();// 장바구니에서 상품목록을 추출
		for (int i = 0; i < itemList.size(); i++) {
			ItemSet itemSet = (ItemSet) itemList.get(i);// 상품목록에서 상품추출
			int saleDetailId = i + 1; // 매출 상세정보용 번호 생성
			SaleDetail saleDetail = createSaleDetail(sale, saleDetailId, itemSet, currentTime);// 매출 상세정보 객체 생성
			sale.addSaleDetail(saleDetail);
		}
		return sale; // 매출 상세정보가 설정된 매출 객체 리턴
	}

	private SaleDetail createSaleDetail(Sale sale, int saleDetailId, ItemSet itemSet, Timestamp currentTime) {
		return new SaleDetail(sale, new Integer(saleDetailId), itemSet, currentTime);
	}

	//////// 장바구니 관련 메서드 종료
	public User getUser(User user) {
		return this.userCatalog.getUser(user);
	}

	public Item getItem(Integer id) {
		return this.itemCatalog.getItem(id);
	}

	public List<Item> getItems() {
		return this.itemCatalog.getItemList();
	}

	public void putUser(User user) {
		this.userCatalog.putUser(user);

	}
}
