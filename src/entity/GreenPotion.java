package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class GreenPotion extends Entity{
	
	public static BufferedImage greenPotion,greenPotion2;
	Player player;
	
	
	public GreenPotion(GamePanel gp, Player player) {
		
		super(gp);
		this.player=player;
		
		
		try {
			greenPotion = ImageIO.read(getClass().getResourceAsStream("/UI/green_potion.png"));
			greenPotion2 = ImageIO.read(getClass().getResourceAsStream("/UI/green_potion_grayed.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	
	}
	
	public static void getGreenPotion(Player player) {
		player.greenPotCount+=1;
	}
	
	public static void usePotion(Player player) {
		
		if(player.greenPotCount>0) {
		player.minDamage++;
		player.greenPotCount--;
		}
		
		
	}
	


}
