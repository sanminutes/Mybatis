package logic;

import model.User;

public interface UserCatalog {
	User getUser(User user);

	void putUser(User user);
}
