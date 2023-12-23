package com.subramanians.dungeon.level;

import java.util.ArrayList;
import java.util.List;
import com.subramanians.dungeon.dto.DungeonArea;

public class LevelViewModel {
		LevelView levelView;
		DungeonArea area;
		List<List<Integer>> monsterPaths=new ArrayList<List<Integer>>();
		List<List<Integer>> adventurePaths=new ArrayList<List<Integer>>();
		
		public LevelViewModel(LevelView levelView) {
			this.levelView=levelView;
		}
		
		public void createDungeonArea(int row,int col,int adRow,int adCol,int golRow,int golCol,int monRow,int monCol,int trigRow,int trigCol) {
			area=new DungeonArea(new int[row][col],new int[]{adRow,adCol},new int[]{golRow,golCol},new int[] {monRow,monCol},new int[] {trigRow,trigCol});
		}

		public void findShorestPath() {
			int[] adPos=area.getAdventurePoint();
			int[] golPos=area.getGoldPoint();
			int[] trigPos=area.getTriggerPoint();
			int[] monsPos=area.getMonsterPoint();
			int monsterSteps=Math.abs(monsPos[0]-golPos[0])+Math.abs(monsPos[1]-golPos[1]);
			int adventureSteps=Math.abs(adPos[0]-golPos[0])+Math.abs(adPos[1]-golPos[1]);
			int adToTrigger=Math.abs(adPos[0]-trigPos[0])+Math.abs(adPos[1]-trigPos[1]);
			int triggToGol=Math.abs(trigPos[0]-golPos[0])+Math.abs(trigPos[1]-golPos[1]);
			if((adventureSteps)<=(monsterSteps)) {
				levelView.showPath(adventureSteps);
				findMonsterPath(golPos,monsPos,monsterSteps+1);
				findAdventurePath(golPos,adPos,adventureSteps+1);
			}else {
				levelView.showPath(adToTrigger+triggToGol);
			}
		}

		private void printPath(int monsterSteps,int adventureSteps) {
			if(adventureSteps<monsterSteps) {
				levelView.printPath(adventurePaths);
			}else if(adventureSteps==monsterSteps) {
				levelView.printPath(adventurePaths);
			}
		}

		private void findAdventurePath(int[] golPos, int[] adPos,int steps) {
			int j=0;
			do {
				if(adPos[1]<golPos[1])
				{
					for(int i=adPos[1];i<=golPos[1];i++) {
						List<Integer> temp=new ArrayList<Integer>();
						temp.add(adPos[0]);
						temp.add(i);
						adventurePaths.add(temp);
						j++;
					}
					adPos[1]=golPos[1];
					if(golPos[0]<adPos[0])
					{
						for(int i=adPos[0]-1;i>=golPos[0];i--) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(i);
							temp.add(adPos[1]);
							adventurePaths.add(temp);
							j++;
						}
						adPos[0]=golPos[0];
					}else {
						for(int i=adPos[0]+1;i<=golPos[0];i++) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(adPos[0]);
							temp.add(i);
							adventurePaths.add(temp);
							j++;
						}
						adPos[0]=golPos[0];
					}
				}else {
					for(int i=adPos[1];i>=golPos[1];i--) {
						List<Integer> temp=new ArrayList<Integer>();
						temp.add(adPos[0]);
						temp.add(i);
						adventurePaths.add(temp);
						j++;
					}
					adPos[1]=golPos[1];
					if(golPos[0]<adPos[0])
					{
						for(int i=adPos[0]-1;i>=golPos[0];i--) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(i);
							temp.add(adPos[1]);
							adventurePaths.add(temp);
							j++;
						}
						adPos[0]=golPos[0];
					}else {
						for(int i=adPos[0]+1;i<=golPos[0];i++) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(adPos[0]);
							temp.add(i);
							adventurePaths.add(temp);
							j++;
						}
						adPos[0]=golPos[0];
					}
				}
			}while(j<steps);
		}

		private void findMonsterPath(int[] golPos,int[] monsPos,int steps) {
			int j=0;
			do {
				if(monsPos[1]<golPos[1])
				{
					for(int i=monsPos[1];i<=golPos[1];i++) {
						List<Integer> temp=new ArrayList<Integer>();
						temp.add(monsPos[0]);
						temp.add(i);
						monsterPaths.add(temp);
						j++;
					}
					monsPos[1]=golPos[1];
					if(golPos[0]<monsPos[0]) {
						for(int i=monsPos[0]-1;i>=golPos[0];i--) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(i);
							temp.add(monsPos[1]);
							monsterPaths.add(temp);
							j++;
						}
						monsPos[0]=golPos[0];
					}else {
						for(int i=monsPos[0]+1;i<=golPos[0];i++) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(i);
							temp.add(monsPos[1]);
							monsterPaths.add(temp);
							j++;
						}
						monsPos[0]=golPos[0];
					}
				}else {
					for(int i=monsPos[1];i>=golPos[1];i--) {
						List<Integer> temp=new ArrayList<Integer>();
						temp.add(monsPos[0]);
						temp.add(i);
						monsterPaths.add(temp);
						j++;
					}
					monsPos[1]=golPos[1];
					if(golPos[0]<monsPos[0]) {
						for(int i=monsPos[0]-1;i>=golPos[0];i--) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(i);
							temp.add(monsPos[1]);
							monsterPaths.add(temp);
							j++;
						}
						monsPos[0]=golPos[0];
					}else {
						for(int i=monsPos[0]+1;i<=golPos[0];i++) {
							List<Integer> temp=new ArrayList<Integer>();
							temp.add(i);
							temp.add(monsPos[1]);
							monsterPaths.add(temp);
							j++;
						}
						monsPos[0]=golPos[0];
					}
				}
			}while(j<steps);
		}

}
