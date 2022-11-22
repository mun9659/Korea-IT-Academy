package commons.rest;

public class JsonResult<T> {
	private boolean success;
	private T data;
	private String message;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "JsonResult [success=" + success + ", data=" + data + ", message=" + message + "]";
	}
}
