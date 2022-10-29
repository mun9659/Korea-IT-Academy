package models.member;

import java.time.LocalDateTime;

public class Member {
	private String memId;
	private String memNm;
	private String email;
	private String mobile;
	private String intro;
	private LocalDateTime regDt;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memNm=" + memNm + ", email=" + email + ", mobile=" + mobile + ", regDt="
				+ regDt + "]";
	}
	
}
