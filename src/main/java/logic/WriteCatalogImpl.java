package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import dao.WriteDao;
import model.Bbs;
@Service
public class WriteCatalogImpl implements WriteCatalog {
	@Autowired
	private WriteDao writeDao;
	@Autowired
	private ReadDao readDao;
	public void getMaxBBSId() {
		this.writeDao.getMaxId();
	}

	public void putBBS(Bbs bbs) {
		this.writeDao.putBBS(bbs);
	}

	public List<Bbs> readBbs(Integer pageNo) {
		return this.readDao.readBbs(pageNo);
	}

	public Integer getBbsCount() {
		return this.readDao.getBbsCount();
	}

	public Bbs getBbsDetail(Integer pageNo) {
		return this.readDao.getBbsDetail(pageNo);
	}
}
