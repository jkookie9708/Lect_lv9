package models;

public class PartyMember {
	
		String name;
		int level;
		int hp;
		int maxHp;
		int att;
		int def;
		int exp;
		boolean party;
		
		Item weapon;
		Item armor;
		Item accessory;
		
		public PartyMember(String n, int l, int h, int a, int d, int e) {
			name = n;	level = l;	maxHp = h;	att = a;
			def = d;	exp = e;	hp = maxHp;	party = false;
			weapon = null;	armor = null;	accessory = null;
		}
		public PartyMember(String n, int l, int h, int a, int d, int e , boolean p) {
			name = n;	level = l;	maxHp = h;	att = a;
			def = d;	exp = e;	hp = maxHp;	party = p;
			weapon = null;	armor = null;	accessory = null;
		}
		
		
		public String getName() {
			return name;
		}
		public int getLevel() {
			return level;
		}
		public int getHp() {
			return hp;
		}
		public int getMaxHp() {
			return maxHp;
		}
		public int getAtt() {
			return att;
		}
		public int getDef() {
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
				System.out.println("[무기 : " +  "]");
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
