package Towers;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Elements.Enemy;
import Elements.GridElement;
import Level.GameLevel;
import Level.Gridspace;
import Projectile.Effect;
import Projectile.Projectile;

public class Tower extends GridElement{
	BufferedImage image;
	Projectile p;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public Tower(int x, int y, Projectile p) {
		super(x, y);
		this.p = p;
		
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

	
	
	public void shootProjectile() {
		System.out.println("shot");
		projectiles.add(new Projectile(p.x, p.y, p.speed, p.range, p.damage, p.e, 
				"south"));
	}
	
//	private String decideDirectionOfNextProjectile() {
//		
//	}
	
	public void removeProjectile() {
		
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public void moveProjectiles(GameLevel g) {
		for(Projectile p : projectiles) {
			p.move(g);
			if(p.detectCollision(g)) {
				projectiles.remove(p);
			}
		}
	}
	
	public void paint(Graphics g, GameLevel m) {
		g.setColor(Color.black);

		g.fillRect(x * m.gridLength, y * m.gridLength, m.gridLength, 
				m.gridLength);

	}
}