package member;

import java.util.*;


// DAO(Data Access Object, 데이터 접속 개체 -> 데이터를 처리하는 객체(DB처리))
// 현재 DB랑 연결하진 않아서 Map으로 수업
public class MemberDao {
	private Map<String, MemberDto> members = new HashMap<>();
	
	// 회원 가입
	public void register(MemberDto member) {
		members.put(member.getMemId(), member);
	}
	
	// 회원 목록 조회
	public Map<String, MemberDto> getMembers() {
		return members;
	}
}
