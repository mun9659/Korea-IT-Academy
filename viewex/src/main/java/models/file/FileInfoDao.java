package models.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FileInfoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean register(FileInfo fileInfo) {
		return false;
	}
	
	public FileInfo get(long id) {
		return null;
	}
	
	public List<FileInfo> gets(String gid) {
		return null;
	}
	
	public boolean remove(long id) {
		return false;
	}
	
	public boolean remove(String gid) {
		return false;
	}
	
}
