package services.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import models.file.FileInfo;
import models.file.FileInfoDao;

@Service
public class FileUploadService {
	
	@Value("${file.uploadPath}")
	private String uploadPath;
	
	@Autowired
	private FileInfoDao fileInfoDao;
	
	public List<FileInfo> process(MultipartFile[] file) {
		String gid = "" + System.currentTimeMillis();
		return process(file, gid);
	}
	
	public List<FileInfo> process(MultipartFile[] files, String gid) {
		/*
		 * 1. 파일 정보 DB에 저장
		 * 2. 파일 정보 데이터 id -> 서버 업로드 파일 경로
		 * 3. 파일 업로드
		 * 4. 업로드한 파일 정보 반환
		 */
		
		gid = (gid == null || gid.isBlank()) ? "" + System.currentTimeMillis() : gid;
		
		List<FileInfo> fileInfos = new ArrayList<>(); // 파일 업로드 성공 파일 정보
		for(MultipartFile file : files) {
			/* 파일 정보 DB 저장 S */
			FileInfo fileInfo = new FileInfo();
			fileInfo.setGid(gid);
			fileInfo.setFileName(file.getOriginalFilename()); // 업로드 파일 원본 이름 - 다운로드시 활용
			fileInfo.setFileType(file.getContentType()); // image/png, image/gif ... 
			
			fileInfo = fileInfoDao.register(fileInfo);
			
			/* 파일 정보 DB 저장 E */
			
			/*
			 * 1. .. 10개로 나뉘는 폴더 (나머지 연산(%) 처리)
			 * - 1, 11, 21... - 1폴더
			 * - 2, 12, 22, 32... - 2폴더
			 */
			long id = fileInfo.getId();
			String uploadDir = uploadPath + "/" + (id % 10);
			File _uploadDir = new File(uploadDir);
			if(!_uploadDir.exists()) {
				_uploadDir.mkdir();
			}
			
			String uploadFilePath = uploadDir + "/" + id;
			
			// 파일 업로드
			try {
				file.transferTo(new File(uploadFilePath));
				
				// 파일 업로드 성공 -> 파일 정보를 담는
				fileInfos.add(fileInfo);
			} catch (IOException e) {
				e.printStackTrace();
				
				// 파일 업로드 실패 파일 정보 삭제
				fileInfoDao.remove(id);
				
				throw new RuntimeException("파일 업로드 실패하였습니다.");
			}
			
		}
		return fileInfos;
	}
}
