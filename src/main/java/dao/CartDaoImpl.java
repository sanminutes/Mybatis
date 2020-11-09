package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartItem;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SqlSession session;

	public void insertCart(CartItem item) {
		session.insert("mapper.usersMapper.putCart", item);

	}

	public void deleteCart(CartItem item) {
		session.delete("mapper.usersMapper.deleteCart", item);

	}

	public void updateCart(CartItem item) {
		session.update("mapper.usersMapper.updateCart", item);

	}

	public Integer getMAxCartId() {
		return session.selectOne("mapper.usersMapper.getMaxSeqnoCart");
	}

	public List<CartItem> selectCart(String id) {
		return session.selectList("mapper.usersMapper.getCart", id);
	}

}
