package dao;

import java.util.List;

import model.Bbs;

public interface ReadDao {
	List<Bbs> readBbs(Integer pageNo);
	Integer getBbsCount();
	List<Bbs> getBbsDetail();
}
