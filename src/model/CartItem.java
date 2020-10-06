package model;

//DB연동을 대비해서 변수를 선언함.
public class CartItem { // 장바구니에 있는 상품 목록을 저장할 객체
	private Integer seqno; // 일련번호
	private String name;// 상품 이름
	private Integer price; // 상품 가격
	private String code; // 상품코드
	private Integer num; // 상품갯수
	private String id; // 계정

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
