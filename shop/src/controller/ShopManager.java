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
		if(Shop.log == -1) System.out.println("[1] ȸ������\n[2] �α���\n[3] ȸ��Ż��\n[100] �����ڸ��");
		else System.out.println("[1] ����\n[2] ��ٱ��ϸ��\n[3] ����Ʈ ��ȸ\n[4] ����Ʈ ����\n[5] ����Ʈ ȯ��\n[6] �α׾ƿ�");
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
			System.out.println("[ī�װ�] ��ȣ�� �Է��ϼ���.[����.-1]");
			int caID = sc.nextInt();
			if (caID == -1)
				break;
			System.out.println("[������] ��ȣ�� �Է��ϼ���. ");
			im.printItem();
			int itID = sc.nextInt();
		}
	}
	
	void cartMenu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("[1] �� ��ٱ���\n[2] ��ٱ��� ����\n[3] ��ٱ��� ����\n[0] �ڷΰ���");
			int sel = sc.nextInt();
			if (sel == 1) cm.printCart(Shop.log);
			else if(sel == 2) cm.emptyCart(Shop.log);
			else if(sel == 3) cm.payCartList(Shop.log);
			else if (sel == 0) break;
		}
	}
	
	private void managerLogin() {
		System.out.print("Manager Code�� �Է��ϼ��� : ");
		String Code = sc.next();
		
		try {
			if(Code.equals(manager.getManagerCode())) {
				managerMenu();
			} else System.out.println("[�޼���] Manager Code �� ��ġ���� �ʽ��ϴ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1] �����۰���\n[2] ī�װ�����\n[3] ��������\n[0] �ڷΰ���");
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
			System.out.println("[1]��ü������\n[2] �������߰�\n[3] �����ۻ���\n[0] �ڷΰ���");
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
			System.out.println("[1] ��üī�װ�\n[2] ī�װ��߰�\n[3] ī�װ�����\n[0] �ڷΰ���");
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
			System.out.println("[1] ��ü����\n[2] �����߰�\n[3] ��������\n[0] �ڷΰ���");
			int sel = sc.nextInt();
			if (sel == 1) um.printUser();
			else if(sel == 2) um.managerJoinUser();
			else if(sel == 3) um.managerDelUser();
			else if (sel == 0) isRun = false;
		}
	}
	
	private void login() {
		System.out.print("[�޼���] Id�� �Է��ϼ��� : ");
		String id = sc.next();
		System.out.print("Pw�� �Է��ϼ��� : ");
		String pw = sc.next();
		
		for(int i=0; i<um.getUserSize(); i++) {
			if(id.equals(um.getUser(i).getId()) && pw.equals(um.getUser(i).getPw()))
				Shop.log = i;
		}
		if(Shop.log == -1) System.out.println("[�޼���] �α��ο� �����ϼ̽��ϴ�\nId/Pw Ȯ�� �� �ٽ� �α������ּ���");
		else if(Shop.log != -1) System.out.println("[�޽���] �α��� ����");
	}
	
	private void logout() {
		Shop.log = -1;
		System.out.println("[�޼���] �α׾ƿ� �Ͽ����ϴ�");
	}
}
