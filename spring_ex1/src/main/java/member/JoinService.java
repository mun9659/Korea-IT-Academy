package member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinService {
	
	// 필드
	// @Autowired // 의존성 자동주입 
	private MemberDao memberDao;
	
	/*
	 * // 생성자 
	 * public JoinService(MemberDAO memberDao) { 
	 * 		this.memberDao = memberDao;
	 * }
	 */
	
	// 메서드
	public void process(MemberDto member) {
		// process 메서드 내에서는 memberDAO를 반드시 써야 한다.
		// process 메서드에서는 memberDAO를 의존한다.
		memberDao.register(member);
		
		// System.out.println(memberDao.getMembers());
		// Map<String, MemberDTO> members =  memberDao.getMembers();
		// System.out.println(members);
	}
	
	// 메서드를 이용한 의존성 자동 주입
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
