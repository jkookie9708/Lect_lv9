package data;

import java.util.ArrayList;

public class User {

	private String id;
	private String pw;
	private int code;
	
	
	// private int point -> ArrayList<Point> points
	private ArrayList<Point> points = new ArrayList<>();
	
	
	public User(int code, String id, String pw) {
		this.code = code;
		this.id = id;
		this.pw = pw;
	}
	
	// getter
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public int getCode() {
		return code;
	}
	
	
	public int getPointsSize() {
		return this.points.size();
	}

	@Override
	public String toString() {
		String str = "";
		str += "[" + this.code + "] ";
		str += "Id : " + this.id + " / ";
		str += "Pw : " + this.pw;
		str += " (" + this.points.size() + "Point)";
		return str;
	};
	
}
