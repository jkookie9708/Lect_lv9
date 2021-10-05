package controller;

import java.util.ArrayList;
import java.util.Scanner;

import data.Cart;
import data.Item;

public class ItemManager {

	public static Scanner sc = new Scanner(System.in);
	
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<String> category = new ArrayList<String>();
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public void printItem() {
		if(itemList.size() > 0) {
			for(int i = 0; i<itemList.size(); i++) {
				System.out.println(itemList.get(i));
			}
		} else System.out.println("[메세지] 아이템 항목이 존재하지 않습니다");
	}
	
	public void addItem() {
		
		System.out.print("[상품 추가] 상품 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("[상품 추가]가격을 입력하세요 : ");
		int price = sc.nextInt();
		printCategory();
		if(category.size() > 0) {
			System.out.print("[상품 추가] 카테고리 번호를 입력하세요 : ");
			int sel = sc.nextInt();
			Item temp = new Item(name, price, category.get(sel));
			itemList.add(temp);
		}
	}
	
	public void removeItem() {
		System.out.print("[아이템 삭제] 카테고리 이름을 입력하세요 : ");
		String name = sc.next();
		
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name)) {
				itemList.remove(i);
				System.out.println("[아이템 삭제] 아이템 삭제가 완료되었습니다 ");
			}
		}
	}
	
	// category
	
	public void printCategory() {
		if(category.size() > 0) {
			for(int i=0; i < category.size(); i++) {
				System.out.println("[" + i + "]" + category.get(i));
			}
		} else System.out.println("[메세지] 카테고리 항목이 존재하지 않습니다");
	}
	
	public void addCategory() {
	System.out.print("[카테고리 추가] 카테고리 이름을 입력하세요 : ");	
	String name = sc.next();
	
	category.add(name);
	}
	
	public void removeCategory() {
		System.out.print("[카테고리 삭제] 카테고리 이름을 입력하세요 : ");
		String name = sc.next();
		
		for(int i=0; i<category.size(); i++) {
			if(category.get(i).equals(name)) {
				category.remove(i);	
				System.out.println("[카테고리 삭제] 카테고리 삭제가 완료되었습니다 ");
			}
		}
	}
	
}