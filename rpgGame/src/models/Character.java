package models;

public class Character {
	
	private int gender; 
	private String name;
	private int age;
	
	public Character(int gender, String name, int age) {
		this.gender = gender;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
