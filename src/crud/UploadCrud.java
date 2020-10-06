package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Condition;
import model.Writing;

public class UploadCrud {
	private final String namespace = "mapper.uploadMapper";
	// SqlSession을 사용해서 매퍼를 접근한다.
	// 따라서, SqlSession을 생성하는 메서드가 필요하다.

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

	public Integer putImageWriting(Writing w) {
		SqlSession session = getSession();
		String stmt = namespace + ".putImageWriting";
		Integer result = null;
		try {
			result = session.insert(stmt, w);
			if (result > 0)
				session.commit();
			else
				session.rollback();

		} finally {
			session.close();
		}
		return result;

	}

	public Integer getMaxId() {
		SqlSession session = getSession();
		String stmt = namespace + ".getMaxId";
		Integer max = null;
		try {
			max = session.selectOne(stmt);
			if (max == null)
				max = 0;
		} finally {
			session.close();
		}
		return max;
	}

	public Integer getTotalCnt() {
		SqlSession session = getSession();
		String stmt = namespace + ".getTotalCnt";
		Integer result = null;
		try {
			result = session.selectOne(stmt);
			if (result == null)
				result = 0;
		} finally {
			session.close();

		}
		return result;
	}

	public List<Writing> getImageList(Condition c) {
		SqlSession session = getSession();
		String stmt = namespace + ".getImageList";
		List<Writing> list = null;
		try {
			list = session.selectList(stmt, c);
		} finally {
			session.close();
		}
		return list;
	}

	public Writing getImage(Integer no) {
		SqlSession session = getSession();
		String stmt = namespace + ".getImage";
		Writing writing = null;
		try {
			writing = session.selectOne(stmt, no);

		} finally {
			session.close();
		}
		return writing;
	}
}