package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BaseballTeam;

public class BaseballCrud {
	private final String namespace = "mapper.baseballMapper";

	private SqlSession getSession() {
		String config = "mybatisConfig.xml"; // MyBatis환경설정파일의 파일명
		InputStream is = null; // 파일처리(파일로부터 입력)을 위한 객체
		try {
			is = Resources.getResourceAsStream(config);// 환경설정파일을 읽음
		} catch (Exception e) {
			System.out.println("환경설정 파일 열기 실패!");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		// SqlSession 3단계에 걸쳐 만들어진다. SqlSessionFactoryBuilder 생성 ->
		// SqlSessionFactory 생성-> SqlSession 생성 순;
		// SqlSession이 있어야 매퍼내부 확인 가능.
		return session;

	}

	public Integer putBaseballTeam(BaseballTeam team) {// 야구팀 등록
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace + ".putBaseballTeam";
			result = session.insert(stmt, team);
			if (result > 0)
				session.commit();
			else
				session.rollback();

		} finally {
			session.close();
		}
		return result;
	}

	public List<String> getHometown() {// 야구팀의 연고지 이름 검색(목록)
		SqlSession session = getSession();
		List<String> towns = null;
		try {
			String stmt = namespace + ".getHometown";
			towns = session.selectList(stmt);
		} finally {
			session.close();
		}
		return towns;
	}

	public Integer getId() {// 가장 큰 야구팀 번호 검색
		SqlSession session = getSession();
		Integer max = null;
		try {
			String stmt = namespace + ".getId";
			max = session.selectOne(stmt); // 검색결과가 한 건인 경우 : selectOne사용
			if (max == null) // 검색결과가 여러개인 경우 : selectList사용
				max = 0;

		} finally {
			session.close();

		}
		return max;
	}

	// SQLSession을 사용해서 매퍼에 접근한다.
	// 따라서, SQLSession을 생성하는 메서드가 필요하다.

	public List<BaseballTeam> getBaseballTeam() {
		SqlSession session = getSession();
		List<BaseballTeam> team = null;
		try {
			String stmt = namespace + ".getBaseballTeam";
			team = session.selectList(stmt);// 검색결과가 여러건인 경우, selectList사용

		} finally {
			session.close();
		}
		return team;
	}
}