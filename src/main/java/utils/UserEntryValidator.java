package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}// 검증의 대상이 되는 객체를 설정한다. 3-3의 검증대상 객체 : User

	public void validate(Object target, Errors errors) {
		User user = (User) target;// 검증 대상 객체를 수신
		// 검증 시작
		if (!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required.user");
		} // 사용자 계정이 입력되지 않은 경우
		if (!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required.user");
		}
		if (!StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required.user");
		}
		if (!StringUtils.hasLength(user.getAddress())) {
			errors.rejectValue("address", "error.required.user");
		}
		if (!StringUtils.hasLength(user.getEmail())) {
			errors.rejectValue("email", "error.required.user");
		}
		if (!StringUtils.hasLength(user.getBirthday())) {
			errors.rejectValue("birthday", "error.required.user");
		}
		if (user.getBirthday().length() != 8) {
			errors.rejectValue("birthday", "typeMismatch.user");
		}
		if (errors.hasErrors()) {
			errors.reject("error.input.user");
		}
		// 검증 종료
	}// 검증을 수행하는 메서드, 컨트롤러에서 호출한다.
}
