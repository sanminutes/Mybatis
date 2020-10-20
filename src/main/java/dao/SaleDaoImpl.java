package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Sale;

@Repository
public class SaleDaoImpl implements SaleDao {
	@Autowired
	private SqlSession session;

	public Integer findMaxSaleId() {
		Integer max = this.session.selectOne("mapper.salesMapper.getMaxSaleId");
		if (max == null)
			return 0;
		else
			return max;
	}

	public void create(Sale sale) {
		this.session.insert("mapper.salesMapper.putSale", sale);
	}

}
