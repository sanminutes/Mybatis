	package model;
	
	public class ItemSet {
		private Item item; // 상품객체
		private Integer quantity; // 갯수
	
		public ItemSet(Item item, Integer quantity) {
			this.item = item;
			this.quantity = quantity;
	
		}// 생성자
	
		public void addQuantity(Integer addQuantity) {
			int number = addQuantity.intValue();// 추가될 갯수
			int existQuantity = this.getQuantity().intValue();// 기존의 갯수
			this.setQuantity(new Integer(number + existQuantity)); // 기존갯수 + 추가갯수
		}// 수량 추가 메서드
	
		public Item getItem() {
			return item;
		}
	
		public void setItem(Item item) {
			this.item = item;
		}
	
		public Integer getQuantity() {
			return quantity;
		}
	
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
	}
