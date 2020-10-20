package dao;

import model.Sale;

public interface SaleDao {
	Integer findMaxSaleId();
	void create(Sale sale);

}
