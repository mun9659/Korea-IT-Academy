package services.member;

import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import controllers.members.LoginRequest;
import models.Member.Member;
import models.Member.MemberDao;

@Service
public class LoginService {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private HttpSession session;
	
	public void process(LoginRequest loginRequest, Errors errors) {
		/*
		 * 1. 아이디로 조회했을 때 회원 존재 하는지?
		 * 2. 회원이 존재한다면 비밀번호 일치 여부 체크
		 * 3. 일치하면 로그인 처리 -> 세션 저장 처리 
		 */
		
		if(errors.hasErrors()) {
			return;
		}
		
		String memId = loginRequest.getMemId();
		Member member = memberDao.get(memId);
		if(member == null) {
			throw new RuntimeException("가입되지 않은 아이디 입니다.");
		}
		
		String memPw = loginRequest.getMemPw();
		boolean matched = BCrypt.checkpw(memPw, member.getMemPw());
		if(!matched) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		session.setAttribute("member", member);
	}
}
