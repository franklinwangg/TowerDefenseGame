package Elements;

import java.awt.Graphics;

import Level.GameLevel;

public abstract class GridElement {
//	public abstract void move(Gridspace newSpace);
	public int x;
	public int y;
	
	public GridElement(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void paint(Graphics g, GameLevel m);
}