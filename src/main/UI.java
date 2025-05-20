package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import entity.GreenPotion;
import entity.Player;
import entity.PurplePotion;
import entity.RedPotion;

public class UI {
	
	BufferedImage UIBack,shield,shield_gray;
	GamePanel gp;
	Player player;
	Font arial_20;
	Font arial_25;
	int potionTextPosY,potionPosY,equipmentPosY,equipmentTextPosY,itemHeight,itemWidth,potionAmountPosY;
	
	
	public UI(GamePanel gp,Player player) {
		
		this.gp=gp;
		this.player=player;
		arial_20=new Font("Arial", Font.PLAIN, 20/6*gp.scale);
		arial_25=new Font("Arial", Font.PLAIN, 25/6*gp.scale);
		potionPosY=816*gp.tileSize/(25*gp.scale);
		itemHeight = 3*gp.tileSize/2;
		itemWidth = gp.tileSize;
		potionTextPosY = 57*gp.tileSize/8;
		potionAmountPosY = 55*gp.tileSize/8;
		equipmentTextPosY = 79*gp.tileSize/16;
		equipmentPosY = 52*gp.tileSize/16;
		


		
		try {
			UIBack = ImageIO.read(getClass().getResourceAsStream("/UI/Inventory_back.png"));
			shield = ImageIO.read(getClass().getResourceAsStream("/UI/shield.png"));
			shield_gray = ImageIO.read(getClass().getResourceAsStream("/UI/shield_gray.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
//		//potion buttons
//		JButton bRedPot = new JButton();
//		bRedPot.setBounds(11*gp.tileSize/4, potionPosY, itemWidth, itemHeight);
//		bRedPot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				RedPotion.usePotion(player);
//			}
//		});
//		JButton bGreenPot = new JButton();
//		bGreenPot.setBounds(6*gp.tileSize/4, potionPosY, itemWidth, itemHeight);
//		bGreenPot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				GreenPotion.usePotion(player);
//			}
//		});
//		JButton bPurplePot = new JButton();
//		bPurplePot.setBounds(1*gp.tileSize/4, potionPosY, itemWidth, itemHeight);
//		bPurplePot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				PurplePotion.usePotion(player);
//			}
//		});
//		
//		
//		gp.add(bRedPot);
//		gp.add(bGreenPot);
//		gp.add(bPurplePot);
//		
		
		
		
	}
	
	
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(UIBack,0,0,4*gp.tileSize,gp.maxScreenRow*gp.tileSize,null);
		
		g2.setFont(arial_25);
		g2.setColor(Color.white);
		
		
		//////////CHARACTER//////////
		
		g2.drawString("HP : "+player.HP+"/"+player.maxHP, gp.tileSize/4, 9*gp.tileSize/8);

		g2.drawString("Damage : "+player.minDamage+" - "+player.maxDamage, gp.tileSize/4, 12*gp.tileSize/8);
		g2.drawString("Score : "+player.score, gp.tileSize/4, 15*gp.tileSize/8);
		
		

		
		//////////POTIONS////////
		
		g2.setFont(arial_20);
		g2.drawString("Potion1", 7*gp.tileSize/16, potionTextPosY);
		g2.drawString("Potion2", 27*gp.tileSize/16, potionTextPosY);
		g2.drawString("Potion3", 47*gp.tileSize/16, potionTextPosY);
		

		
		
		//potion sprites and amounts
		if(player.redPotCount>0) {
			g2.drawImage(RedPotion.redPotion,11*gp.tileSize/4,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("x"+player.redPotCount, 56*gp.tileSize/16, potionAmountPosY);
		}
		else {
			g2.drawImage(RedPotion.redPotion2,11*gp.tileSize/4,potionPosY,itemWidth,itemHeight,null);			
		}
		
		if(player.greenPotCount>0) {
			g2.drawImage(GreenPotion.greenPotion,6*gp.tileSize/4,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("x"+player.greenPotCount, 36*gp.tileSize/16, potionAmountPosY);
			}
		else {
			g2.drawImage(GreenPotion.greenPotion2,6*gp.tileSize/4,potionPosY,itemWidth,itemHeight,null);
			}
		
		if(player.purplePotCount>0) {
			g2.drawImage(PurplePotion.purplePotion,1*gp.tileSize/4,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("x"+player.purplePotCount, 16*gp.tileSize/16, potionAmountPosY);
		}
		else {
			g2.drawImage(PurplePotion.purplePotion2,1*gp.tileSize/4,potionPosY,itemWidth,itemHeight,null);
		}


		
		//////////EQUIPMENT////////
		
		g2.drawString("Weapon", 7*gp.tileSize/16, equipmentTextPosY);
		g2.drawString("Armor", 28*gp.tileSize/16, equipmentTextPosY);
		g2.drawString("Shield", 48*gp.tileSize/16, equipmentTextPosY);

		
		if(player.hasShield==true) {
			g2.drawImage(shield,11*gp.tileSize/4,equipmentPosY,itemWidth,itemHeight,null);
		}
		else {
			g2.drawImage(shield_gray,11*gp.tileSize/4,equipmentPosY,itemWidth,itemHeight,null);			
		}
		
	}
}
