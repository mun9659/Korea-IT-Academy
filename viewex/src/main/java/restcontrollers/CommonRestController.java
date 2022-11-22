package restcontrollers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import commons.rest.JsonResult;

@RestControllerAdvice("restcontrollers")
public class CommonRestController {
	
	@ExceptionHandler(Exception.class)
	public JsonResult<Object> errorHandle(Exception e) {
		JsonResult<Object> jsonResult = new JsonResult<>();
		jsonResult.setSuccess(false);
		jsonResult.setMessage(e.getMessage());
		
		e.printStackTrace();
		
		return jsonResult;
	}
		
	
}
