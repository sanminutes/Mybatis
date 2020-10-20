package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SaleDao;
import dao.SaleDetailDao;
import model.Sale;
import model.SaleDetail;

@Service
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private SaleDetailDao saleDetailDao;

	public void entrySale(Sale sale) {
		this.saleDao.create(sale);
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for (SaleDetail saleDetail : saleDetailList) {
			this.saleDetailDao.create(saleDetail);
		} // Sale정보를 삽입한 후, 상세정보를 하나씩 삽입한다.
	}

	public Integer getNewSaleId() {
		System.out.println(saleDao.toString());
		int newSaleId = this.saleDao.findMaxSaleId() + 1;
		return newSaleId;
	}

}
