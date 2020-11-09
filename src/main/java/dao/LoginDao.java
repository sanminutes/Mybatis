package dao;

import model.Custom_info;

public interface LoginDao {
	void entryUser(Custom_info guest);
	Custom_info getUser(String id);
	String getPassword(String id);
	Integer getIdCount(String id);
}
