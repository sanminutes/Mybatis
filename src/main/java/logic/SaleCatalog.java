package logic;

import model.Sale;

public interface SaleCatalog {
	void entrySale(Sale sale);

	Integer getNewSaleId();
}
