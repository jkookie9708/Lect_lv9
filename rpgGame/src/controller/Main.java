package controller;

import java.util.Random;
import java.util.Scanner;


import models.SaveFile;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static Random rn = new Random();
	
	private CharacterManager cm = new CharacterManager();
	private SaveFile sf = new SaveFile();
	
	public void MainGame() {
		boolean isRun = true;
		while(isRun) {
			GameTitle();
			GameStartMenu();
			GameStartSelec();
			gameStart();
			
		}
	}
	
	private void GameTitle() {
		System.out.println("╊─━──━━───━──━━──╉");
		System.out.println("│ asdfasdfasdfas │");
		System.out.println("╉━──━━───━───━──━╉");
	}
	
	private void GameStartMenu() {
		System.out.println("1] 새로운모험 시작");
		System.out.println("2] 불러오기");
		System.out.println("3] 종   료");
	}

	private void GameStartSelec() {

		boolean isRun = true;
		
		while(isRun) {
			System.out.print("->");
			String input = sc.next();
			
			try {
				int sel = Integer.parseInt(input);
				
				if(sel == 1) cm.creativeCharacter();
				else if(sel == 2) {}
				else if(sel == 3) break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void gameStart() {
		boolean isRun = true;
		while(isRun) {
		System.out.println("============ village ============");
		System.out.println("[1.전투] [2.파티관리] [3.상점] [4.인벤토리]");
		System.out.println("[5.저장] [6.로드] [0.종료]");
		String input = sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(sel == 1) {}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {}
			else if(sel == 5) {
				try {
					sf.saveData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(sel == 6) {
				try {
					sf.loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(sel == 0) {
				System.out.println("게임을 종료 합니다");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main game = new Main();
		game.MainGame();
	}

}
