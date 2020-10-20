package dao;

import model.User;

public interface UserDao {
	User findByIdPwd(User user);
	void create(User user);
}
