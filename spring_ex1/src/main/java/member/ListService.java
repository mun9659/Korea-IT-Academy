package member;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ListService {
	
	@Autowired
	private MemberDao memberDao;
	//@Autowired(required = false)
	//private DateTimeFormatter formatter;
	
	@Autowired
	private Optional<DateTimeFormatter> opt;
	
	public void listing() {
		Map<String, MemberDto> members = memberDao.getMembers();
		for(Map.Entry<String, MemberDto> entry : members.entrySet()) {
			MemberDto member = entry.getValue();
			System.out.println(member);
			
			if(opt.isPresent()) {
				System.out.println(opt.get().format(member.getRegDt()));
			}
			
			/*
			if(formatter != null) {
				System.out.println(formatter.format(member.getRegDt()));
			}
			*/
		}
	}
	
	/*
	@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> opt) {
		if(opt.isPresent()) {
			formatter = opt.get();
		}
	}
	*/
	
	/*
	// @Autowired(required=false) // required = false -> 빈 객체가 없으면 주입 X
	@Autowired 
	public void setDateTimeFormatter(@Nullable DateTimeFormatter formatter) { // 빈 객체가 없으면 null을 주입
		System.out.println("호출되나요?"); // @Nullable로 한 경우 메서드는 호출하기에 '호출되나요?'가 나타난다
		this.formatter = formatter;
	}
	*/
}
