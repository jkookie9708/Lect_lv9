package snake_gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

class SnakePanel extends MyUtil {
	/*
	 * 1. 맵만들기
	 * 2. JButton 만들기
	 * 3. Snake 이동
	 * 4. Reset 버튼 만들기
	 * 5. 몸통에 머리다으면 Game Over
	 * 6. 아이템 먹으면 몸통 길이 길어지게하기
	 */
	
	private final int UP = 38;
	private final int DOWN = 40;
	private final int LEFT = 37;
	private final int RIGHT = 39;
	
	private Rect[][] map;
	
	private int size;
	private Rect[] snake;
	
	private boolean play;
	
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	private JButton reset;
	
	private String dir[] = {"↑", "↓", "←", "→"};
	
	public SnakePanel() {
		setLayout(null);
		setBounds(0, 0, 1000, 800);
		
		setGame();
		
		setVisible(true);
	}

	private void setGame() {
		
		// Reset 버튼
		
		this.reset = new JButton();
		
		this.reset.setBounds(1000-200, 700-200, 100, 50);
		this.reset.setFont(new Font("", Font.BOLD, 15));
		this.setBackground(Color.lightGray);
		
		this.addMouseListener(this);
		
		// Map 
		
		map = new Rect[20][20];
		
		int x = 25;
		int y = 25;
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; i++) {
				map[i][j] = new Rect(x, y, 25, 25);
				x+=25;
			}
			x=25;
			y+=25;
		}
		
		// Button
		
		//↑
		this.up = new JButton();
		this.up.setBounds(1000-150, 700-150, 50, 50);
		this.up.setFont(new Font("", Font.BOLD, 15));
		this.up.setBackground(Color.black);
		this.up.setText(dir[0]);
		this.up.addKeyListener(this);
		
		// ↓
		this.down = new JButton();
		this.down.setBounds(1000-150, 700-150, 50, 50);
		this.down.setFont(new Font("", Font.BOLD, 15));
		this.down.setBackground(Color.black);
		this.up.setText(dir[1]);
		this.down.addKeyListener(this);
		
		// ←
		this.left = new JButton();
		this.left.setBounds(1000-150, 700-150, 50, 50);
		this.left.setFont(new Font("", Font.BOLD, 15));
		this.left.setBackground(Color.black);
		this.up.setText(dir[2]);
		this.left.addKeyListener(this);
		
		// →
		this.right = new JButton();
		this.right.setBounds(1000-150, 700-150, 50, 50);
		this.right.setFont(new Font("", Font.BOLD, 15));
		this.right.setBackground(Color.black);
		this.up.setText(dir[3]);
		this.right.addKeyListener(this);
		
	}
}

public class Game extends JFrame {

	private SnakePanel panel = new SnakePanel();
	
	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
		revalidate();
	}
}
