package models.Member;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Member> rowMapper = (rs, i) -> {
		Member member = new Member();
		
		member.setMemNo(rs.getLong("memNo"));
		member.setMemId(rs.getString("memId"));
		member.setMemPw(rs.getString("memPw"));
		member.setMemNm(rs.getString("memNm"));
		member.setEmail(rs.getString("email"));
		member.setMobile(rs.getString("mobile"));
		member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
		Timestamp modDt = rs.getTimestamp("modDt");
		if(modDt != null) {
			member.setModDt(modDt.toLocalDateTime());
		}
		return member;
	};
	
	public boolean register(Member member) {
		String sql = "INSERT INTO member(memId, memPw, memNm, email, mobile) " +
							"VALUES(?, ?, ?, ?, ?)";
		
		// 010-3481-2101, 010 348 2101, 010_3481_2101 -> 숫자변환 -> 01034812101
		String mobile = null;
		String _mobile = member.getMobile();
		if(_mobile != null) {
			mobile = _mobile.replaceAll("\\D", ""); // 숫자가 아닌 문자를 제거 -> 숫자만 남는다.
		}
		
		int affectedRows = jdbcTemplate.update(sql, 
																member.getMemId(),
																member.getMemPw(),
																member.getMemNm(),
																member.getEmail(),
																mobile);
		
		return affectedRows > 0;
	}
	
	public Member get(String memId) {
		try {
			
			String sql = "SELECT * FROM member WHERE memId = ?";
			// queryForObject : 데이터가 없으면 에러 발생한다
			Member _member = 
					jdbcTemplate.queryForObject(sql, rowMapper, memId);
			
			if(_member == null) {
				throw new RuntimeException("회원 없음!");
			}
			
			return _member;
		} catch (Exception e) {
			if (e instanceof RuntimeException) {
				throw e;
			}
			return null;
		}
		
		/* 리스트 형식
		List<Member> members = 
			jdbcTemplate.query(sql, new RowMapper<Member>() {
	
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member();
					
					member.setMemNo(rs.getLong("memNo"));
					member.setMemId(rs.getString("memId"));
					member.setMemPw(rs.getString("memPw"));
					member.setMemNm(rs.getString("memNm"));
					member.setEmail(rs.getString("email"));
					member.setMobile(rs.getString("mobile"));
					member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
					Timestamp modDt = rs.getTimestamp("modDt");
					if(modDt != null) {
						member.setModDt(modDt.toLocalDateTime());
					}
					
					return member;
				}
			}, memId);
		*/
		
		// Member member = members == null ? null : members.get(0);
	}
	
	public List<Member> gets() {
		List<Member> members = jdbcTemplate.query("SELECT * FROM member", rowMapper);
		return members;
	}
}
