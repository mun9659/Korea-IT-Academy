package ch06;

public class Ex02 {
	
	static Animal animal2 = new Animal() {
		@Override
		public void move() {
			System.out.println("Move!!");
		}
	};
	
	public static void main(String[] args) {
		
		Animal animal = new Animal() {
			
			@Override
			public void move() {
				System.out.println("Move!");
			}
		};
		
		animal.move();
		animal2.move();
	}

}
