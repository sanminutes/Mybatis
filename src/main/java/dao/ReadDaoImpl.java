package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
@Repository
public class ReadDaoImpl implements ReadDao {
	@Autowired
	private SqlSession session;
	public List<Bbs> readBbs(Integer pageNo) {
		return session.selectList("mapper.usersMapper.getBBS", pageNo);
	}

	public Integer getBbsCount() {
		return session.selectOne("mapper.usersMapper.getBBSCount");
	}

	public List<Bbs> getBbsDetail() {
		return session.selectList("mapper.usersMapper.getBBSRead");
	}

}
