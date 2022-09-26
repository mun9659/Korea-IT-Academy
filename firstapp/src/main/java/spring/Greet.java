package spring;

public class Greet {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void hello() {
		System.out.printf("안녕하세요 %s님\n", name);
	}
}
