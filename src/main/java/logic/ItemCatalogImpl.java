package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Item;
@Service
public class ItemCatalogImpl implements ItemCatalog {
	@Autowired
	private ItemDao itemDao;
	
	public Item getItem(Integer id) {
		return this.itemDao.findById(id);
	}

	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}

}



