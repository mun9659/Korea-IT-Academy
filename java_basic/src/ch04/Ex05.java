package ch04;

public class Ex05 {
	public static void main(String[] args) {
		Schedule s = new Schedule();
		s.setYear(2022);
		s.setMonth(2);
		s.setDay(31);
		
		System.out.println(s.getMonth());
		
		s.showDate();
	}
}
