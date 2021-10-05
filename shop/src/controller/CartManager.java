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
		} else System.out.println("[메세지] 비어있음");
	}
	
	public void emptyCart(int log) {
		if(cartList.size() > 0) {
			System.out.println("[1] 전체비우기\n[2] 항목비우기");
			int sel = ShopManager.sc.nextInt();
			
			if(sel == 1) cartList = new ArrayList<>();
			else if(sel == 2) {
				System.out.println(cartList.get(log));
				
			}
		} else System.out.println("[메세지] 비어있음");
	}
	
	public void payCartList(int log) {
	
		try {
			printCart(log);
			int total = 0;
			for(int i=0; i<cartList.size(); i++) {
				total += cartList.get(i).getItmPrice();
			}
			System.out.println("[결제] 총 금액 : " + total);
			System.out.println("[결제] 결제를 진행하시겠습니까 [1]Yes [2]No");
			int sel = ShopManager.sc.nextInt();
			if(sel==1) {
				if(pm.getPoint(log).getPoint() > total) {
					pm.getPoint(log).setPoint(pm.getPoint(log).getPoint()-total);
					System.out.println("[결제] 결제 완료\n현재 남아있는 Point는 [ " + pm.getPoint(log).getPoint() + "원 ] 입니다");
				} else System.out.println("[메세지] 충전된 Point가 부족합니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}