package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import model.Custom_info;
import model.Item;

@Controller
public class ProductController {
	@Autowired
	private ItemCatalog itemCatalog;

	@RequestMapping(value = "/product/open.html")
	public ModelAndView open() {
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject(new Item());
		mav.addObject("BODY", "inputItem.jsp");
		return mav;
	}

	@RequestMapping(value = "/product/entry.html")
	public ModelAndView entry(@Valid Item item, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/index");
		if (br.hasErrors()) {
			mav.addObject("BODY", "inputItem.jsp");
			return mav;
		}
		String id = (String) session.getAttribute("loginUser");
		if (id == null) {
			mav.addObject("NOTITEM", "yes");
			mav.addObject("guest", new Custom_info());
			mav.addObject("BODY", "nologin.jsp");
			return mav;
		} else {
			itemCatalog.putItem(item);
			return new ModelAndView("redirect:/read/product.html");
		}
	}
}
