package ch05;

public class Ex02 {
	public static void main(String[] args) {
		B b1 = new C();
		B b2 = new D();
		
		// System.out.println(b1 instanceof C);
		C c1 = (C) b1;
		if(b2 instanceof C) {
			C c2 = (C)b2;
		}
	}
}
