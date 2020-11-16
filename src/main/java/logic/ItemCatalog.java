package logic;

import java.util.List;

import model.Items;

public interface ItemCatalog {
	List<Items> getItemList();
	Items getItem(Integer id);
}
