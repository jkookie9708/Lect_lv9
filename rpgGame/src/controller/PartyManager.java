package controller;

import java.util.ArrayList;

import models.Mercenary;
import models.PartyMember;

public class PartyManager {

	public static PartyManager instance = new PartyManager();
	private CharacterManager cm = new CharacterManager();
	private MercenaryManager mm = new MercenaryManager();
	public static ArrayList<PartyMember> party = new ArrayList<>();
	private PartyMember[] partyList;
	private final int PARTY_SIZE = 4;

	public void PartyMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("=============== [파티 관리] ================");
			System.out.println("[1.용병 모집] [2.창고] [3.가입중인사람]\n[4.파티원교체] [5.파티추방] [0.뒤로가기]");
			String input = Main.sc.next();

			try {
				int sel = Integer.parseInt(input);

				if (sel == 1)
					addPartyMember();
				else if (sel == 2)
					printAllPartyMembers();
				else if (sel == 3)
					printPartyMembers();
				else if (sel == 4)
					switchPartyMember();
				else if (sel == 5)
					removePartyMember();
				else if (sel == 0)
					break;
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void printPartyMembers() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < party.size(); i++) {
			if(party.get(i).isParty()) {
				System.out.println("┌───────────────[Status]───────────────┐");
				System.out.println("│ [랭크 : " + party.get(i).getRank() + "] │");
				System.out.print("│ [ 이름 : " + party.get(i).getName() + "]");
				System.out.println("[레벨 : " + party.get(i).getLevel() + "] │");
				System.out.print("│ [HP : " + party.get(i).getHp() + " / " +   party.get(i).getMaxHp() + "]");
				System.out.println(" [MP : " + party.get(i).getMp() + " / " +  party.get(i).getMaxMp() + "] │");
				System.out.print("│ [힘 : " +  party.get(i).getSTR() + "]");
				System.out.print(" [민 : " +  party.get(i).getAGI() + "]");
				System.out.println(" [지 : " +  party.get(i).getINT() + "] │");
				System.out.print("[│ 공격력 : " +  party.get(i).getAtt() + "]");
				System.out.println(" [방어력 : " + party.get(i).getDef() + "] │");
				System.out.println("└─────────────────────────────────────┘");
			}
		}
	}
	
	public void printAllPartyMembers() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < party.size(); i++) {
				System.out.println("┌───────────────[Status]───────────────┐");
				System.out.println("│ [랭크 : " + party.get(i).getRank() + "] │");
				System.out.print("│ [ 이름 : " + party.get(i).getName() + "]");
				System.out.println("[레벨 : " + party.get(i).getLevel() + "] │");
				System.out.print("│ [HP : " + party.get(i).getHp() + " / " +   party.get(i).getMaxHp() + "]");
				System.out.println(" [MP : " + party.get(i).getMp() + " / " +  party.get(i).getMaxMp() + "] │");
				System.out.print("│ [힘 : " +  party.get(i).getSTR() + "]");
				System.out.print(" [민 : " +  party.get(i).getAGI() + "]");
				System.out.println(" [지 : " +  party.get(i).getINT() + "] │");
				System.out.print("[│ 공격력 : " +  party.get(i).getAtt() + "]");
				System.out.println(" [방어력 : " + party.get(i).getDef() + "] │");
				System.out.println("└─────────────────────────────────────┘");
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

			partyList[partyNum - 1].setParty(false);
			party.get(guildNum - 1).setParty(true);

			System.out.println("====================================");
			System.out.print("[이름 : " + partyList[partyNum - 1].getName() + "]");
			System.out.print("에서 ");
			System.out.print("[이름 : " + party.get(guildNum - 1).getName() + "]");
			System.out.println("으로 교체 합니다. ");
			System.out.println("====================================");

			int n = 0;
			for (int i = 0; i < party.size(); i++) {
				if (party.get(i).isParty()) {
					partyList[n] = party.get(i);
					n++;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removePartyMember() {
		printAllPartyMembers();
		System.out.println("삭제할 번호를 입력하세요 ");
		String input = Main.sc.next();

		try {
			int sel = Integer.parseInt(input);

			if (party.get(sel - 1).isParty())
				System.out.println("[메세지] 파티중인 멤버는 추방할 수 없습니다");
			else {
				System.out.print("[이름 : " + party.get(sel - 1).getName() + "]");
				System.out.println("[메세지] 파티원을 추방합니다");
				party.remove(sel - 1);
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPartyMember() {
		mm.printMercenary();
		System.out.println("[메세지] 모집할 용병 번호를 입려하세요");
		System.out.println("                      [지불 금액]");
		System.out.println("[SSS : 22000 Gold] [SS : 18000 Gold] [S : 14000 Gold]\n[A : 11000 Gold] [B : 8000 Gold] [C : 5000 Gold] [D : 3000 Gold]");
		System.out.print("->");
		String input = Main.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			System.out.println(MercenaryManager.mercenary.get(sel).getName());
			if (MercenaryManager.mercenary.get(sel).getPrice() <= CharacterManager.characters.get(0).getGold()) {
				PartyMember temp = new PartyMember(MercenaryManager.mercenary.get(sel).getRank(),
						MercenaryManager.mercenary.get(sel).getGender(), MercenaryManager.mercenary.get(sel).getName(),
						MercenaryManager.mercenary.get(sel).getAge(), MercenaryManager.mercenary.get(sel).getSTR(),
						MercenaryManager.mercenary.get(sel).getAGI(), MercenaryManager.mercenary.get(sel).getINT(),
						MercenaryManager.mercenary.get(sel).getAtt(), MercenaryManager.mercenary.get(sel).getDef(),
						MercenaryManager.mercenary.get(sel).getMaxHp(), MercenaryManager.mercenary.get(sel).getMaxMp());
				party.add(temp);
			} else
				System.out.println("[메세지] 보유하신 Gold가 부족합니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
