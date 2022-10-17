package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.config.AppCtx;

public class Ex01 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		/*
		// String sql = "INSERT INTO member (memNo, memId, memNm, email, mobile)" + "VALUES(?, ? ,? ,? ,?)";
		// jdbcTemplate.update(sql, 1, "user01", "사용자01", "user01@test.org", "01000000000");
		// jdbcTemplate.update(sql, 2, "user02", "사용자02", "user02@test.org", "01000000002");
		// int affectedRows = jdbcTemplate.update(sql, 3, "user03", "사용자03", "user03@test.org", "01000000003");
		// System.out.printf("반영된 레코드 수 : %d\n", affectedRows);
		 */
		
		String sql = "SELECT * FROM MEMBER";
		// 람다식 사용 가능(매서드가 한개라서)
		List<Member> members = jdbcTemplate.query(sql, (rs, rowNum) -> {
				Member member = new Member();
				
				member.setMemNo(rs.getLong("memNo"));
				member.setMemId(rs.getString("memId"));
				member.setMemNm(rs.getString("memNm"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
				Timestamp modDt = rs.getTimestamp("modDt");
				if(modDt != null) {
					member.setModDt(modDt.toLocalDateTime());
				}
				return member;
		});
		/*
		 * 람다식 아닌 기본형태
		List<Member> members = jdbcTemplate.query(sql, new RowMapper<Member>() { // RowMapper 인터페이스
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				
				member.setMemNo(rs.getLong("memNo"));
				member.setMemId(rs.getString("memId"));
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
		});
		*/
		
		System.out.println(members);
		
		ctx.close();
	}
}
