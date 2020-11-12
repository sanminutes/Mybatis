package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDao;
import model.Custom_info;

@Service
public class LoginCatalogImpl implements LoginCatalog {
	@Autowired
	private LoginDao loginDao;

	public String getPwd(String id) {
		return loginDao.getPassword(id);
	}

	public Integer getIdCnt(String id) {
		return loginDao.getIdCount(id);
	}

	public Custom_info getUser(String id) {
		return loginDao.getUser(id);
	}

	public void putUser(Custom_info guest) {

		this.loginDao.entryUser(guest);

	}

	public Integer getLevel(String id) {
		return loginDao.getLevel(id);
	}

}
