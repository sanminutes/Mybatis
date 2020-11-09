package dao;

import java.util.List;

import model.Bbs;
import model.Category;
import model.Condition;
import model.ItemWriting;
import model.Writing;

public interface WriteDao {
	Integer getMaxId();

	void putBBS(Bbs bbs);
	
	Integer selectImageCount(Integer category);
	Integer selectRownum(Integer SEQNO);

	void insertWriting(ItemWriting writing);

	void updateWriting(Writing writing);

	void deleteWriting(Integer id);

	ItemWriting getImageWriting(Integer id);

	Integer getMaxWritingId();

	List<ItemWriting> getItemWriting(Condition pageNo);

	Integer selectMaxGroupId();

	List<Category> getCategory();
	void updateOrderNo(Writing writing);
}
