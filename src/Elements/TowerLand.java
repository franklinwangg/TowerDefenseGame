package Elements;

import java.awt.Color;
import java.awt.Graphics;

import Level.GameLevel;
import Towers.Tower;

public class TowerLand extends GridElement{
	
	Tower tower;
	
	public TowerLand(int x, int y) {
		super(x, y);
	}
	
	public void buildTower(Tower tower) {
		this.tower = tower;
	}
	
	public void paint(Graphics g, GameLevel m) {
		g.setColor(Color.orange);
		g.fillRect(x * m.gridLength, y * m.gridLength, m.gridLength, 
				m.gridLength);
	}
}
