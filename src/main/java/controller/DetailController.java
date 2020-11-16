package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Items;

@Controller
public class DetailController {
	private Shop shop;

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@RequestMapping
	public ModelAndView detailItem(Integer itemId) {
		Items item = this.shop.getItem(itemId);//DB에서 상세정보 검색
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("item", item);
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(model);
		mav.setViewName("detail");
		return mav;
	}
}





















