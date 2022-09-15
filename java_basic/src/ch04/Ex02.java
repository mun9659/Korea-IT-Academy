package ch04;

public class Ex02 {
	public static void main(String[] args) {
		/*
		int y = func(3); 
		System.out.println(y);
		 */
		
		int num1 = 10;
		int num2 = 20;
		int result = add(num1, num2);
		System.out.println(result);
	}
	
	static int func(int x) {
		int y = 2 * x + 1;
		
		return y;
	}
	
	// 메서드 안에 정의된 num1, num2 ->
	// 메서드가 실행되는 동안에만 스택 메모리에 공간을 할당받는다. -> 종료가 되면 메모리에서 해제
	// num1, num2는 메서드 안에서만 유효
	// 메서드 안( { ... } --> 지역) -> 지역변수
	static int add(int num1, int num2) {
		int result = num1 + num2;
		
		return result;
	}
}
