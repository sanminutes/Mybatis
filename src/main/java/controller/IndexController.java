package controller;

import java.util.HashMap;
import java.util.List;
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
public class IndexController {
	@Autowired
	private Shop shop;
	@RequestMapping
	public ModelAndView handle(HttpSession session) throws Exception {
		List<Item> itemList=this.shop.getItems();//DB에서 과일목록 검색
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("itemList", itemList);//검색결과를 맵에 저장
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER_KEY");//세션에서 검색
		if(loginUser != null) {//로그인이 된 경우
			mav.addObject("loginUser",loginUser);
		}
		mav.addAllObjects(model);//맵을 ModelAndView에 저장
		return mav;
	}
}












