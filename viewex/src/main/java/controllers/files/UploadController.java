package controllers.files;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import commons.rest.JsonResult;
import models.file.FileInfo;
import services.file.FileUploadService;

@Controller
@RequestMapping("/file/upload")
public class UploadController {
	
	@Autowired                                                            
	private FileUploadService service;
	
	@GetMapping
	public String upload(@RequestParam(name="gid", required=false) String gid, Model model) {
		model.addAttribute("gid", gid);
		model.addAttribute("addScript", new String[] {"fileupload"});
		model.addAttribute("addCss", new String[] {"fileupload"});
		return "file/upload";
	}
	
	@PostMapping
	@ResponseBody
	public JsonResult<List<FileInfo>> process(String gid, MultipartFile[] file) {
		
		List<FileInfo> fileInfos = service.process(file, gid);
		
		JsonResult<List<FileInfo>> jsonResult = new JsonResult<>();
		jsonResult.setSuccess(true);
		jsonResult.setData(fileInfos);
		
		return jsonResult;
	}
}
