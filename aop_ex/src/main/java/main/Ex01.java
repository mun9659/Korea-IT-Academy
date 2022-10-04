package main;

import aopex.*;

public class Ex01 {

	public static void main(String[] args) {
		ImpeCalculator cal1 = new ImpeCalculator();
		RecCalculator cal2 = new RecCalculator();
		
		long result1 = cal1.factorial(10);
		long result2 = cal2.factorial(10); // 재귀적 방식 성능 느림
		
		System.out.printf("cal1 결과 = %d%n", result1);
		System.out.printf("cal2 결과 = %d%n", result2);
	}

}
