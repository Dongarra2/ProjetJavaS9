package monsters;

import entity.Entity;
import main.GamePanel;

public class Monster_Skeleton extends Entity{

	
	public Monster_Skeleton(GamePanel gp) {
		
		super(gp);

		name = "Skeleton";
		maxHP=10;
		HP=maxHP;
		minDamage=1;
		maxDamage=4;	
		
		getImage();
		
	}
	
	public void getImage() {
		
		down1 = setupImage("/monsters/Skel1");
	}
	
	

	
	
	
}
