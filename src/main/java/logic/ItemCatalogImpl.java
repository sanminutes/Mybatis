package logic;

import java.util.List;

import dao.ItemDao;
import model.Items;

public class ItemCatalogImpl implements ItemCatalog {
	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public Items getItem(Integer id) {
		return this.itemDao.findById(id);
	}

	public List<Items> getItemList() {
		return this.itemDao.findAll();
	}

}



