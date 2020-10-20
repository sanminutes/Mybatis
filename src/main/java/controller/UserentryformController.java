package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;
import utils.UserEntryValidator;

@Controller
public class UserentryformController {
	@Autowired
	private Shop shop;
	@Autowired
	private UserEntryValidator userEntryValidator;
	@Autowired
	private MessageSource messageSource;

	@ModelAttribute
	public User setup() {
		User user = new User();
		MessageSourceAccessor msa = new MessageSourceAccessor(messageSource);
		user.setUserId(msa.getMessage("user.userId.default"));
		user.setUserName(msa.getMessage("user.userName.default"));
		return user;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String suerEntryForm() {
		return "userentryform/userEntry"; // 출력될 뷰이름
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult br, HttpSession session) {
		this.userEntryValidator.validate(user, br); // 유효성 검사
		ModelAndView mav = new ModelAndView();
		if (br.hasErrors()) {// 유효성 검사가 실패한 경우
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			this.shop.putUser(user); // DB에 삽입
			session.setAttribute("USER_KEY", user); // 세션에 저장(로그인 상태유지용)
			mav.setViewName("userentryform/userEntrySuccess"); // 뷰이름 설정
			mav.addObject("user", user); // 사용자 정보를 mav에 저장
			return mav;
		} catch (DataIntegrityViolationException e) {
			// DB에 기본키로 설정된 데이터에 중복이 존재하는 경우발생
			br.reject("error.duplicate.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}

}
