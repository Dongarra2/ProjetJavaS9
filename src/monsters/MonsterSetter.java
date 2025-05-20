package monsters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;

public class MonsterSetter {
	
	GamePanel gp;
	
	
	public MonsterSetter(GamePanel gp) {
		this.gp=gp;


				
	}
	
	public void setSkel(int index, int X, int Y) {
		
		gp.monster[index] = new Monster_Skeleton(gp);
		gp.monster[index].worldX = gp.tileSize*X;
		gp.monster[index].worldY = gp.tileSize*Y;

				
	}
	
	public void loadMapMonsters(String filePath) {
		
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			int i =0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					
					switch(num) {
					case 0 : break;
					case 1 :
						setSkel(i, col, row);
						i++;
						break;
					case 2 :
						break;
					}
									
					col++;			
				}
				if (col == gp.maxWorldCol) {
					col=0;
					row++;
				}
			}
			br.close();
			
			}catch(Exception e) {
		}
		
		
	}
	
	

}

