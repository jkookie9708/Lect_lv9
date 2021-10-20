package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import stage.BasicsStage;
import stage.TitleStage;

public class GameManager {
	
	Random rn = new Random();
	static Scanner sc = new Scanner(System.in);
	
	private Map<String, BasicsStage> stageList = new HashMap<>();
	
	public GameManager(){
		stageList.put("Tittle", new TitleStage());
	}
	
	private boolean changeStage() {
		if()
	}
	
}
