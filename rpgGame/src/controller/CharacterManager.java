package controller;

import java.util.ArrayList;

public class CharacterManager {

	private ArrayList<Character> characters = new ArrayList<>();
	
	public void selectCharacter() {
		System.out.println("캐릭터를 생성해주세요");
		System.out.println("1] 캐릭터를 생성한다");
		System.out.println("2] 랜덤캐릭터를 생성한다");
		System.out.print("->");
		String input = Main.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(sel == 1) {}
			else if(sel == 2 ) {}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	위에거에요
	
	public void creativeCharacter() {
		System.out.println("성별을 선택하세요");
		System.out.println("1] 남/n2] 여");
		System.out.print("->");
		int gender = Main.sc.nextInt();
		System.out.print("이름을 입력하세요 : ");
		String name = Main.sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = Main.sc.nextInt();
		
		Character 
		characters.add(null)
	}
}
