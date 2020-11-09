package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Custom_info;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SqlSession session;

	public Custom_info getUser(String id) {
		return session.selectOne("mapper.usersMapper.selectMember", id);
	}

	public String getPassword(String id) {
		return session.selectOne("mapper.usersMapper.getPassword", id);
	}

	public Integer getIdCount(String id) {
		return session.selectOne("mapper.usersMapper.getIdCnt", id);
	}

	public void entryUser(Custom_info guest) {
		session.insert("mapper.usersMapper.putMember", guest);
	}

}
