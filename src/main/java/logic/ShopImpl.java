package logic;

import java.util.List;

import model.Items;

public class ShopImpl implements Shop {
	private ItemCatalog itemCatalog;
	
	public Items getItem(Integer id) {
		return this.itemCatalog.getItem(id);
	}

	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	public List<Items> getItems() {
		return this.itemCatalog.getItemList();
	}

}



