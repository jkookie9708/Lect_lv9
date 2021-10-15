package controller;

import java.util.ArrayList;

import models.Character;

public class CharacterManager {

	public static ArrayList<Character> characters = new ArrayList<>();
	public static CharacterManager instance = new CharacterManager();
	
	public void creativeCharacter() {
		
		int STR;
		int AGI;
		int INT;
		String gender = null;
		
		System.out.println("[메세지] 캐릭터를 생성해주세요");
		System.out.println("성별을 선택하세요");
		System.out.println("1] 남\n2] 여");
		System.out.print("->");
		int choi = Main.sc.nextInt();
		if(choi == 1) gender = "남자";
		else if(choi == 2) gender = "여자";
		System.out.print("이름을 입력하세요 : ");
		String name = Main.sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = Main.sc.nextInt();
		
		while(true) {
			STR = Main.rn.nextInt(5)+1;
			AGI = Main.rn.nextInt(5)+1;
			INT = Main.rn.nextInt(5)+1;
			
			if(STR + AGI + INT == 10) {
				System.out.println("[메세지] ability 부여");
				System.out.println("힘 : [" + STR + "]");
				System.out.println("민 : [" + AGI + "]");
				System.out.println("지 : [" + INT + "]");
				
				System.out.println("[메세지] 생성하시겠습니까?");
				System.out.println("1] 생성\n2] REROLL");
				System.out.print("->");
				String input = Main.sc.next();
				
				try {
					int sel = Integer.parseInt(input);
					if(sel == 1) break;
					else if(sel == 2) continue;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		Character temp = new Character(gender, name, age, STR, AGI, INT, (STR*5)+50, (INT*3)+50);
		this.characters.add(temp);
		System.out.println("[메세지] [Lv.1] " + temp.getName() +" 이/가 생성되었습니다");
		}
	
}
