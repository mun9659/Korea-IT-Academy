package ch06;

public class Ex01 {
	public static void main(String[] args) {
		
		// Animal animal = new Animal(); // 추상클래스는 객체 생성 불가(미구현 기능)
		// 추상 클래스 : 하위클래스가 따라야할 표준을 정의
		// 추상클래스를 정의한 후 하위클래스에서 재정의를 시켜야 구현 가능
		// 특정한 조건 하 객체가 생성 ( + 미구현된 기능을 구현함으로써)
		// 메서드 내부, 멤버 변수에서 만들면 가능
		
		Dog dog = new Dog();
		dog.move();
		dog.num = 10;
		System.out.println(dog.num);
		
		Bird bird = new Bird();
		bird.move();
		bird.num = 20;
		System.out.println(bird.num);
	}
}
