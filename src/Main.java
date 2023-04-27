import javax.swing.JFrame;

import Elements.Enemy;
import Level.GameLevel;

public class Main extends JFrame {
	int width, length;
	
	public Main(int width, int length, int gridLength, int size, int goalX, int goalY) {
		
		this.width = width;
		this.length = length;
		
		GameLevel m = new GameLevel(gridLength,size,goalX,goalY);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		m.printMap();
		
		this.add(m);
		this.setSize(width, length);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {	
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		Main m = new Main(600, 600, 10, 60, 4, 4);
	}
}