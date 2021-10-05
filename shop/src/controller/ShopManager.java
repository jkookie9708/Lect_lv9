package controller;

import java.util.Scanner;

import data.Manager;
import data.Shop;
import data.User;

public class ShopManager {

	static Scanner sc = new Scanner(System.in);
	
	public static ShopManager instance = new ShopManager();
	
	private UserManager um = UserManager.instance;
	private PointManager pm = PointManager.instance;
	private CartManager cm = CartManager.instance;
	private Manager manager = Manager.instance;
	private ItemManager im = ItemManager.instance;
	
	public void run() {
		boolean isRun = true;
		
		while(isRun) {
			System.out.println(Shop.instance.getBrand() + " Market");
			printMenu();
			selectMenu();
		}
	}
	
	private void printMenu() {
		if(Shop.log == -1) System.out.println("[1] 회원가입\n[2] 로그인\n[3] 회원탈퇴\n[100] 관리자모드");
		else System.out.println("[1] 쇼핑\n[2] 장바구니목록\n[3] 포인트 조회\n[4] 포인트 충전\n[5] 포인트 환불\n[6] 로그아웃");
	}
	
	private void selectMenu() {
		System.out.print("Menu : ");
		String input = sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			if(Shop.log == -1) {
				if(sel == 1) um.joinUser();
				else if(sel == 2) login();
				else if(sel == 3) um.removeUser();
				else if(sel == 100) managerLogin();
			}
			else {
					if(sel == 1) shopMenu();
					else if(sel == 2) cartMenu();
					else if(sel == 3) pm.printPoint(Shop.log);
					else if(sel == 4) pm.intputPoint(Shop.log);
					else if(sel == 5) pm.outPoint(Shop.log);
					else if(sel == 6) logout();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void shopMenu() {
		boolean isRun = true;
		while (isRun) {
			im.printCategory();
			System.out.println("[카테고리] 번호를 입력하세요.[종료.-1]");
			int caID = sc.nextInt();
			if (caID == -1)
				break;
			System.out.println("[아이템] 번호를 입력하세요. ");
			im.printItem();
			int itID = sc.nextInt();
		}
	}
	
	void cartMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("[1] 내 장바구니\n[2] 장바구니 비우기\n[3] 장바구니 결제\n[0] 뒤로가기");
			int sel = sc.nextInt();
			if (sel == 1) cm.printCart(Shop.log);
			else if(sel == 2) cm.emptyCart(Shop.log);
			else if(sel == 3) cm.payCartList(Shop.log);
			else if (sel == 0) break;
		}
	}
	
	private void managerLogin() {
		System.out.print("Manager Code를 입력하세요 : ");
		String Code = sc.next();
		
		try {
			if(Code.equals(manager.getManagerCode())) {
				managerMenu();
			} else System.out.println("[메세지] Manager Code 가 일치하지 않습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1] 아이템관리\n[2] 카테고리관리\n[3] 유저관리\n[0] 뒤로가기");
			int sel = sc.nextInt();
			if (sel == 1) itemMenu();
			else if (sel == 2) categoryMenu();
			else if (sel == 3) userMenu();
			else if (sel == 0) run = false;
			
		}
	}
	
	void itemMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("[1]전체아이템\n[2] 아이템추가\n[3] 아이템삭제\n[0] 뒤로가기");
			int sel = sc.nextInt();
			if (sel == 1) im.printItem();
			else if (sel == 2) im.addItem();
			else if(sel == 3) im.removeItem();
			else if (sel == 0) {
				isRun = false;
			}
		}
	}
	
	void categoryMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("[1] 전체카테고리\n[2] 카테고리추가\n[3] 카테고리삭제\n[0] 뒤로가기");
			int sel = sc.nextInt();
			
			if (sel == 1) im.printCategory();
			else if (sel == 2) im.addCategory();
			else if(sel == 3) im.removeCategory();
			else if (sel == 0) isRun = false;
		}
	}

	void userMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("[1] 전체유저\n[2] 유저추가\n[3] 유저삭제\n[0] 뒤로가기");
			int sel = sc.nextInt();
			if (sel == 1) um.printUser();
			else if(sel == 2) um.managerJoinUser();
			else if(sel == 3) um.managerDelUser();
			else if (sel == 0) isRun = false;
		}
	}
	
	private void login() {
		System.out.print("[메세지] Id를 입력하세요 : ");
		String id = sc.next();
		System.out.print("Pw를 입력하세요 : ");
		String pw = sc.next();
		
		for(int i=0; i<um.getUserSize(); i++) {
			if(id.equals(um.getUser(i).getId()) && pw.equals(um.getUser(i).getPw()))
				Shop.log = i;
		}
		if(Shop.log == -1) System.out.println("[메세지] 로그인에 실패하셨습니다\nId/Pw 확인 후 다시 로그인해주세요");
		else if(Shop.log != -1) System.out.println("[메시지] 로그인 성공");
	}
	
	private void logout() {
		Shop.log = -1;
		System.out.println("[메세지] 로그아웃 하였습니다");
	}
}
