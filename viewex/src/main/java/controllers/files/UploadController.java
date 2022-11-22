package controllers.files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.rest.JsonResult;

@Controller
@RequestMapping("/file/upload")
public class UploadController {
	
	@GetMapping
	public String upload() {
		return "file/upload";
	}
	
	@PostMapping
	@ResponseBody
	public JsonResult<Object> process() {
		JsonResult<Object> jsonResult = new JsonResult<>();
		return jsonResult;
	}
}
