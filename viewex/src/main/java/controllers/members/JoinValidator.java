package controllers.members;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class JoinValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return JoinRequest.class.isAssignableFrom(clazz); // 검증하려면 커맨드 객체와 호환성
	}

	@Override
	public void validate(Object target, Errors errors) { // target - 검증하려는 커맨드객체, (여기서 JoinRequest)
		JoinRequest joinRequest = (JoinRequest) target;
		
		// 비밀번호 확인 비교
		String memPw = joinRequest.getMemPw();
		String memPwRe = joinRequest.getMemPwRe();
		if(!memPw.equals(memPwRe)) {
			errors.rejectValue("memPwRe", "JoinError", "비밀번호 확인에 실패했습니다.");
		}
	}

}
