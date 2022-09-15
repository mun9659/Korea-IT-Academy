package ch04;

public class Ex01 {
	public static void main(String[] args) {
		
		/*
		 * 클래스명과 동일한 메서드(함수)
		 *   -> 객체를 생성하는 기능
		 *   -> 생성자
		 */
		
		// 기본자료형, 참조자료형(클래스형 자료)
		// s1 -> main 함수에 정의되어 있는 지역변수
		// s1 -> Student() 객체를 찾아갈수 있는 (메모리)주소 값
		Student s1 = new Student();
		System.out.println(s1);
		
		Student s2 = new Student();
		s2.name = "이름1";
		System.out.println(s2);
		System.out.println(s2.name);
		
		Student s3 = s2;
		
		s3.name = "이름2";
		System.out.println(s2.name);
		System.out.println(s3.name);
		
		//	s1.name = "학생명1";
		// s1.study();
	}
}
