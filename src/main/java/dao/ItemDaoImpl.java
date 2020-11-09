package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;
@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession session;
	public void putItem(Item item) {
		session.insert("mapper.usersMapper.putItem", item);
	}

	public List<Item> getItems(Integer c) {
		return session.selectList("mapper.usersMapper.getItems", c);
	}

	public Integer getItemCount() {
		return session.selectOne("mapper.usersMapper.getItemCount");
	}

	public Item getItem(String id) {
		return session.selectOne("mapper.usersMapper.getItem", id);
	}

}
