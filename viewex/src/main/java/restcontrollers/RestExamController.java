package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import commons.rest.JsonResult;
import models.Member.Member;
import models.Member.MemberDao;

@RestController
public class RestExamController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/rest/member/{id}")
	public JsonResult<Member> member(@PathVariable("id") String memId) {
		JsonResult<Member> jsonResult = new JsonResult<>();
		
		Member member = memberDao.get(memId);
		jsonResult.setSuccess(true);
		jsonResult.setData(member);
		
		return jsonResult;
	}
	
	@GetMapping("/rest/members")
	public JsonResult<List<Member>> members() {
		JsonResult<List<Member>> jsonResult = new JsonResult<>();
		List<Member> members = memberDao.gets();
		jsonResult.setSuccess(true);
		jsonResult.setData(members);
		
		return jsonResult;
	}
}
