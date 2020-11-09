package model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ItemWriting {
	private Integer writing_id;
	private String category;
	@NotEmpty(message = "판매상점명을 입력하세요.")
	private String title;
	@NotEmpty(message = "상품명을 입력하세요.")
	private String writer_name;
	private Integer price;
	private Integer charge_price;
	@NotEmpty(message = "배송가능한 범위를 체크해주세요.")
	private String delivery;
	private String image1;
	private String image2;
	private String country;
	@NotEmpty(message = "각 옵션은 [,]을 사용해서 구분지어주세요.")
	private String options1;
	@NotEmpty(message = "각 옵션은 [,]을 사용해서 구분지어주세요.")
	private String options2;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOptions2() {
		return options2;
	}

	public String getOptions1() {
		return options1;
	}

	public void setOptions1(String options1) {
		this.options1 = options1;
	}

	public void setOptions2(String options2) {
		this.options2 = options2;
	}

	private String comments;
	private MultipartFile imageA;
	private MultipartFile imageB;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public MultipartFile getImageA() {
		return imageA;
	}

	public void setImageA(MultipartFile imageA) {
		this.imageA = imageA;
	}

	public MultipartFile getImageB() {
		return imageB;
	}

	public void setImageB(MultipartFile imageB) {
		this.imageB = imageB;
	}

	public Integer getWriting_id() {
		return writing_id;
	}

	public void setWriting_id(Integer writing_id) {
		this.writing_id = writing_id;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCharge_price() {
		return charge_price;
	}

	public void setCharge_price(Integer charge_price) {
		this.charge_price = charge_price;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getComment() {
		return comments;
	}

	public void setComment(String comment) {
		this.comments = comment;
	}

}
