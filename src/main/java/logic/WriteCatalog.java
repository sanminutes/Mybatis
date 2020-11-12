package logic;

import java.util.List;

import model.AuctionItem;
import model.Bbs;

public interface WriteCatalog {
	void getMaxBBSId();
	void putBBS(Bbs bbs);
	
	List<Bbs> readBbs(Integer pageNo);
	Integer getBbsCount();
	List<Bbs> getBbsDetail();
}
