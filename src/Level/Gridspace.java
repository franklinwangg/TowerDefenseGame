package Level;
import java.util.ArrayList;

import Elements.GridElement;

public class Gridspace {
	GridElement element;
	
	private int gridLength, x, y, mapSizeX, mapSizeY;
	
	public Gridspace(int mapSizeX, int mapSizeY, int gridLength, int x, int y) {
		this.gridLength = gridLength;
		this.mapSizeX = mapSizeX;
		this.mapSizeY = mapSizeY;

		this.x = x;
		this.y = y;
	}
	
	public GridElement contains() {
		return element;
	}
	
	public ArrayList<Gridspace> getSurroundings() {
		ArrayList<Gridspace> surroundings = new ArrayList<Gridspace>();
		for(int i = x - 1; i <= x + 1; i ++) {
			if(i < 0) {
				i ++;
			}
			else if(i > mapSizeX - 1) {
				continue; //quit the loop
			}
			for(int j = y - 1; j < j + 1; j ++) {
				if(j < 0) {
					j ++;
				}
				else if(j > mapSizeY - 1) {
					continue; //quit the loop
				}
				surroundings.add(new Gridspace
						(mapSizeX, mapSizeY, gridLength, x, y));
			}
		}
		return surroundings;
	}
	public void setGridElement(GridElement e) {
		element = e;
	}
	public GridElement getGridElement() {
		return element;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}