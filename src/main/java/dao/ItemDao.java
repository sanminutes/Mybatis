package dao;

import java.util.List;

import model.Items;

public interface ItemDao {
	List<Items> findAll();
	Items findById(Integer id);
}
