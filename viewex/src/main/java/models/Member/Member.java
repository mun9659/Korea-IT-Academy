package models.Member;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Member {
	private long memNo;
	private String memId;
	
	// RestController로 Json 표시할 때 무시하도록 하는 애노테이션
	@JsonIgnore
	private String memPw;
	private String memNm;
	private String email;
	private String mobile;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime regDt;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modDt;
	
	public long getMemNo() {
		return memNo;
	}
	
	public void setMemNo(long memNo) {
		this.memNo = memNo;
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
	
	public LocalDateTime getRegDt() {
		return regDt;
	}
	
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	
	public LocalDateTime getModDt() {
		return modDt;
	}
	
	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", email="
				+ email + ", mobile=" + mobile + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}
}
