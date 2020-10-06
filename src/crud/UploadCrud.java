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
	// SqlSession�� ����ؼ� ���۸� �����Ѵ�.
	// ����, SqlSession�� �����ϴ� �޼��尡 �ʿ��ϴ�.

	private SqlSession getSession() {
		String config = "mybatisConfig.xml"; // MyBatisȯ�漳�������� ���ϸ�
		InputStream is = null; // ����ó��(���Ϸκ��� �Է�)�� ���� ��ü
		try {
			is = Resources.getResourceAsStream(config);// ȯ�漳�������� ����
		} catch (Exception e) {
			System.out.println("ȯ�漳�� ���� ���� ����!");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		// SqlSession 3�ܰ迡 ���� ���������. SqlSessionFactoryBuilder ���� ->
		// SqlSessionFactory ����-> SqlSession ���� ��;
		// SqlSession�� �־�� ���۳��� Ȯ�� ����.
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