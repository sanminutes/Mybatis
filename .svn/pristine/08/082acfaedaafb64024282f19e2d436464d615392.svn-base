package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;
import utils.LoginValidator;

@Controller
public class LoginformController {
	@Autowired
	private Shop shop;
	@Autowired
	private LoginValidator loginValidator;
	@ModelAttribute
	public User setup() {//폼에 주입될 객체 생성
		return new User();
	}
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "loginform/login";//출력될 뷰이름
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(User user,BindingResult br,HttpSession session) {
		this.loginValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			User loginUser=this.shop.getUser(user);//DB에서 사용자정보 검색
			if(loginUser != null) {//로그인 성공한 경우
				mav.setViewName("loginform/loginSuccess");
				mav.addObject("loginUser",loginUser);
				session.setAttribute("USER_KEY", loginUser);
				return mav;
			}else {//로그인 실패한 경우
				br.reject("error.login.user");
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		}catch(EmptyResultDataAccessException e) {
			br.reject("error.login.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}











