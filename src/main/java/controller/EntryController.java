package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.LoginCatalog;
import model.Custom_info;

@Controller
public class EntryController {
	@Autowired
	private LoginCatalog loginCatalog;

	@RequestMapping(value = "/entry/entry.html")
	public ModelAndView entry(Custom_info guest, HttpSession session) {
		loginCatalog.putUser(guest);
		session.setAttribute("loginUser", guest.getId());
		return new ModelAndView("redirect:/entry/home.html");

	}

	@RequestMapping(value = "/entry/home.html")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject("BODY", "loginResult.jsp");
		return mav;
	}
}
