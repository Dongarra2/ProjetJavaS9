package main;

import entity.Entity;
import entity.LootCrate;
import entity.Player;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker (GamePanel gp) {
		this.gp = gp;
	}
	
	
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
		if(tileNum==6) {
			LootCrate.getLoot((Player) entity);
			gp.tileM.mapTileNum[tileX][tileY]=7;
		}		
			
		
	}

}
