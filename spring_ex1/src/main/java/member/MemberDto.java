package member;

import java.time.LocalDateTime;

// DTO(Data Transfer Object, 데이터 전송 객체)
public class MemberDto {
	private String memId; // 아이디
	private String memPw; // 비밀번호
	private String memNm; // 회원명
	private LocalDateTime regDt; // 회원 가입일
	
	// 기본 생성자
	public MemberDto() {}
	
	// 생성자
	public MemberDto(String memId, String memPw, String memNm, LocalDateTime regDt) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
		this.regDt = regDt;
	}

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", regDt=" + regDt + "]";
	}
}
