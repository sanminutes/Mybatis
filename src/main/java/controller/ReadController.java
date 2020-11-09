package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.WriteDao;
import logic.ItemCatalog;
import logic.WriteCatalog;
import model.Bbs;
import model.Item;
import model.ItemWriting;

@Controller
public class ReadController {
	@Autowired
	private WriteCatalog writeCatalog;
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private WriteDao writeDao;
	

	@RequestMapping(value = "/read/readImage.html")
	public ModelAndView readImage(Integer id) {
		ModelAndView mav = new ModelAndView("home/index");
		ItemWriting itemwriting = writeDao.getImageWriting(id);
		mav.addObject("writing", itemwriting);
		mav.addObject("BODY", "readImage.jsp");
		return mav;
	}

	@RequestMapping(value = "/read/product.html")
	public ModelAndView readItems(Integer pageNo) {
		ModelAndView mav = new ModelAndView("home/index");
		Integer count = itemCatalog.getItemCount();
		int pageCnt = 0;
		int currentPage = 0;
		if (pageNo == null)
			currentPage = 1;
		else
			currentPage = pageNo;
		if (count > 0) {
			pageCnt = count / 5;
			if (count % 5 > 0)
				pageCnt++;
		}
		List<Item> itemList = itemCatalog.getItems(currentPage);
		mav.addObject("ITEM_LIST", itemList);
		mav.addObject("COUNT", pageCnt);
		mav.addObject("BODY", "itemList.jsp");
		return mav;
	}

	@RequestMapping(value = "/read/read.html")
	public ModelAndView readBBS(Integer pageNo) {
		ModelAndView mav = new ModelAndView("home/index");
		int currentPage = 0;
		if (pageNo == null)
			currentPage = 1;
		else
			currentPage = pageNo;
		int startRow = (currentPage - 1) * 5 + 1;
		int endRow = (currentPage * 5);
		List<Bbs> bbsList = writeCatalog.readBbs(currentPage);
		mav.addObject("BBS_LIST", bbsList);
		Integer totalCount = writeCatalog.getBbsCount();
		int pageCount = totalCount / 5;
		if (totalCount % 5 > 0)
			pageCount++;
		mav.addObject("pageCount", pageCount);
		mav.addObject("RESULT", "OK");
		mav.addObject("BODY", "bbsListView.jsp");
		return mav;
	}

	@RequestMapping(value = "/read/readDetail.html")
	public ModelAndView detail(Integer SEQNO) {
		ModelAndView mav = new ModelAndView("home/index");
		Bbs bbs = writeCatalog.getBbsDetail(SEQNO);
		mav.addObject("BBS", bbs);
		mav.addObject("BODY", "bbsRead.jsp");
		return mav;
	}
}
