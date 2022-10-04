package lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
	private String name;
	
	public void send() {
		System.out.printf("%s에게 메시지 전달\n", name);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception { // 초기화 단계에서 호출되는 메서드
		System.out.println("afterPropertiesSet() 호출!!");
	}

	@Override
	public void destroy() throws Exception { // 소멸 전에 호출되는 메서드
		System.out.println("destroy() 호출!!");
	}
}
