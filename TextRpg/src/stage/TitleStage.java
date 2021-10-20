package stage;

import controller.GameManager;

public class TitleStage extends BasicsStage {
	
	@Override
	public boolean update() {
		System.out.println("╊─━──━━───━──━━──╉");
		System.out.println("│    TEXT  RPG   │");
		System.out.println("╉━──━━───━───━──━╉");
		System.out.println("게임 시작을 하려면 [ Start ] 를 입력하세요");
		String start = BasicsStage.sc.next();
		if(start.equals("start")) {
			
			return false;
		}
		return false;
	}

	@Override
	public void init() {
		
	}

}
