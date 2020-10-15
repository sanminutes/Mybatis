package logic;

import model.User;

public class ShopImpl implements Shop {
	private UserCatalog userCatalog;
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public User getUser(User user) {
		return userCatalog.getUser(user);
	}

}




