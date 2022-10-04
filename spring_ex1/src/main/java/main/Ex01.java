package main;

import java.time.LocalDateTime;

import member.*;

public class Ex01 {

	public static void main(String[] args) {
		CachedMemberDAO memberDao = new CachedMemberDAO(); // 다형성(Polymorphism)
		// JoinService joinService = new JoinService(memberDao); // process가 의존하는 객체를 외부에서 전달 받음으로 의존성을 주입 받는다 -> DI(Dependency Injection)
		MemberDto member = new MemberDto("user01", "123456", "사용자01", LocalDateTime.now());
		// joinService.process(member);

	}

}
