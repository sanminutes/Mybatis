package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl implements TeamDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Team> getTeamList() throws Exception {
		// 매퍼의 쿼리 호출
		List<Team> list = sqlSession.selectList("mapper.usersMapper.getTeamList"); // 매퍼이름.쿼리이름

		return list;
	}

}
