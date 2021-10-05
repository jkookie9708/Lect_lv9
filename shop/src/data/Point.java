package data;

public class Point {

	private int point;
	private int code;
	
	public Point() {
		this.point = 1000; // bonus
	}
	
	public Point(int money, int code) {
		this.point = money;
		this.code = code;
	}
	
	// getter
	public int getPoint() {
		return point;
	}
	
	// setter
	public void setPoint(int point) {
		this.point = point;
	}
}
