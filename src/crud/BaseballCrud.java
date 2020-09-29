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

	public Integer putBaseballTeam(BaseballTeam team) {// �߱��� ���
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

	public List<String> getHometown() {// �߱����� ������ �̸� �˻�(���)
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

	public Integer getId() {// ���� ū �߱��� ��ȣ �˻�
		SqlSession session = getSession();
		Integer max = null;
		try {
			String stmt = namespace + ".getId";
			max = session.selectOne(stmt); // �˻������ �� ���� ��� : selectOne���
			if (max == null) // �˻������ �������� ��� : selectList���
				max = 0;

		} finally {
			session.close();

		}
		return max;
	}

	// SQLSession�� ����ؼ� ���ۿ� �����Ѵ�.
	// ����, SQLSession�� �����ϴ� �޼��尡 �ʿ��ϴ�.

	public List<BaseballTeam> getBaseballTeam() {
		SqlSession session = getSession();
		List<BaseballTeam> team = null;
		try {
			String stmt = namespace + ".getBaseballTeam";
			team = session.selectList(stmt);// �˻������ �������� ���, selectList���

		} finally {
			session.close();
		}
		return team;
	}
}