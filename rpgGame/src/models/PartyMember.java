package models;

public class PartyMember {

	public static final int PARTY = 4;

	private String rank;
	private int level;
	private String gender;
	private String name;
	private int age;

	// ability
	private int STR;
	private int AGI;
	private int INT;

	private int maxHp;
	private int hp;
	private int maxMp;
	private int mp;

	private double att;
	private double def;

	private int exp;
	boolean party;

	Item weapon;
	Item armor;
	Item accessory;

	public PartyMember(String r, String g, String n, int a, int S, int AG, int I, double att, double def, int mH, int mM) {
		this.rank = r;
		this.level = 1;
		this.gender = g;
		this.name = n;
		this.age = a;

		this.STR = S;
		this.AGI = AG;
		this.INT = I;

		this.att = att;
		this.def = def;
		this.maxHp = mH;
		this.hp = maxHp;
		this.maxMp = mM;
		this.mp = maxMp;
		this.exp = 50;
		this.party = false;
		
		weapon = null;
		armor = null;
		accessory = null;
	}

	public String getRank() {
		return rank;
	}

	public int getLevel() {
		return level;
	}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSTR() {
		return STR;
	}

	public int getAGI() {
		return AGI;
	}

	public int getINT() {
		return INT;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public double getAtt() {
		return att;
	}

	public double getDef() {
		return def;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public void printStatus() {
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + level + "]");
	}

	public void printEquitedItem() {
		if (weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + "]");
		}
		if (armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + "]");
		}
		if (accessory == null) {
			System.out.println("[장신구 : 없음 ]");
		} else {
			System.out.println("[장신구 : " + "]");
		}
	}
}
