package model;

import org.springframework.web.multipart.MultipartFile;

public class AuctionItem {
	private Integer a_num; // 상품번호
	private String a_name; // 상품이름
	private Integer a_price; // 시작가
	private Integer a_high_p; // 입찰가
	private Integer a_direct_p; // 즉시결제가
	private String a_id; // 판매자아이디
	private String a_date; // 판매 게시일
	private String image; // 이미지

	public Integer getA_high_p() {
		return a_high_p;
	}

	public void setA_high_p(Integer a_high_p) {
		this.a_high_p = a_high_p;
	}

	public Integer getA_direct_p() {
		return a_direct_p;
	}

	public void setA_direct_p(Integer a_direct_p) {
		this.a_direct_p = a_direct_p;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private MultipartFile imageA;

	public MultipartFile getImageA() {
		return imageA;
	}

	public void setImageA(MultipartFile imageA) {
		this.imageA = imageA;
	}

	public Integer getA_num() {
		return a_num;
	}

	public void setA_num(Integer a_num) {
		this.a_num = a_num;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public Integer getA_price() {
		return a_price;
	}

	public void setA_price(Integer a_price) {
		this.a_price = a_price;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_date() {
		return a_date;
	}

	public void setA_date(String a_date) {
		this.a_date = a_date;
	}

}
