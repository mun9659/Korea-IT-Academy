package ch04;

public class Person {
	private String name; // default
	private int age;
	
	// 생성자
	public Person() {
		// name = "이름없음";
		// age = 0;
		this("이름없음", 0);
	}
	
	Person(String name, int age) {
		// System.out.println(this);
		// 객체가 생성 상태 -> 멤버 변수의 초기화
		// name = personName;
		// age = personAge;
		this.name = name;
		this.age = age;
	}
	
	Person returnThis() {
		return this;
	}
	
	public void printInfo() {
		System.out.println(name + "," + age);
	}
}
