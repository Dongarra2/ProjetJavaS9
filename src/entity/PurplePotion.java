package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class PurplePotion extends Entity{
	
	public static BufferedImage purplePotion,purplePotion2;
	Player player;
	
	
	public PurplePotion(GamePanel gp, Player player) {
		
		super(gp);
		this.player=player;
		
		
		try {
			purplePotion = ImageIO.read(getClass().getResourceAsStream("/UI/purple_potion.png"));
			purplePotion2 = ImageIO.read(getClass().getResourceAsStream("/UI/purple_potion_grayed.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	
	}
	
	
	public static void getPurplePotion(Player player) {
		player.purplePotCount+=1;
	}
	
	
	public static void usePotion(Player player) {
		
		if(player.purplePotCount>0) {
		player.maxDamage++;
		player.purplePotCount--;
		}
		
	}


}
