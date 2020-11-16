package dao;

import java.util.List;

import model.AuctionItem;
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
	void insertatWriting(AuctionItem auctionItem); //¿Á¼Ç

	void updateWriting(Writing writing);

	void deleteWriting(Integer id);

	ItemWriting getImageWriting(Integer id);
	
	AuctionItem getAuctionWriting(Integer id);//

	Integer getMaxWritingId();
	
	Integer getMaxatWritingId(); //¿Á¼Ç

	List<ItemWriting> getItemWriting(Condition pageNo);

	Integer selectMaxGroupId();

	List<Category> getCategory();
	List<ItemWriting> gettitle(String title);
	List<ItemWriting> getsearch(String keyword);
	void updateOrderNo(Writing writing);
	
	List<AuctionItem> getAuctionItem();
	
	List<AuctionItem> getheaven(AuctionItem auctionItem);
	
	Integer selectCnt(Integer Id);
	Integer selectMax(Integer Id);
	
	
}
