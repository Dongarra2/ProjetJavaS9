package entity;

import java.util.Random;
import main.GamePanel;

public class LootCrate extends Object{

	
	GamePanel gp;
	Player player;
	
	
	public LootCrate(GamePanel gp, Player player) {
		
		this.gp=gp;
		this.player=player;			
		
	}
	
	public static void getLoot(Player player) {
		
		Random random = new Random();
		int randInt = random.nextInt(10);
				
		if(randInt<=5) {
			RedPotion.getRedPotion(player);
		}
		else if(randInt<=7) {
			GreenPotion.getGreenPotion(player);
		}
		else {
			PurplePotion.getPurplePotion(player);
		}
		
	}
	
	
}
