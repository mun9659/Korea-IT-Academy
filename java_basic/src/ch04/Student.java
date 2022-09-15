package ch04;

public class Student {
	int studentId; 	// 학번
	String name; 	// 이름
	int ban;			// 반
	int grade;			// 학년
	static int serialNum;	// 시리얼넘버
	
	// 매개변수 없는 생성자는 따로 정의 X
	// 컴파일시 자동 추가
	// 반환 자료형 X
	// 생성자 메서드 목적 -> 객체 생성, 명확한 목적
	// 반환값 명시 X
	// 기본 생성자 
	//   -> 생성자가 아무것도 정의 되지 않은 경우 -> 추가
	/*
	Student(String studentName) {
		name = studentName;
	}
	*/
	
	void study() {
		System.out.println(serialNum);
		printInfo();
		System.out.println(name + "가 공부한다.");
	}
	
	static void printInfo() {
		Student s = new Student();
		 System.out.println(s.studentId + ", " + s.name);
		// System.out.println("정보 출력!");
	}
}
