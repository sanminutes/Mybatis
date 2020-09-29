package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Item;
import model.Bbs;
import model.Custom_info;

public class Crud {
	private final String namespace = "mapper.usersMapper";

	// SQLSession�� ����ؼ� ���ۿ� �����Ѵ�.
	// ����, SQLSession�� �����ϴ� �޼��尡 �ʿ��ϴ�.
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

	public Custom_info selectMember(String id) {
		// usersMapper�� �ִ� selectMember�� ȣ���ϴ� �޼���
		SqlSession session = getSession();
		Custom_info info = null;
		try {
			String stmt = namespace + ".selectMember";
			info = session.selectOne(stmt, id);
		} finally {
			session.close();
		}
		return info;
	}

	// null���� �ޱ� ���ؼ��� int�� �ƴ� Integer(��ü)�� ����ؾ� �Ѵ�.
	public Integer getMaxSeqno() {
		SqlSession session = getSession();
		Integer max = null;// �۹�ȣ�� ����� ����
		try {
			String stmt = namespace + ".getMaxSeqno";
			max = session.selectOne(stmt);
			if (max == null)
				max = 0;
		} finally {
			session.close();
		}
		return max;
	}

	public Integer putBBS(Bbs bbs) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace + ".putBBS";
			result = session.insert(stmt, bbs);
			if (result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public List<Bbs> getBBS(Integer pageno) {
		SqlSession session = getSession();
		List<Bbs> bbs = null;
		try {
			String stmt = namespace + ".getBBS";
			bbs = session.selectList(stmt, pageno);

		} finally {
			session.close();
		}
		return bbs;

	}

	public Integer getBBSCount() {
		SqlSession session = getSession();
		Integer count = null;
		try {
			String stmt = namespace + ".getBBSCount";
			count = session.selectOne(stmt);
			if (count == null)
				count = 0;
		} finally {
			session.close();

		}
		return count;
	}

	public Bbs getBBSRead(Integer seqno) {
		SqlSession session = getSession();
		Bbs bbs = null;
		try {
			String stmt = namespace + ".getBBSRead";
			bbs = session.selectOne(stmt, seqno);
		} finally {
			session.close();

		}
		return bbs;
	}

	public Integer putMember(Custom_info c) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace + ".putMember";
			result = session.insert(stmt, c);
			if (result > 0)
				session.commit();
			else
				session.rollback();

		} finally {
			session.close();
		}
		return result;
	}

	public Integer getItemID(String code) {
		SqlSession session = getSession();
		Integer cnt = null;
		try {
			String stmt = namespace + ".getItemID";
			cnt = session.selectOne(stmt, code);
			if (cnt == null)
				cnt = 0;
		} finally {
			session.close();

		}
		return cnt;
	}

	public Integer putItem(Item item) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace + ".putItem";
			result = session.insert(stmt, item);
			if (result > 0)
				session.commit();
			else
				session.rollback();

		} finally {
			session.close();

		}
		return result;
	}

	public List<Bbs> selectItem() {
		SqlSession session = getSession();
		List<Bbs> bbs = null;
		try {
			String stmt = namespace + ".selectItem";
			bbs = session.selectList(stmt);

		} finally {
			session.close();
		}
		return bbs;
	}

	public Integer getItemCount() {
		SqlSession session = getSession();
		Integer count = null;
		try {
			String stmt = namespace + ".getItemCount";
			count = session.selectOne(stmt);
		} finally {
			session.close();
		}
		return count;
	}

	public List<Item> getItems(Integer page) {
		SqlSession session = getSession();
		List<Item> items = null;
		try {
			String stmt = namespace + ".getItems";
			items = session.selectList(stmt, page);

		} finally {
			session.close();
		}
		return items;
	}
}
