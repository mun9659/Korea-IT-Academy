package ch04;

public class Ex04 {
	public static void main(String[] args) {
		Person p1 = new Person("이름", 40);
		Person p2 = new Person();
		
		p1.printInfo();
		p2.printInfo();
		
		//System.out.println("p1 : " + p1);
		//System.out.println("this : " + p1.returnThis());
		//System.out.println(p1 == p1.returnThis());
	}
}
