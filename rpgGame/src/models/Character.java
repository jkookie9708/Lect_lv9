package models;

public class Character {
	
	private int level;
	private String gender; 
	private String name;
	private int age;
	private int gold;
	
	// ability
	private int STR;
	private int AGI;
	private int INT;
	
	private int hp;
	private int mp;
	
	
	public Character(String gender, String name, int age, int STR, int AGI, int INT, int hp, int mp) {
		this.level = 1;
		this.gender = gender;
		this.name = name;
		this.age = age;
		this.STR = STR;
		this.AGI = AGI;
		this.INT = INT;
		this.hp = hp;
		this.mp = mp;
		this.gold = 0;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public int getLevel() {
		return level;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
