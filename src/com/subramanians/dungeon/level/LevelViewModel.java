package com.subramanians.dungeon.level;

import com.subramanians.dungeon.dto.DungeonArea;

public class LevelViewModel {
		LevelView levelView;
		DungeonArea area;
		
		public LevelViewModel(LevelView levelView) {
			this.levelView=levelView;
		}
		
		public void createDungeonArea(int row,int col,int adRow,int adCol,int golRow,int golCol,int monRow,int monCol) {
			area=new DungeonArea(new int[row][col],new int[]{adRow,adCol},new int[]{golRow,golCol},new int[] {monRow,monCol});
		}

		public void findShorestPath() {
			int[] adPos=area.getAdventurePoint();
			int[] golPos=area.getGoldPoint();
			int[] monsPos=area.getMonsterPoint();
			if((Math.abs(adPos[0]-golPos[0])+Math.abs(adPos[1]-golPos[1]))<=(Math.abs(monsPos[0]-golPos[0])+Math.abs(monsPos[1]-golPos[1]))) {
				levelView.showPath((Math.abs(adPos[0]-golPos[0])+Math.abs(adPos[1]-golPos[1])));
			}else {
				levelView.printMsg("No Possible Solution");
			}
		}

}
