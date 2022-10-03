package member;

public class JoinService {
	
	// 필드
	private MemberDao memberDao;
	
	// 생성자
	public JoinService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// 메서드
	public void process(MemberDto member) {
		// process 메서드 내에서는 memberDao를 반드시 써야한다. -> 의존 주입
		memberDao.register(member);
	}
}
