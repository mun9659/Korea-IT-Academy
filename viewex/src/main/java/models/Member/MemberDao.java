package models.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
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
					jdbcTemplate.queryForObject(sql, (rs, i) -> {
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
					}, memId);
			
			return _member;
		} catch (Exception e) {
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
}
