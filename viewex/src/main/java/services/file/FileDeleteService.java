package services.file;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import models.file.FileInfo;
import models.file.FileInfoDao;

@Service
public class FileDeleteService {
	
	@Value("${file.uploadPath}")
	private String uploadPath;
	
	@Autowired
	private FileInfoDao fileInfoDao;
	
	public FileInfo process(long id) {
		FileInfo fileInfo = fileInfoDao.get(id);
		if(fileInfo == null) {
			throw new RuntimeException("파일이 존재하지 않습니다.");
		}
		
		String filePath = uploadPath + "/" + (id % 10) + "/" + id;
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
		
		boolean result = fileInfoDao.remove(id);
		if(!result) { // 파일 DB 삭제 실패
			throw new RuntimeException("파일 삭제 실패!");
		}
		
		return fileInfo;
	}
}
