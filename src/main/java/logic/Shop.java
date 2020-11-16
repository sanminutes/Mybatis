package logic;

import java.util.List;

import model.Items;

public interface Shop {
	List<Items> getItems();
	Items getItem(Integer id);
}





