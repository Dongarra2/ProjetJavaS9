package main;

import entity.Entity;
import entity.LootCrate;
import entity.Player;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker (GamePanel gp) {
		this.gp = gp;
	}
	
	
			///TILE COLLISION///
	
	
	public void checkTile(Entity entity) {
				
		int entityX = entity.worldX/gp.tileSize;
		int entityY = entity.worldY/gp.tileSize;
		
		int entityLeftCol = entityX -1;
		int entityRightCol = entityX +1;
		int entityTopRow = entityY -1;
		int entityBottomRow = entityY +1;
		
		int tileX = 0,tileY = 0;
		

		
		int tileNum = 0;
		
		
		
		switch(entity.direction) {
		case"up":
			tileX=entityX;tileY=entityTopRow;
			break;
		case"down":
			tileX=entityX;tileY=entityBottomRow;
			break;
		case"left":
			tileX=entityLeftCol;tileY=entityY;
			break;
		case"right":
			tileX=entityRightCol;tileY=entityY;
			break;
		}
		
		tileNum=gp.tileM.mapTileNum[tileX][tileY];
		if(gp.tileM.tile[tileNum].collision==true) {
			entity.collisionOn=true;
		}
		if(tileNum==8) {
			LootCrate.getLoot((Player) entity);
			gp.tileM.mapTileNum[tileX][tileY]=9;
		}		
			
		
	}
	
	
			///MONSTER COLLISION///
	
	public void checkMonster(Player player) {
		
		int playerX = player.worldX/gp.tileSize;
		int playerY = player.worldY/gp.tileSize;
		
		int playerLeftCol = playerX -1;
		int playerRightCol = playerX +1;
		int playerTopRow = playerY -1;
		int playerBottomRow = playerY +1;
		
		int tileX = 0,tileY = 0;
		
		
		switch(player.direction) {
		case"up":
			tileX=playerX;tileY=playerTopRow;
			break;
		case"down":
			tileX=playerX;tileY=playerBottomRow;
			break;
		case"left":
			tileX=playerLeftCol;tileY=playerY;
			break;
		case"right":
			tileX=playerRightCol;tileY=playerY;
			break;
		}
		
		
		
		
		for (int i = 0; i < gp.monster.length; i++) {
			if(gp.monster[i]!=null) {
							
				if (gp.monster[i].worldX/gp.tileSize == tileX && gp.monster[i].worldY/gp.tileSize == tileY) {
				
					//combat
					

					int playerDmg=player.calcDmg();
					int monsterDmg=gp.monster[i].calcDmg();
					
//					System.out.println("playerDmg = "+playerDmg+" monsterDmg = "+monsterDmg);
					
					gp.monster[i].HP-=(playerDmg-gp.monster[i].shield);
					
					
					if(gp.monster[i].HP <= 0) {
						player.score+=gp.monster[i].score;						
						player.getLoot(gp.monster[i].loot());
						gp.monster[i].hasTakenDamage=true;	
						gp.monster[i].damageTaken=(playerDmg-=gp.monster[i].shield);
						gp.monster[i].hasTakenDamage=true;
						gp.monster[i]=null;
						

					}
					else {
						player.collisionOn=true;
						player.HP-=(monsterDmg-=player.shield);
						player.damageTaken=(monsterDmg-=player.shield);
						player.hasTakenDamage=true;
						gp.monster[i].damageTaken=(playerDmg-=gp.monster[i].shield);
						gp.monster[i].hasTakenDamage=true;
					}
					break;
				}
			}
		}
		
		
	}

}
