package controller;

import java.util.ArrayList;

import models.PartyMember;

public class PartyManager {
	
	public static PartyManager instance = new PartyManager();
	private CharacterManager cm = new CharacterManager();
	private ArrayList<PartyMember> party = new ArrayList<>();
	private PartyMember [] partyList;
	private final int PARTY_SIZE = 4;

	public void PartyMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("=============== [파티 관리] ================");
			System.out.println("[1.용병 모집] [2.파티원목록] [3.파티원추가]\n[4.파티원교체] [5.파티추방] [0.뒤로가기]");
			String input = Main.sc.next();
			
			try {
				int sel = Integer.parseInt(input);
				
				if(sel == 1) printAllPartyMembers();
				else if(sel == 2) printPartyMembers();
				else if(sel == 3) addPartyMember();
				else if(sel == 4) switchPartyMember();
				else if(sel == 5) removePartyMember();
				else if(sel == 0) break;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

	public void printPartyMembers() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < party.size(); i++) {
			if (party.get(i).isParty()) {
				System.out.print("[" + (i + 1) + "번]");
				System.out.print(" [이름 : " + party.get(i).getName() + "]");
				System.out.print(" [레벨 : " + party.get(i).getLevel() + "]");
				System.out.print(" [체력 : " + party.get(i).getHp() + " / " + party.get(i).getMaxHp() + "]");
				System.out.print("[공격력 : " + party.get(i).getAtt() + "]");
				System.out.print(" [방어력 : " + party.get(i).getDef() + "]");
			}
		}
	}
	
	public void switchPartyMember() {
			
		printPartyMembers();
			System.out.println("교체할 번호를 입력하세요 ");
			String partyN = Main.sc.next();
			printAllPartyMembers();
			System.out.println("참가할 번호를 입력하세요 ");
			String guildN = Main.sc.next();
			
			try {
				int partyNum = Integer.parseInt(partyN);
				int guildNum = Integer.parseInt(guildN);
				
				partyList[partyNum -1].setParty(false);
				party.get(guildNum -1).setParty(true);
				
				System.out.println("====================================");
				System.out.print("[이름 : " + partyList[partyNum - 1].getName() + "]");
				System.out.print("에서 ");
				System.out.print("[이름 : " + party.get(guildNum - 1).getName() + "]");
				System.out.println("으로 교체 합니다. ");
				System.out.println("====================================");
				
				int n=0;
				for(int i=0; i<party.size(); i++) {
					if(party.get(i).isParty()) {
						partyList[n]=party.get(i);
						n++;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}

	
	
	public void removePartyMember() {
			printAllPartyMembers();
			System.out.println("삭제할 번호를 입력하세요 ");
			String input = Main.sc.next();
			
			try {
				int sel = Integer.parseInt(input);
				
				if(party.get(sel-1).isParty()) System.out.println("[메세지] 파티중인 멤버는 추방할 수 없습니다");
				else {
					System.out.print("[이름 : " + party.get(sel - 1).getName() + "]");
					System.out.println("[메세지] 파티원을 추방합니다");
					party.remove(sel-1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	public void addPartyMember() {
		printAllPartyMembers();
		System.out.println("[메세지] 모집할 용병 번호를 입려하세요");
		String input = Main.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(sel)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void buyUnit() {
		if (Character.getGold).money < 5000)
			
	
		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.money -= 5000;
	}
	
	public void printAllPartyMembers() {
		
		for (int i = 0; i < party.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + party.get(i).getName() + "]");
			System.out.print(" [레벨 : " + party.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + party.get(i).getHp() + " / " + party.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + party.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + party.get(i).getDef() + "]");
		}
	}
}
