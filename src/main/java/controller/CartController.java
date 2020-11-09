package controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import model.Cart;
import model.CartItem;
import model.Custom_info;

@Controller
public class CartController {

	@Autowired
	private Cart cart;

	@RequestMapping(value = "/cart/modify.html")
	public ModelAndView modify(String CODE, String SIZEE, Integer NUM, String BTN, HttpSession session) {
		String id = (String) session.getAttribute("loginUser");
		if (BTN.equals("수정")) {
			cart.modifyItem(CODE, SIZEE, NUM, id);
		} else if (BTN.equals("삭제")) {
			cart.deleteItem(CODE, SIZEE, id);

		}
		return new ModelAndView("redirect:/cart/show.html");

	}

	@RequestMapping(value = "/cart/show.html")
	public ModelAndView show(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/index");
		String id = (String) session.getAttribute("loginUser");

		if (id == null) {
			mav.addObject("NOCART", "yes");
			mav.addObject("guest", new Custom_info());
			mav.addObject("BODY", "login.jsp");
			return mav;
		}
		List<CartItem> cartList = cart.getCart(id);

		int totalAmount = 0;
		if (cartList.size() > 0) {
			Iterator it = cartList.iterator();
			while (it.hasNext()) {
				CartItem ci = (CartItem) it.next();
				int total = ci.getPrice() * ci.getNum();
				totalAmount = totalAmount + total;
			}
		} else {
			mav.addObject("SIZE", "NO");
		}
		mav.addObject("totalAmount", totalAmount);
		mav.addObject("BODY", "cartListView.jsp");
		mav.addObject("CART_LIST", cartList);
		return mav;
	}

	@RequestMapping(value = "/cart/login.html", method = RequestMethod.POST)
	public ModelAndView cartLogin(@Valid @ModelAttribute("guest") Custom_info guest, BindingResult br,
			HttpSession session) {
		if (br.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		String password = loginDao.getPassword(guest.getId());
		if (!guest.getPassword().equals(password)) {
			mav.addObject("cartLogin", "fail");
			return mav;
		} else {
			mav.addObject("cartLogin", "success");
			session.setAttribute("loginUser", guest.getId());
		}
		return mav;
	}

	@Autowired
	private LoginDao loginDao;

	@RequestMapping(value = "/cart/login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT", "nocartlogin");
		mav.addObject("guest", new Custom_info());
		return mav;
	}

	@RequestMapping(value = "/cart/addCart.html")
	public ModelAndView addCart(String CODE, HttpSession session, String SIZE, int NUM) {
		String id = (String) session.getAttribute("loginUser");
		if (id == null) {
			ModelAndView mav = new ModelAndView("redirect:/cart/login.html");
			mav.addObject("RESULT", "nologin");
			return mav;
		}
		Cart cart = (Cart) session.getAttribute("CART");
		if (cart == null)
			cart = this.cart;
		cart.addCart(CODE, SIZE, NUM, id);
		session.setAttribute("CART", cart);
		ModelAndView mav = new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM", 1);
		return mav;
	}

}
