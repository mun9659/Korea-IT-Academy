package ch04;

public class Schedule {
	int year;
	int month;
	int day;
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		// if(day >= 28) day = 28;
		
		this.day = day;
	}
	
	public void showDate() {
		System.out.println(year + "-" + month + "-" + day);
	}
}
