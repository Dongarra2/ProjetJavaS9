package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class RedPotion extends Entity{
	
	public static BufferedImage redPotion,redPotion2;
	Player player;
	
	
	public RedPotion(GamePanel gp, Player player) {
		
		super(gp);
		this.player=player;
		
		
		try {
			redPotion = ImageIO.read(getClass().getResourceAsStream("/UI/red_potion.png"));
			redPotion2 = ImageIO.read(getClass().getResourceAsStream("/UI/red_potion_grayed.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	
	}
	
	public static void getRedPotion(Player player) {
		player.redPotCount+=1;
	}
	
	public static void usePotion(Player player) {
		
		if(player.redPotCount>0 && player.HP<player.maxHP) {
		player.HP+=10;
		player.redPotCount--;
		}
		
	}
	

}
