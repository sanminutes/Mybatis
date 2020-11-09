package model;

public class CartItem {
	private Integer seqno;
	private String name;
	private Integer price;
	private String code;
	private String sizee;
	private Integer num;
	private Integer charge_price;
	public Integer getCharge_price() {
		return charge_price;
	}

	public void setCharge_price(Integer charge_price) {
		this.charge_price = charge_price;
	}

	private String id;

	public String getSizee() {
		return sizee;
	}

	public void setSizee(String sizee) {
		this.sizee = sizee;
	}

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
