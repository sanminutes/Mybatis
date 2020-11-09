package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	void putItem(Item item);
	List<Item> getItems(Integer c);
	Integer getItemCount();
	Item getItem(String id);
}
