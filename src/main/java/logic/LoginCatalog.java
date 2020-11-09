package logic;

import model.Custom_info;

public interface LoginCatalog {
	void putUser(Custom_info guest);
	String getPwd(String id);
	Integer getIdCnt(String id);
	Custom_info getUser(String id);
}
