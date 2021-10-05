package controller;

import java.util.ArrayList;
import java.util.Random;


import data.User;

public class UserManager {

	private ArrayList<User> users = new ArrayList<>();
	
	public static UserManager instance = new UserManager();
	
	private PointManager pm = PointManager.instance;
	
	public void joinUser() {
		
		System.out.print("[����] Id �� �Է��ϼ��� : ");
		String id = ShopManager.sc.next();
		
		boolean check = false;
		
		for (User user : users) {
			if(id.equals(user.getId())) check = true;
		}
		
		if(!check) {
			System.out.print("pw : ");
			String pw = ShopManager.sc.next();
			
			User temp = new User(randomCode(), id, pw);
			this.users.add(temp);
			System.out.println("[�޼���] " + temp.getId() + "�� ������ �����մϴ�\nȸ���ڵ�� [ " + temp.getCode() + " ] �Դϴ�");
			pm.addPoint(0); // ��
		} else System.out.println("�̹� �����ϴ� Id �Դϴ�");
	}

	// ȸ���ڵ� �ߺ� üũ
	private int randomCode() {
		Random rn = new Random();
		
		while(true) {
			int rCode = rn.nextInt(8999) + 1000;
			
			boolean check = false;
			for(User user : users) {
				if(rCode == user.getCode()) check = true;
			}
			if(!check) return rCode;
		}
	}
	
	//�ӽ� ���̵� Ȯ��
	public void check(int log) {
		System.out.println(this.users.get(log).getId());
	}
	
	// ȸ��Ż��
	public void removeUser() {
		
		System.out.print("[�޼���] Id�� �Է��ϼ��� : ");
		String id = ShopManager.sc.next();
		System.out.println("pw�� �Է��ϼ��� : ");
		String pw = ShopManager.sc.next();
		
		User delUser = null;
		for(User user : users) {
			if(id.equals(user.getId()) && pw.equals(user.getPw())) {
				delUser = user;
				System.out.println("[�޼���] ȸ��Ż�� �Ǽ̽��ϴ�\n�̿��� �ּż� �����մϴ�");
			}
			else System.out.println("[�޼���] ȸ��Ż�� �����ϼ̽��ϴ�\nId/Pw Ȯ�� �� �ٽ� �õ����ּ���");
		}
		this.users.remove(delUser);
	}
	
	// ȸ�� ��ȸ
	public User getUser(int log) {
		return this.users.get(log);
	}
	
	public int getUserSize() {
		return this.users.size();
	}
	
	public int getUserPointSize(int log) {
		return this.users.get(log).getPointsSize();
	}
	
	public void printUser() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}
	
	public void managerJoinUser() {
		
		System.out.print("[����] Id �� �Է��ϼ��� : ");
		String id = ShopManager.sc.next();
		
		boolean check = false;
		
		for (User user : users) {
			if(id.equals(user.getId())) check = true;
		}
		
		if(!check) {
			System.out.print("pw : ");
			String pw = ShopManager.sc.next();
			
			User temp = new User(randomCode(), id, pw);
			this.users.add(temp);
			System.out.println("[�޼���] " + temp.getId() + "�� ������ �����Ǿ����ϴ�\nȸ���ڵ�� [ " + temp.getCode() + " ] �Դϴ�");
			pm.addPoint(0); // ��
		} else System.out.println("�̹� �����ϴ� Id �Դϴ�");
	}

	public void managerDelUser() {
		System.out.print("[�޼���] Id�� �Է��ϼ��� : ");
		String id = ShopManager.sc.next();
		User delUser = null;
		for(User user : users) {
			if(id.equals(user.getId())) {
				delUser = user;
				System.out.println("[�޼���] User ������ �Ϸ�Ǿ����ϴ�");
			}
			else System.out.println("[�޼���] �������� �ʴ� User Id �Դϴ�");
		}
		this.users.remove(delUser);
	}
	
}
