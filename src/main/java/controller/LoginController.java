package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.LoginCatalog;
import model.Cart;
import model.CartItem;
import model.Custom_info;

@Controller
public class LoginController {
	@Autowired
	private LoginCatalog loginCatalog;
	@Autowired
	private Cart cart;

	@RequestMapping(value = "/login/login.html")
	public ModelAndView loginForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home/index");
		request.setAttribute("guest", new Custom_info());
		mav.addObject("BODY", "login.jsp");
		return mav;
	}

	@RequestMapping(value = "/login/index.html", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(@Valid @ModelAttribute("guest") Custom_info guest, BindingResult br,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("home/index");
		if (br.hasErrors()) {

			/*
			 * List<ObjectError> list = br.getAllErrors(); for (ObjectError e : list) {
			 * System.out.println(e); }
			 */

			mav.addObject("BODY", "login.jsp");
			return mav;
		}
		String password = loginCatalog.getPwd(guest.getId());
		if (password == null || !guest.getPassword().equals(password)) {

		} else {
			session.setAttribute("loginUser", guest.getId());
			List<CartItem> cartList = cart.getCart(guest.getId());
			if (cartList != null) {
				Iterator it = cartList.iterator();
				int i = 0;
				while (it.hasNext()) {
					CartItem ci = (CartItem) it.next();
					this.cart.setCodeList(i, ci.getCode());
					this.cart.setNumList(i, ci.getNum());
				}
				session.setAttribute("CART", this.cart);
			}
		}
		mav.addObject("BODY", "loginResult.jsp");
		return mav;
	}
}
