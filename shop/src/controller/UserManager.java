package controller;

import java.util.ArrayList;
import java.util.Random;


import data.User;

public class UserManager {

	private ArrayList<User> users = new ArrayList<>();
	
	public static UserManager instance = new UserManager();
	
	private PointManager pm = PointManager.instance;
	
	public void joinUser() {
		
		System.out.print("[가입] Id 를 입력하세요 : ");
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
			System.out.println("[메세지] " + temp.getId() + "님 가입을 축하합니다\n회원코드는 [ " + temp.getCode() + " ] 입니다");
			pm.addPoint(0); // 손
		} else System.out.println("이미 존재하는 Id 입니다");
	}

	// 회원코드 중복 체크
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
	
	//임시 아이디 확인
	public void check(int log) {
		System.out.println(this.users.get(log).getId());
	}
	
	// 회원탈퇴
	public void removeUser() {
		
		System.out.print("[메세지] Id를 입력하세요 : ");
		String id = ShopManager.sc.next();
		System.out.println("pw를 입력하세요 : ");
		String pw = ShopManager.sc.next();
		
		User delUser = null;
		for(User user : users) {
			if(id.equals(user.getId()) && pw.equals(user.getPw())) {
				delUser = user;
				System.out.println("[메세지] 회원탈퇴 되셨습니다\n이용해 주셔서 감사합니다");
			}
			else System.out.println("[메세지] 회원탈퇴에 실패하셨습니다\nId/Pw 확인 후 다시 시도해주세요");
		}
		this.users.remove(delUser);
	}
	
	// 회원 조회
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
		
		System.out.print("[가입] Id 를 입력하세요 : ");
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
			System.out.println("[메세지] " + temp.getId() + "님 계정이 생성되었습니다\n회원코드는 [ " + temp.getCode() + " ] 입니다");
			pm.addPoint(0); // 손
		} else System.out.println("이미 존재하는 Id 입니다");
	}

	public void managerDelUser() {
		System.out.print("[메세지] Id를 입력하세요 : ");
		String id = ShopManager.sc.next();
		User delUser = null;
		for(User user : users) {
			if(id.equals(user.getId())) {
				delUser = user;
				System.out.println("[메세지] User 삭제가 완료되었습니다");
			}
			else System.out.println("[메세지] 존재하지 않는 User Id 입니다");
		}
		this.users.remove(delUser);
	}
	
}
