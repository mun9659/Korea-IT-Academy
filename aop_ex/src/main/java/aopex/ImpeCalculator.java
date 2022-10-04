package aopex;

public class ImpeCalculator implements Calculator {
	@Override
	public long factorial(long num) {
		// 5! -> 5 * 4 * 3 * 2 * 1 === 1 * 2 * 3 * 4 * 5
		
		// long start = System.nanoTime();
		
		long result = 1L;
		
		for(long i = 1L; i <= num; i++) {
			result *= i;
		}
		
		// long end = System.nanoTime();
		
		// System.out.printf("ImpeCalculator 소요시간 = %d%n", end - start);
		
		return result;
	}
}
