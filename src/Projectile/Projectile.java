package Projectile;

import java.util.ArrayList;

import Elements.Enemy;
import Elements.GridElement;
import Level.GameLevel;
import Level.Gridspace;

public class Projectile {
	public int x, y, speed, range, damage;
	public Effect e;

	public String direction = "";

	
	public Projectile(int x, int y, int speed, int range, int damage, Effect e, 
			String direction) {
		this.x = x;
		this.y = y;
		
		this.speed = speed;
		this.range = range;
		this.damage = damage;
		this.direction = direction;
		
		this.e = e;
	}

	public void move(GameLevel m) {
		this.x = nextGridspace(m).getX();
		this.y = nextGridspace(m).getY();
	}
	
	public Gridspace nextGridspace(GameLevel m) {
		if(direction == "northeast") {
			return m.map[x][y-1];
		}
		else if(direction == "northwest") {
			return m.map[x][y+1];
		}	
		else if(direction == "southeast") {
			return m.map[x][y+1];
		}
		else if(direction == "southwest") {
			return m.map[x][y+1];
		}
		else if(direction == "north") {
			return m.map[x][y+1];
		}
		else if(direction == "south") {
			return m.map[x+1][y];
		}
		else if(direction == "west") {
			return m.map[x-1][y];
		}
		else if(direction == "east") {
			return m.map[x-1][y];
		}
		else {
			return null;
		}
	}
	
	public boolean detectCollision(GameLevel m) {
		return (m.map[x][y].contains() == null);
	}
	
	
}
