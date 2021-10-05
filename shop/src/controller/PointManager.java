package controller;


import java.util.ArrayList;

import data.Point;
import data.User;

public class PointManager {

	private ArrayList<Point> points = new ArrayList<>();
	
	public static PointManager instance = new PointManager();
	
	
	public void intputPoint(int log) {
		System.out.print("[메세지] 충전시 충전보너스 10%가 추가충전이 됩니다\n충전할 금액을 입력하세요 : ");
		String input = ShopManager.sc.next();
		
		try {
			int point = Integer.parseInt(input);
			
			double bonus = point*0.1;
			int balance = this.points.get(log).getPoint();
			balance += point + bonus;
			this.points.get(log).setPoint(balance);
			System.out.println("[메세지] 충전이 완료되었습니다");
			System.out.println("사용 가능 Point [ " + this.points.get(log).getPoint() + " ]");
		} catch (Exception e) {
		}
	}
	
	public void outPoint(int log) {
		System.out.print("[메세지] 환불시 환불포인트의 수수료 20%를 제한 금액이 환불됩니다\n환불할 금액을 입력하세요 : ");
		String input = ShopManager.sc.next();
		
		try {
			int point = Integer.parseInt(input);
			
			double commission = point*0.2;
			while(true) {
				System.out.println("실제환불 금액은 " + (point-commission) + "원 입니다\n환불을 진행하시겠습니까 [1]Yes [2]No");
				int sel = ShopManager.sc.nextInt();
				if(sel == 1) {
					int balance = this.points.get(log).getPoint();
					if(point <= balance) {
						balance -= point;
						this.points.get(log).setPoint(balance);
						System.out.println("[메세지] 환불이 완료되었습니다");
						System.out.println("사용 가능 Point [ " + this.points.get(log).getPoint() + " ]");
					} else System.out.println("[메세지] 보유하신 포인트가 부족합니다");
				} else if (sel == 2) {
					System.out.println("[메세지] 환불 진행이 취소되었습니다");
					break;
				}
				else System.out.println("[메세지] 잘못 입력 하셨습니다");
			}
		} catch (Exception e) {
		}
	}
	
		public void printPoint(int log) {
			System.out.println("[ " + UserManager.instance.getUser(log).getId() + " ] 님의 사용 가능 Point : " + points.get(log).getPoint());
		}

	public void addPoint(int log) {
		Point bonus = new Point();
		points.add(log, bonus);
	}
	
	// 조회
	
	public Point getPoint(int log) {
		return this.points.get(log);
	}
}
