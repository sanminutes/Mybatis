package model;

//DB������ ����ؼ� ������ ������.
public class CartItem { // ��ٱ��Ͽ� �ִ� ��ǰ ����� ������ ��ü
	private Integer seqno; // �Ϸù�ȣ
	private String name;// ��ǰ �̸�
	private Integer price; // ��ǰ ����
	private String code; // ��ǰ�ڵ�
	private Integer num; // ��ǰ����
	private String id; // ����

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
