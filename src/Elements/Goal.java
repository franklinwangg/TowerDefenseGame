package Elements;

import java.awt.Color;
import java.awt.Graphics;

import Level.GameLevel;

public class Goal extends GridElement{

	public Goal(int x, int y) {
		super(x, y);
	}
	
	public void paint(Graphics g, GameLevel m) {
		g.setColor(Color.red);
		g.fillRect(m.goalX * m.gridLength, m.goalY * m.gridLength, 
				m.gridLength, m.gridLength);
	}
}