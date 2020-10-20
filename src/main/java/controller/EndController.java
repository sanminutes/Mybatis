package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import logic.Shop;
import model.Cart;
import model.User;

@Controller
public class EndController {
	@Autowired
	private Shop shop;

	@RequestMapping()
	public ModelAndView end(HttpSession session) {
		User loginUser = (User) session.getAttribute("USER_KEY");
		if (loginUser == null)
			throw new LoginRequiredException("로그인 되어있지 않습니다.");
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		if (cart == null || cart.isEmpty())
			throw new CartEmptyException("카트가 비어있습니다.");
		this.shop.checkout(loginUser, cart); // 매출정보 저장
		cart.clearAll(); // 구매완료이므로 카트를 비운다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser", loginUser);
		return mav;
	}

}
