package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.WriteDao;
import model.Category;
import model.Condition;
import model.Custom_info;
import model.ItemWriting;

@Controller
public class WriteController {
	@Autowired
	private WriteDao writeDao;

	/*
	 * @RequestMapping(value = "/write/writeReplyForm.html") public ModelAndView
	 * replyForm(Integer id, Integer parentid, Integer groupid) { ModelAndView mav =
	 * new ModelAndView("home/index"); Writing original =
	 * writeDao.getImageWriting(id); original.setContent(null);
	 * original.setWriter_name(null); original.setEmail(null);
	 * original.setGroup_id(groupid); original.setParent_id(parentid);
	 * mav.addObject("writing", original); mav.addObject("title", "RE]" +
	 * original.getTitle()); mav.addObject("BODY", "writeForm.jsp"); return mav;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/write/updateDo.html") public ModelAndView
	 * modifyDo(Writing writing, HttpSession session) { Writing old =
	 * writeDao.getImageWriting(writing.getWriting_id()); ModelAndView mav = new
	 * ModelAndView("home/index"); if
	 * (old.getPassword().equals(writing.getPassword())) { MultipartFile multiFile =
	 * writing.getImage(); String fileName = multiFile.getOriginalFilename(); if
	 * (fileName.equals("")) { writing.setImage_name(old.getImage_name()); } else {
	 * String path = null; OutputStream os = null; ServletContext ctx = try { os =
	 * new FileOutputStream(path); BufferedInputStream bis = new
	 * BufferedInputStream(multiFile.getInputStream()); byte[] buffer = new
	 * byte[8106]; int read = 0; while ((read = bis.read(buffer)) > 0) {
	 * os.write(buffer, 0, read); } if (os != null) os.close(); } catch (Exception
	 * e) { } writing.setImage_name(fileName); } writeDao.updateWriting(writing);
	 * mav.addObject("BODY", "updateResult.jsp?seq=" + writing.getWriting_id()); }
	 * else { mav.addObject("BODY", "updateResult.jsp?id=" +
	 * writing.getWriting_id()); } return mav; }
	 * 
	 * @RequestMapping(value = "/write/modify.html") public ModelAndView
	 * modify(Integer id) { ModelAndView mav = new ModelAndView("home/index");
	 * Writing writing = writeDao.getImageWriting(id); mav.addObject(writing);
	 * mav.addObject("BODY", "updateForm.jsp"); return mav; }
	 * 
	 * @RequestMapping(value = "/write/deleteDo.html") public ModelAndView
	 * deleteDo(Writing writing) { Writing old =
	 * writeDao.getImageWriting(writing.getWriting_id()); ModelAndView mav = new
	 * ModelAndView("home/index"); if
	 * (writing.getPassword().equals(old.getPassword())) {
	 * writeDao.deleteWriting(writing.getWriting_id()); mav.addObject("BODY",
	 * "deleteResult.jsp");
	 * 
	 * } else { mav.addObject("BODY", "deleteResult.jsp?id=" +
	 * writing.getWriting_id());
	 * 
	 * } return mav;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/write/delete.html") public ModelAndView
	 * delete(Integer id) { ModelAndView mav = new ModelAndView("home/index");
	 * Writing writing = writeDao.getImageWriting(id); mav.addObject(writing);
	 * mav.addObject("BODY", "deleteForm.jsp"); return mav;
	 * 
	 * }
	 */

	@RequestMapping(value = "/write/writeList.html")
	public ModelAndView list(Integer SEQNO, Integer PAGE_NUM, Integer category) {
		if (PAGE_NUM == null)
			PAGE_NUM = 1;
		ModelAndView mav = new ModelAndView("home/index");
		if (SEQNO != null) {
			System.out.println("ROWNUM : "+SEQNO);
			int rownum = writeDao.selectRownum(SEQNO);
			System.out.println("ROWNUM : "+rownum);
			int page = rownum / 20;
			if (rownum % 20 != 0)
				page++;
			PAGE_NUM = page;
		}
		int currentPage = PAGE_NUM;
		int totalPageCount = 0;
		int startRow = 0;
		int endRow = 0;
		int count = writeDao.selectImageCount(category);
		if (count > 0) {
			totalPageCount = count / 20;
			if (count % 20 > 0)
				totalPageCount++;
			startRow = (currentPage - 1) * 20 + 1;
			endRow = currentPage * 20;
			if (endRow > count)
				endRow = count;

		}
		Condition c = new Condition();
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		c.setC_num(category);
		List<ItemWriting> writeList = writeDao.getItemWriting(c);
		mav.addObject("LIST", writeList);
		mav.addObject("count", count);
		mav.addObject("startRow", startRow);
		mav.addObject("endRow", endRow);
		mav.addObject("category", category);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageCount", totalPageCount);
		mav.addObject("BODY", "imageListView.jsp");
		return mav;
	}

	@RequestMapping(value = "/write/write.html")
	public ModelAndView write(@Valid @ModelAttribute ItemWriting itemwriting, BindingResult br, HttpSession session) {
		if (br.hasErrors()) {

			/*
			 * List<ObjectError> list = br.getAllErrors(); for (ObjectError e : list) {
			 * System.out.println(e); }
			 */
			ModelAndView mav = new ModelAndView("home/index");
			mav.addObject("BODY", "writeForm.jsp");
			return mav;
		}
		MultipartFile multifileA = itemwriting.getImageA();
		MultipartFile multifileB = itemwriting.getImageB();
		String fileName = null;
		String path = null;
		OutputStream os = null;
		if (multifileA != null) {
			fileName = multifileA.getOriginalFilename();
			ServletContext ctx = session.getServletContext();
			path = ctx.getRealPath("/upload/" + fileName);
			try {
				os = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(multifileA.getInputStream());
				byte[] buffer = new byte[8156];
				int read = 0;
				while ((read = bis.read(buffer)) > 0) {
					os.write(buffer, 0, read);
				}

			} catch (Exception e) {

			}
			itemwriting.setImage1(fileName);
		}
		if (multifileB != null) {
			fileName = multifileB.getOriginalFilename();
			ServletContext ctx = session.getServletContext();
			path = ctx.getRealPath("/upload/" + fileName);
			try {
				os = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(multifileB.getInputStream());
				byte[] buffer = new byte[8156];
				int read = 0;
				while ((read = bis.read(buffer)) > 0) {
					os.write(buffer, 0, read);
				}

			} catch (Exception e) {

			}
			itemwriting.setImage2(fileName);
		}
		Integer maxId = writeDao.getMaxWritingId();

		itemwriting.setWriting_id(maxId + 1);
		writeDao.insertWriting(itemwriting);
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject("BODY", "writeResult.jsp?SEQNO=" + (maxId + 1));
		return mav;

	}

	@RequestMapping(value = "/write/writeForm.html")
	public ModelAndView form(HttpSession session) {
		String id = (String) session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/index");
		if (id == null) {
			mav.addObject("NOLOGIN", "yes");
			mav.addObject("guest", new Custom_info());
			mav.addObject("BODY", "login.jsp");
		} else {
			List<Category> category = writeDao.getCategory();
			mav.addObject("category", category);
			mav.addObject("BODY", "writeForm.jsp");
			mav.addObject(new ItemWriting());
		}
		return mav;
	}

}
