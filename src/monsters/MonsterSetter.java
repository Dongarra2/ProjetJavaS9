package monsters;

import main.GamePanel;

public class MonsterSetter {
	
	GamePanel gp;
	
	
	public MonsterSetter(GamePanel gp) {
		this.gp=gp;
				
	}
	
	public void setMonster() {
		
		gp.monster[0] = new Monster_Skeleton(gp);
		gp.monster[0].worldX = gp.tileSize*8;
		gp.monster[0].worldY = gp.tileSize*4;
	}

}
