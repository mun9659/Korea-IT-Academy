package ch04;

public class Ex03 {
	public static void main(String[] args) {
		
		Student.serialNum = 10;
		System.out.println(Student.serialNum);
		
		Student s1 = new Student();
		s1.printInfo();; // 멤버 메서드(인스턴스 메서드)
		s1.study(); // 멤버 메서드(인스턴스 메서드)
		/**
		Student s1 = new Student();
		Student s2 = new Student();
		**/
		/*
		 * static int serialNum -> 공간 1(데이터 영역)
		 * s1 이 접근하는 serialNum와 s2가 접근하는 serialNum은 같은 변수 공간!
		 */
		/**
		s1.serialNum = 10;
		s2.serialNum = 20;
	
		System.out.println("s1 = " + s1.serialNum);
		System.out.println("s2 = " + s2.serialNum);
		**/
	}
}
