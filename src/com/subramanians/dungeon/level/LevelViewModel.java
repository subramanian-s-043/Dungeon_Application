package com.subramanians.dungeon.level;

import com.subramanians.dungeon.dto.DungeonArea;

public class LevelViewModel {
		LevelView levelView;
		DungeonArea area;
		
		public LevelViewModel(LevelView levelView) {
			this.levelView=levelView;
		}
		
		public void createDungeonArea(int row,int col,int adRow,int adCol,int golRow,int golCol) {
			area=new DungeonArea(new int[row][col],new int[]{adRow,adCol},new int[]{golRow,golCol});
		}

		public void findShorestPath() {
			int count=0;
			int[] adPos=area.getAdventurePoint();
			int[] golPos=area.getGoldPoint();
			levelView.showPath((Math.abs(adPos[0]-golPos[0])+Math.abs(adPos[1]-golPos[1])));
		}
}
