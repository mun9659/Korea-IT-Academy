package controllers.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import commons.rest.JsonResult;
import models.file.FileInfo;
import services.file.FileDeleteService;

@RestController
public class DeleteController {
	
	@Autowired
	private FileDeleteService service;
	
	@GetMapping("/file/delete/{id}")
	public JsonResult<FileInfo> delete(@PathVariable long id) {
		
		FileInfo fileInfo = service.process(id);
		JsonResult<FileInfo> jsonResult = new JsonResult<>();
		jsonResult.setSuccess(true);
		jsonResult.setData(fileInfo);
		
		return jsonResult;
	}
}
