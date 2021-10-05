package controller;

import java.util.ArrayList;

import data.Cart;

public class CartManager {

	public static CartManager instance = new CartManager();
	
	private ArrayList<Cart> cartList = new ArrayList<>();
	
	private PointManager pm = PointManager.instance;
	
	
	public void printCart(int log) {
		if(cartList.size() > 0) {
			System.out.println(cartList.get(log));
		} else System.out.println("[�޼���] �������");
	}
	
	public void emptyCart(int log) {
		if(cartList.size() > 0) {
			System.out.println("[1] ��ü����\n[2] �׸����");
			int sel = ShopManager.sc.nextInt();
			
			if(sel == 1) cartList = new ArrayList<>();
			else if(sel == 2) {
				System.out.println(cartList.get(log));
				
			}
		} else System.out.println("[�޼���] �������");
	}
	
	public void payCartList(int log) {
	
		try {
			printCart(log);
			int total = 0;
			for(int i=0; i<cartList.size(); i++) {
				total += cartList.get(i).getItmPrice();
			}
			System.out.println("[����] �� �ݾ� : " + total);
			System.out.println("[����] ������ �����Ͻðڽ��ϱ� [1]Yes [2]No");
			int sel = ShopManager.sc.nextInt();
			if(sel==1) {
				if(pm.getPoint(log).getPoint() > total) {
					pm.getPoint(log).setPoint(pm.getPoint(log).getPoint()-total);
					System.out.println("[����] ���� �Ϸ�\n���� �����ִ� Point�� [ " + pm.getPoint(log).getPoint() + "�� ] �Դϴ�");
				} else System.out.println("[�޼���] ������ Point�� �����մϴ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}