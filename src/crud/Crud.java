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

	// SQLSession을 사용해서 매퍼에 접근한다.
	// 따라서, SQLSession을 생성하는 메서드가 필요하다.
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

	public Custom_info selectMember(String id) {
		// usersMapper에 있는 selectMember를 호출하는 메서드
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

	// null값을 받기 위해서는 int가 아닌 Integer(객체)를 사용해야 한다.
	public Integer getMaxSeqno() {
		SqlSession session = getSession();
		Integer max = null;// 글번호가 저장될 변수
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
