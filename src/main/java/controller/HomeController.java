package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/home/index.html")
	public ModelAndView intro(String BODY) {
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject("BODY", BODY);
		return mav;
	}
}
