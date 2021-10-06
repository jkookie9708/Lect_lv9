package controller;

import java.util.Scanner;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	
	public void MainGame() {
		boolean isRun = true;
		while(isRun) {
			GameTitle();
			GameStartMenu();
			GameStartSelec();
			
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
				
				if(sel == 1) {}
				else if(sel == 2) {}
				else if(sel == 3) break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main game = new Main();
		game.MainGame();
	}

}
