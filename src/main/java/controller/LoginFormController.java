package controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;

@Controller
public class LoginFormController {
	private Shop shop;
	private Validator loginValidator;

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@ModelAttribute
	public User setUp() {
		return new User();// login.jsp에 주입될 객체 생성
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginFormSetup() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult br) {
		this.loginValidator.validate(user, br);// 유효성 검사 실행
		ModelAndView mav = new ModelAndView();
		if (br.hasErrors()) {// 유효성 검사 결과 오류가 있는 경우, login.jsp에 에러메세지 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			User loginUser = this.shop.getUser(user); // DB에서 조회
			if (loginUser != null) {// 조회결과가 존재하는 경우, 즉 로그인 성공
				mav.setViewName("loginSuccess"); // 뷰이름 설정
				mav.addObject("loginUser", loginUser); // 조회결과 설정
				return mav;

			} else {
				br.reject("error.login.user"); // 에러메시지 출력
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		} catch (EmptyResultDataAccessException e) {
			br.reject("error.login.user");// 에러 메세지 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}
