package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.Category;
import model.Condition;
import model.ItemWriting;
import model.Writing;

@Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;

	public Integer getMaxId() {
		return session.selectOne("mapper.usersMapper.getMaxSeqno");
	}

	public void insertWriting(ItemWriting writing) {
		session.insert("mapper.uploadMapper.putImageWriting", writing);
	}

	public void updateWriting(Writing writing) {
		session.update("mapper.uploadMapper.updateImage", writing);
	}

	public void deleteWriting(Integer id) {
		session.delete("mapper.uploadMapper.deleteImage", id);
	}

	public ItemWriting getImageWriting(Integer id) {
		return session.selectOne("mapper.uploadMapper.getImage", id);
	}

	public Integer getMaxWritingId() {
		Integer max = session.selectOne("mapper.uploadMapper.getMaxId");
		if (max == null) {
			max = 0;
		}
		return max;
	}

	public List<ItemWriting> getItemWriting(Condition pageNo) {
		System.out.println("pageNo : " +pageNo.getC_num());
		return session.selectList("mapper.uploadMapper.getImageList", pageNo);
	}

	public Integer selectMaxGroupId() {
		return session.selectOne("mapper.uploadMapper.getMaxId");
	}

	public void updateOrderNo(Writing writing) {
		session.update("mapper.uploadMapper.updateOrderNo", writing);
	}

	public void putBBS(Bbs bbs) {
		Integer seqno = this.getMaxId();
		if (seqno == null)
			seqno = 0;
		bbs.setSeqno(seqno + 1);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year + "/" + month + "/" + date;
		bbs.setBbs_date(bbsDate);
		session.insert("mapper.usersMapper.putBBS", bbs);
	}

	public Integer selectRownum(Integer seqno) {
		return session.selectOne("mapper.uploadMapper.selectRownum", seqno);
	}

	public Integer selectImageCount(Integer category) {
		return session.selectOne("mapper.uploadMapper.getTotalCnt", category);
	}

	public List<Category> getCategory() {
		return session.selectList("mapper.uploadMapper.getCategory");
		
	}

}
