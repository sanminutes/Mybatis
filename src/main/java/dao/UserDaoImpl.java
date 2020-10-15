package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDaoImpl implements UserDao {
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public User findByIdPwd(User user) {
		return session.selectOne("mapper.usersMapper.getUser", user);
	}

}



