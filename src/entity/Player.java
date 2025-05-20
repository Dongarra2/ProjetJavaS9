package entity;

import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity{
	
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public boolean moving;
	public int moveCounter;
	public boolean hasGreenPot,hasPurplePot;
	public int redPotCount,greenPotCount,purplePotCount,purplePotDuration,greenPotDuration,purplePotRemaining,greenPotRemaining;



	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		this.keyH=keyH;
		
		screenX = gp.screenWidth/2 + 3*gp.tileSize/2;
		screenY = gp.screenHeight/2 - gp.tileSize/2;
		

		setDefaultValues();
		getPlayerImage();
	}
	
	
	
	public  void setDefaultValues() {
		worldX= gp.tileSize*1;
		worldY= gp.tileSize*1;
		speed= 4;
		direction = "down";
		moving = false;
		moveCounter = 0;
		
		redPotCount = 0;
		greenPotCount = 0;
		purplePotCount = 0;
		hasGreenPot = false;
		hasPurplePot = false;
		purplePotDuration = 2;
		greenPotDuration = 2;
		purplePotRemaining = 0;
		greenPotRemaining = 0;
		
		maxHP=50;
		HP=maxHP;
		minDamage=2;
		maxDamage=5;
	}
	
	public void getPlayerImage() {
		
		up1 = setupImage("/player/boy_up_1");
		up2 = setupImage("/player/boy_up_2");
		down1 = setupImage("/player/boy_down_1");
		down2 = setupImage("/player/boy_down_2");
		left1 = setupImage("/player/boy_left_1");
		left2 = setupImage("/player/boy_left_2");
		right1 = setupImage("/player/boy_right_1");
		right2 = setupImage("/player/boy_right_2");
		
		
		
//		try {
//			
//			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
//			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
//			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
//			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
//			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
//			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
//			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
//			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
//		
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	
	public void update() {
		
		
		if (moving == false) {			
			
			if(keyH.upPressed == true || keyH.downPressed == true ||
					keyH.leftPressed == true || keyH.rightPressed == true) {
				
				if(keyH.upPressed==true) {	
					direction="up";
					}
				else if(keyH.downPressed==true) {	
					direction="down";
					}
				else if(keyH.leftPressed==true) {	
					direction="left";
					}
				else if(keyH.rightPressed==true) {	
					direction="right";
					}
				
				moving=true;
				//check collision
				collisionOn = false;
				gp.cChecker.checkTile(this);
						
			
			}
		}
		
		if (moving == true && collisionOn==false && moveCounter<gp.tileSize) {
			//if collision off player can move
			
			switch(direction) {
			case "up": worldY -= speed;	break;
			case "down": worldY += speed; break;
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
			}
			
			moveCounter+=speed;
			
			spriteCounter++;
			if (spriteCounter>=15) {
				spriteNumber= !spriteNumber;
				spriteCounter = 0;
			}
		}
			
		else {
			moving=false;
			moveCounter=0;
			}
		
		
		
		//potions
		
		if(keyH.onePressed==true) {
			PurplePotion.usePotion(this);
			keyH.onePressed=false;
		}
		if(keyH.twoPressed==true) {
			GreenPotion.usePotion(this);
			keyH.twoPressed=false;
		}
		if(keyH.threePressed==true) {
			RedPotion.usePotion(this);
			keyH.threePressed=false;
		}
				
		
		if(HP>maxHP) {
			HP=maxHP;
		}
				
	}
	
	
	
//	public void draw(Graphics2D g2) {
//		
//		BufferedImage image = null;
//		
//		if (spriteNumber==true) {
//			
//			switch(direction) {
//			case "up":
//				image = up1;
//				break;
//			case "down":
//				image = down1;
//				break;
//			case "left":
//				image = left1;
//				break;
//			case "right":
//				image = right1;
//				break;
//			}
//			
//		}
//		else {
//			switch(direction) {
//			case "up":
//				image = up2;
//				break;
//			case "down":
//				image = down2;
//				break;
//			case "left":
//				image = left2;
//				break;
//			case "right":
//				image = right2;
//				break;
//			}
//		}
//		
//		
//		g2.drawImage(image, screenX, screenY, null);
//	}
//	
}