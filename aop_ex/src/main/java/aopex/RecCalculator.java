package aopex;

public class RecCalculator implements Calculator {
	@Override
	public long factorial(long num) {
		
		//long start = System.nanoTime();
		
		if(num <= 0) return 1L;
		
		return num * factorial(num - 1);
		
		/*
		try {
			if(num <= 0) return 1L;
			
			return num * factorial(num - 1);
		} finally {
			// 정상 실행, 오류 실행 상관없이 출력
			long end = System.nanoTime();
			System.out.printf("RecCalculator 소요시간 = %d%n", end - start);
		}
		*/
	}
}
