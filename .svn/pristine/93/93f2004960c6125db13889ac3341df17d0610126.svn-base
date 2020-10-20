package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;
import model.User;

@Controller
public class DetailController {
	@Autowired
	private Shop shop;
	@RequestMapping
	public ModelAndView detailItem(Integer itemId, HttpSession session) {
		Item item=(Item)shop.getItem(itemId);//DB에서 상품번호로 상품정보 검색
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("item", item);
		ModelAndView mav = new ModelAndView();
		User loginUser=(User)session.getAttribute("USER_KEY");
		if(loginUser != null) mav.addObject("loginUser",loginUser);
		mav.addAllObjects(model);
		return mav;
	}
}











