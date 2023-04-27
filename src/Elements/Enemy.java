package Elements;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Level.GameLevel;
import Level.Gridspace;

public class Enemy extends GridElement{
	String direction = "";
	BufferedImage image;

	public Enemy(int x, int y) {
		super(x, y);

		//		try {
		////			image = ImageIO.read(getClass().getResourceAsStream
		////					("files/barbarianpose1.png"));
		//			image = ImageIO.read(getClass().getResourceAsStream
		//					("files/test.jpg"));
		//
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
	}

	public void moveTowardsGoal(GameLevel m) {
		chooseDirection(m);
		move(m, nextGridspace(m));
	}

	public Gridspace nextGridspace(GameLevel m) {
		if(direction == "west") {
			return m.map[x][y-1];
		}
		else if(direction == "east") {
			return m.map[x][y+1];

		}
		else if(direction == "south") {
			return m.map[x+1][y];
		}
		else if(direction == "north") {
			return m.map[x-1][y];
		}
		else {
			return null;
		}
	}

	public void chooseDirection(GameLevel m) {

		if(m.goal.y > this.y) {
			direction = "east";
		}
		else if(m.goal.y < this.y) {
			direction = "west";
		}
		else {
			if(m.goal.x > this.x) {
				direction = "south";
			}
			else if(m.goal.x < this.x) {
				direction = "north";
			} 
			else {
				direction = "finished";
			}
		}
	}

	public void move(GameLevel m, Gridspace newSpace) {
		Gridspace currentGridspace = m.map[x][y];
		newSpace.setGridElement(this);
		currentGridspace.setGridElement(null);
		x = newSpace.getX();
		y = newSpace.getY();
	}

	public void paint(Graphics g, GameLevel m) {
		g.setColor(Color.yellow);
		//		g.drawImage(image, x * m.gridLength, y * m.gridLength, this);
		//		g.drawImage(image, 100, 100, 100,100,null);

		g.fillRect(x * m.gridLength, y * m.gridLength, m.gridLength, 
				m.gridLength);

	}
}