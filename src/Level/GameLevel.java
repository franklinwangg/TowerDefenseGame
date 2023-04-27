package Level;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

import Elements.Enemy;
import Elements.Goal;
import Elements.GridElement;
import Elements.TowerLand;
import Towers.Tower;

public class GameLevel extends JPanel implements Runnable{

	public Gridspace[][] map;
	public Goal goal;
	public int gridLength;
	public int gridSize;
	public int goalX, goalY;
	boolean gameStart;

	Thread thread;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();

	public GameLevel(int gridLength, int size, int goalX, int goalY) {
		thread = new Thread(this);
		thread.start();
		gridSize = size;
		this.gridLength = gridLength;
		this.goalX = goalX;
		this.goalY = goalY;
		gameStart = false;

		initializeMap(gridLength);
		goal = new Goal(goalX, goalY);
		map[goalX][goalY].setGridElement(goal);
		
		initializeTower(0, 0);

	}

	public void paint(Graphics g) {
		super.paint(g);
		if(gameStart == false) {
			gameStart = true;
		}
		
		goal.paint(g, this);

		for(int i = 0; i < map.length; i ++) {
			for(int j = 0; j < map[0].length; j ++) {
				if(map[i][j].getGridElement() != null) {
					map[i][j].getGridElement().paint(g, this);
				}
			}
		}
		
		drawLines(g);
	}
	private void drawLines(Graphics g) {
		g.setColor(Color.black);
		for(int i = 0; i < gridSize * gridLength; i += gridLength) { 
			g.drawLine(0, i, gridSize * gridLength, i);
		}
		for(int j = 0; j < gridSize * gridLength; j += gridLength) {
			g.drawLine(j, 0, j, gridSize * gridLength);
		}
	}

	public void addToMap(GridElement e) {
		map[e.x][e.y].setGridElement(e);
	}

	public void printMap() {
		for(int i = 0; i < map.length; i ++) {
			for(int j = 0; j < map[i].length; j ++) {
				if(map[i][j].contains() == null) {
					System.out.print("0 ");
				}
				else {
					System.out.print("b ");
				}
			}
			System.out.println();
		}
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				runEnemies();
				runTowers();
				repaint();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

	public void addEnemy(Enemy e) {
		enemies.add(e);
		map[e.x][e.y].setGridElement(e);
	}

	public void runTowers() {
		for(Tower t : towers) {
			t.shootProjectile();
		}
	}
	
	public void runEnemies() {

		for(Enemy e : enemies) {
			e.moveTowardsGoal(this);
		}
	}

	private void initializeTower(int x, int y) {
		map[x][y].setGridElement(new Tower(x, y, null));
	}
	
	public void initializeMap(int gridspace) {
		{
			int x = 0, y = 0;
			File randNums = new File("textfiles/randnums1");
			Scanner scanner;

			try {
				scanner = new Scanner(randNums);
				int currentRow = 0;
				boolean continuee = true;

				map = new Gridspace[gridSize][gridSize];
				for(int i = 0; i < gridSize; i ++) {
					for(int j = 0; j < gridSize; j ++) {
						map[i][j] = new Gridspace(gridSize, gridSize,
								gridLength, i, j);
					}
				}
				
				while(continuee) {
					
					String currentLine = scanner.nextLine();
					String[] numbers = currentLine.split(" ");
					
					for(int i = 0; i < numbers.length - 1; i ++) {
						int num = Integer.parseInt(numbers[i]);
						if(num == 1) {
							map[i][currentRow].setGridElement(null);
						}
						else if(num == 2) {
							map[i][currentRow].setGridElement(new TowerLand
									(i, currentRow));
						}
						else {
							Enemy e = new Enemy(i, currentRow);
							addEnemy(e);
						}
					}
					currentRow ++;
					
					if(!scanner.hasNextInt()) {
						continuee = false;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}