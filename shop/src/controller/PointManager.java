package controller;


import java.util.ArrayList;

import data.Point;
import data.User;

public class PointManager {

	private ArrayList<Point> points = new ArrayList<>();
	
	public static PointManager instance = new PointManager();
	
	
	public void intputPoint(int log) {
		System.out.print("[�޼���] ������ �������ʽ� 10%�� �߰������� �˴ϴ�\n������ �ݾ��� �Է��ϼ��� : ");
		String input = ShopManager.sc.next();
		
		try {
			int point = Integer.parseInt(input);
			
			double bonus = point*0.1;
			int balance = this.points.get(log).getPoint();
			balance += point + bonus;
			this.points.get(log).setPoint(balance);
			System.out.println("[�޼���] ������ �Ϸ�Ǿ����ϴ�");
			System.out.println("��� ���� Point [ " + this.points.get(log).getPoint() + " ]");
		} catch (Exception e) {
		}
	}
	
	public void outPoint(int log) {
		System.out.print("[�޼���] ȯ�ҽ� ȯ������Ʈ�� ������ 20%�� ���� �ݾ��� ȯ�ҵ˴ϴ�\nȯ���� �ݾ��� �Է��ϼ��� : ");
		String input = ShopManager.sc.next();
		
		try {
			int point = Integer.parseInt(input);
			
			double commission = point*0.2;
			while(true) {
				System.out.println("����ȯ�� �ݾ��� " + (point-commission) + "�� �Դϴ�\nȯ���� �����Ͻðڽ��ϱ� [1]Yes [2]No");
				int sel = ShopManager.sc.nextInt();
				if(sel == 1) {
					int balance = this.points.get(log).getPoint();
					if(point <= balance) {
						balance -= point;
						this.points.get(log).setPoint(balance);
						System.out.println("[�޼���] ȯ���� �Ϸ�Ǿ����ϴ�");
						System.out.println("��� ���� Point [ " + this.points.get(log).getPoint() + " ]");
					} else System.out.println("[�޼���] �����Ͻ� ����Ʈ�� �����մϴ�");
				} else if (sel == 2) {
					System.out.println("[�޼���] ȯ�� ������ ��ҵǾ����ϴ�");
					break;
				}
				else System.out.println("[�޼���] �߸� �Է� �ϼ̽��ϴ�");
			}
		} catch (Exception e) {
		}
	}
	
		public void printPoint(int log) {
			System.out.println("[ " + UserManager.instance.getUser(log).getId() + " ] ���� ��� ���� Point : " + points.get(log).getPoint());
		}

	public void addPoint(int log) {
		Point bonus = new Point();
		points.add(log, bonus);
	}
	
	// ��ȸ
	
	public Point getPoint(int log) {
		return this.points.get(log);
	}
}
