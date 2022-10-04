package main;

import aopex.*;

public class ProxyCalculator {
	
	private Calculator calculator;
	
	public ProxyCalculator(Calculator calculator) {
		this.calculator = calculator; 
	}
	
	public long factorial(long num) {
		long start = System.nanoTime(); // 핵심 기능 앞의 공통 기능
		
		long result = calculator.factorial(num); // 핵심 기능을 대신 수행
		
		long end = System.nanoTime();
		
		// 핵심 기능 뒤에 공통 기능
		System.out.printf("%s 걸린시간 = %d%n", calculator.getClass().getSimpleName(), end - start);
		return result;
	}
	
}
