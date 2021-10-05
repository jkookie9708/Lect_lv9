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
		} else System.out.println("[�޼���] ������ �׸��� �������� �ʽ��ϴ�");
	}
	
	public void addItem() {
		
		System.out.print("[��ǰ �߰�] ��ǰ �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.print("[��ǰ �߰�]������ �Է��ϼ��� : ");
		int price = sc.nextInt();
		printCategory();
		if(category.size() > 0) {
			System.out.print("[��ǰ �߰�] ī�װ� ��ȣ�� �Է��ϼ��� : ");
			int sel = sc.nextInt();
			Item temp = new Item(name, price, category.get(sel));
			itemList.add(temp);
		}
	}
	
	public void removeItem() {
		System.out.print("[������ ����] ī�װ� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name)) {
				itemList.remove(i);
				System.out.println("[������ ����] ������ ������ �Ϸ�Ǿ����ϴ� ");
			}
		}
	}
	
	// category
	
	public void printCategory() {
		if(category.size() > 0) {
			for(int i=0; i < category.size(); i++) {
				System.out.println("[" + i + "]" + category.get(i));
			}
		} else System.out.println("[�޼���] ī�װ� �׸��� �������� �ʽ��ϴ�");
	}
	
	public void addCategory() {
	System.out.print("[ī�װ� �߰�] ī�װ� �̸��� �Է��ϼ��� : ");	
	String name = sc.next();
	
	category.add(name);
	}
	
	public void removeCategory() {
		System.out.print("[ī�װ� ����] ī�װ� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		
		for(int i=0; i<category.size(); i++) {
			if(category.get(i).equals(name)) {
				category.remove(i);	
				System.out.println("[ī�װ� ����] ī�װ� ������ �Ϸ�Ǿ����ϴ� ");
			}
		}
	}
	
}