package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Bbs {
	private Integer seqno;
	@NotEmpty(message="아이디를 입력해주세요.")
	private String title;
	@NotEmpty(message="비밀번호를 입력해주세요.")
	private String content;
	private String id;
	private String bbs_date;
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBbs_date() {
		return bbs_date;
	}
	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date;
	}
}
