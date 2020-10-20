package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class Sale {
	private User user;
	private Integer saleId;
	private String userId;
	private String updateTime;
	private List<SaleDetail> saleDetailList = new ArrayList<SaleDetail>();

	public void addSaleDetail(SaleDetail detail) {
		this.saleDetailList.add(detail);
	}// 매출 상세정보 추가 메서드

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = String.valueOf(updateTime);
	}

	public List<SaleDetail> getSaleDetailList() {
		return saleDetailList;
	}

	public void setSaleDetailList(List<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}

}
