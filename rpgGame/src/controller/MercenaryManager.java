package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import models.Mercenary;

public class MercenaryManager {
	
	public static MercenaryManager instace = new MercenaryManager();
	public static ArrayList<Mercenary> mercenary = new ArrayList<>();
		
	private String rNick() {
		List<String> first = Arrays.asList("기분나쁜","기분좋은","신바람나는","상쾌한","짜릿한","그리운","자유로운","서운한","울적한","비참한","위축되는","긴장되는","두려운","당당한","배부른","수줍은","창피한","멋있는","열받은","심심한","잘생긴","이쁜","시끄러운");
		List<String> second = Arrays.asList("사자","코끼리","호랑이","곰","여우","늑대","너구리","침팬치","고릴라","참새","고슴도치","강아지","고양이","거북이","토끼","앵무새","하이에나","돼지","하마","원숭이","물소","얼룩말","치타", "악어","기린","수달","염소","다람쥐","판다");
		Collections.shuffle(first);
		Collections.shuffle(second);
		String nick = first.get(0) + second.get(0);
		return nick;
	}
	public void mercenary() {
		// SSS SS S A B C D 
		int r = Main.rn.nextInt(7)-3;
		int g = Main.rn.nextInt(2);
		String gender = null;
		if(g==0) gender = "남성";
		else if(g==1) gender = "여성";
		
		String name = rNick();
		
		int a = Main.rn.nextInt(30)+20;
		
		int STR;
		int AGI;
		int INT;
		while(true) {
			STR = Main.rn.nextInt(5)+1;
			AGI = Main.rn.nextInt(5)+1;
			INT = Main.rn.nextInt(5)+1;
			
			if(STR + AGI + INT == 10) break;
		}
		
		// Rank 
		if (r == 3) {
			String rank = "SSS";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT, STR*2.2, AGI*2.2, (STR * 3) + 45, (INT * 2) + 45, 22000);
			this.mercenary.add(temp);
		} else if (r == 2) {
			String rank = "SS";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT, STR*2, AGI*2, (STR * 3) + 40, (INT * 2) + 40, 18000);
			this.mercenary.add(temp);

		} else if (r == 1) {
			String rank = "S";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT, STR*1.8, AGI*1.8, (STR * 3) + 35, (INT * 2) + 35, 14000);
			this.mercenary.add(temp);

		} else if (r == 0) {
			String rank = "A";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT, STR*1.6, AGI*1.6, (STR * 3) + 30, (INT * 2) + 30, 11000);
			this.mercenary.add(temp);

		} else if (r == -1) {
			String rank = "B";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT, STR*1.4, AGI*1.4, (STR * 3) + 25, (INT * 2) + 25, 8000);
			this.mercenary.add(temp);

		} else if (r == -2) {
			String rank = "C";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT, STR*1.2, AGI*1.2, (STR * 3) + 20, (INT * 2) + 20, 5000);
			this.mercenary.add(temp);
		} else if (r == -3) {
			String rank = "D";

			Mercenary temp = new Mercenary(rank, gender, name, a, STR, AGI, INT,  STR, AGI, (STR * 3) + 15, (INT * 2) + 15, 3000);
			this.mercenary.add(temp);
		}
				
		
	}

	private void  creative() {
		
		while(mercenary.size() < Mercenary.TOTAL) {
			mercenary();
		}
		
	}
	
	public void printMercenary() {
		// 생성
		creative();
		
		for(int i=0; i<mercenary.size(); i++) {
			System.out.println("===============[" + i + "]===============");
			System.out.println("[랭크 : " + mercenary.get(i).getRank() + "]");
			System.out.print("[이름 : " + mercenary.get(i).getName() + "]");
			System.out.println(" [레벨 : 1 ]");
			System.out.print("[HP : " + mercenary.get(i).getHp() + " / " +   mercenary.get(i).getMaxHp() + "]");
			System.out.println(" [MP : " + mercenary.get(i).getMp() + " / " +  mercenary.get(i).getMaxMp() + "]");
			System.out.print("[힘 : " +  mercenary.get(i).getSTR() + "]");
			System.out.print(" [민 : " +  mercenary.get(i).getAGI() + "]");
			System.out.println(" [지 : " +  mercenary.get(i).getINT() + "]");
			System.out.print("[공격력 : " +  mercenary.get(i).getAtt() + "]");
			System.out.println(" [방어력 : " + mercenary.get(i).getDef() + "]");
			System.out.println("=================================");
						
		}
	}
	
}
