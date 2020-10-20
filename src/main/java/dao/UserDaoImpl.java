package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;

	public User findByIdPwd(User user) {
		return session.selectOne("mapper.usersMapper.getUser", user);
	}

	public void create(User user) {
		session.selectOne("mapper.usersMapper.putUser", user);

	}

}
