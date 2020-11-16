package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Shop;
import model.Items;

public class IndexController implements Controller {
	private Shop shop;
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();//ModelAndView 생성
		List<Items> itemList = shop.getItems();//DB에서 목록을 조회
		Map<String,Object> model = new HashMap<String,Object>();//맵을 생성
		model.put("itemList", itemList);//조회 결과를 맵에 저장
		mav.addAllObjects(model);//조회 결과를 ModelAndView에 저장한다.
		mav.setViewName("index");//ModelAndView에 뷰의 이름을 저장한다.
		return mav;//ModelAndView를 서블릿으로 리턴한다.
	}
}








