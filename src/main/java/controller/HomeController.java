package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Bbs;
import model.Custom_info;

@Controller
public class HomeController {

	@Autowired
	private WriteCatalog writeCatalog;



	@RequestMapping(value = "/home/index.html")
	public ModelAndView intro(String BODY) {
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject("BODY", BODY);
		return mav;
	}

	@RequestMapping(value = "/home/bbsForm.html")
	public ModelAndView bbsForm() {

		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject(new Bbs()); // ��ü���� Bbs -> bbs
		mav.addObject("BODY", "bbsInput.jsp");

		return mav;
	}

	@RequestMapping(value = "/home/write.html", method = RequestMethod.POST) // �Խñ� ���
	public ModelAndView write(@Valid Bbs bbs, BindingResult br, HttpSession session) {

		if (br.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY", "bbsInput.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}

		String id = (String) session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");

		if (id == null) {// �α����� ���� ���� ���
			mav.addObject("NOLOGIN", "yes");
			mav.addObject("guest", new Custom_info());
			mav.addObject("BODY", "nologin.jsp");
			return mav;
		} else {// �α����� �� ���
			bbs.setId(id);// �ۼ��� ������ ����
			writeCatalog.putBBS(bbs);// bd�� ����
			return new ModelAndView("redirect:/read/read.html");
		}
	}

	@RequestMapping(value = "/home/userentry.html")
	public ModelAndView entryForm() {

		ModelAndView mav = new ModelAndView("home/index");

		mav.addObject("guest", new Custom_info());
		mav.addObject("BODY", "userentry.jsp");
		return mav;
	}
}
