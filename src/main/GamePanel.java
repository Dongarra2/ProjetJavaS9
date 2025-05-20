package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.GreenPotion;
import entity.LootCrate;
import entity.Player;
import entity.PurplePotion;
import entity.RedPotion;
import monsters.MonsterSetter;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	
	//Screen settings
	final int originalTileSize = 16; //16x16 tiles
	public final int scale = 6; 
	public final int tileSize = originalTileSize * scale;
	
	public final int maxScreenCol = 12;
	public final int maxScreenRow = 8;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	//world settings
	public final int maxWorldCol = 10;
	public final int maxWorldRow = 10;
	public final int worldWidth = tileSize*maxWorldCol;
	public final int worldHeight = tileSize*maxWorldRow;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public CollisionChecker cChecker = new CollisionChecker(this);
	Thread gameThread;
		
	public Player player = new Player(this,keyH);
	MonsterSetter mSetter = new MonsterSetter(this);
	public Entity monster[] = new Entity[20];
	ArrayList<Entity> entityList = new ArrayList<>();
	
	UI ui = new UI(this,player);
	
	RedPotion redPot = new RedPotion(this,player);
	GreenPotion greenPot = new GreenPotion(this,player);
	PurplePotion purplePot = new PurplePotion(this,player);
	LootCrate lootCrate = new LootCrate(this,player);
	
	
	int FPS=60;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	
	public void setupGame() {
		mSetter.setMonster();
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				
			}
		
		}
		
		
	}
	public void update() {
		
		player.update();
		
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		ui.draw(g2);
		
		entityList.add(player);
		
		for (int i = 0; i < monster.length; i++) {
			if (monster[i]!=null) {
				entityList.add(monster[i]);
			}
		}
		

		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).draw(g2);
		}
		
		for (int i = 0; i < entityList.size(); i++) {
			entityList.remove(i);
		}
		
		
		
		g2.dispose();
	}
	

}
