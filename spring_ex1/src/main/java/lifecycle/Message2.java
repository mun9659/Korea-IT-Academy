package lifecycle;

public class Message2 {
	private String name;
	
	public void send() {
		System.out.printf("%s에게 메시지 전달\n", name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// @Bean 에서 initMethod 시 호출
	public void init() {
		System.out.println("초기화 시에 호출!!");
	}
	
	// @Bean 에서 destroyMethod 전 호출
	public void close() {
		System.out.println("소멸 전에 호출!!");
	}
}
