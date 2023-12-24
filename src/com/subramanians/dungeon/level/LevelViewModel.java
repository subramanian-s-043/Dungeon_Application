package com.subramanians.dungeon.level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.subramanians.dungeon.dto.DungeonArea;

public class LevelViewModel {
		LevelView levelView;
		DungeonArea area;
		List<List<Integer>> monsterPaths=new ArrayList<List<Integer>>();
		List<List<Integer>> adventurePaths=new ArrayList<List<Integer>>();
		List<List<Integer>> visitedPaths=new ArrayList<List<Integer>>();
		
		public LevelViewModel(LevelView levelView) {
			this.levelView=levelView;
		}
		
		public void createDungeonArea(int row,int col,int adRow,int adCol,int golRow,int golCol,int[][] pitPos,int monsRow,int monsCol,int trigRow,int trigCol) {
			area=new DungeonArea(new int[row][col],new int[]{adRow,adCol},new int[]{golRow,golCol},pitPos,new int[] {monsRow,monsCol},new int[] {trigRow,trigCol});
		}

		public void findShorestPath() {
			int[] adPos=area.getAdventurePoint();
			int[] golPos=area.getGoldPoint();
			int[] trigPos=area.getTriggerPoint();
			int[] monsPos=area.getMonsterPoint();
			int monsterSteps=Math.abs(monsPos[0]-golPos[0])+Math.abs(monsPos[1]-golPos[1]);
//			int adventureSteps=Math.abs(adPos[0]-golPos[0])+Math.abs(adPos[1]-golPos[1]);
//			int adToTrigger=Math.abs(adPos[0]-trigPos[0])+Math.abs(adPos[1]-trigPos[1]);
			int triggToGol=Math.abs(trigPos[0]-golPos[0])+Math.abs(trigPos[1]-golPos[1]);
			int adventureSteps=findPath();
			levelView.showPath(adventureSteps+triggToGol);
//			if((adventureSteps)<=(monsterSteps)) {
//				levelView.showPath(adventureSteps);
//				findMonsterPath(golPos,monsPos,monsterSteps+1);
//				findAdventurePath(golPos,adPos,adventureSteps+1);
//			}else {
//				levelView.printMsg("No Possible Solution.");;
//			levelView.showPath(adToTrigger+triggToGol);
//			}
		}

		public boolean isVisited(List<Integer> point) {
			if(!visitedPaths.isEmpty())
			{
				for(List<Integer> t: visitedPaths) {
					if(t.equals(point)) {
						return true;
					}
				}	
			}
			return false;
		}
		
		public int findPath() {
			int[][] entireArea=area.getDungeonArea();
			int[][] pitPos=area.getPitPos();
			int[] adPos=area.getAdventurePoint();
			int[] trigPos=area.getTriggerPoint();
			int count=0;
			int i=0;
			for(i=0;i<pitPos.length;i++) {
				entireArea[pitPos[i][0]-1][pitPos[i][1]-1]=1;
			}
			if(adPos[1]<trigPos[1]) {  // if Adventure Column is Less than Gold/Trigger Column
				int initalRow=adPos[0];
				int initalCol=adPos[1];
				int path=0;
				for(i=adPos[1]-1;i<trigPos[1]-1;) {
					if(adPos[0]==initalRow && initalCol==adPos[1] && path!=0)
					{
						if((!isVisited(Arrays.asList(adPos[0]-1,i+1)))&&(!isVisited(Arrays.asList(adPos[0]-2,i)))
								&&(!isVisited(Arrays.asList(adPos[0],i)))) {
							levelView.printMsg("No Possible Ways.");
							break;
						}
					}
					if(entireArea[adPos[0]-1][i+1]!=1) {
						if(!isVisited(Arrays.asList(adPos[0]-1,i+1))) {
							count++;
							i++;
							List<Integer> temp=new ArrayList<>();
							temp.add(adPos[0]-1);
							temp.add(i);
							visitedPaths.add(temp);
						}
					}else if(entireArea[adPos[0]-2][i]!=1) {
						if(!isVisited(Arrays.asList(adPos[0]-2,i)))
						{
							adPos[0]--;
							count++;
							List<Integer> temp=new ArrayList<>();
							temp.add(adPos[0]-1);
							temp.add(i);
							visitedPaths.add(temp);
						}
					}else if(entireArea[adPos[0]][i]!=1) {
						if(!isVisited(Arrays.asList(adPos[0],i))) 
						{
							adPos[0]++;
							count++;
							List<Integer> temp=new ArrayList<>();
							temp.add(adPos[0]-1);
							temp.add(i);
							visitedPaths.add(temp);
						}
					}else {
						adPos[0]=initalRow;
						adPos[1]=initalCol;
						i=adPos[1]-1;
						path++;
					}
				}
				adPos[1]=i+1;
			}else { // Adventure Column is Greater than Gold/Trigger Column
				int initalRow=adPos[0];
				int initalCol=adPos[1];
				int path=0;
				for(i=adPos[1]-1;i>trigPos[1]-1;) {
					if(adPos[0]==initalRow && initalCol==adPos[1] && path!=0)
					{
						if((!isVisited(Arrays.asList(adPos[0]-1,i-1)))&&(!isVisited(Arrays.asList(adPos[0]-2,i)))
								&&(!isVisited(Arrays.asList(adPos[0],i)))) {
							levelView.printMsg("No Possible Ways.");
							break;
						}
					}
					if(entireArea[adPos[0]-1][i-1]!=1) {
						if(!isVisited(Arrays.asList(adPos[0]-1,i-1))) {
							count++;
							i++;
							List<Integer> temp=new ArrayList<>();
							temp.add(adPos[0]-1);
							temp.add(i-1);
							visitedPaths.add(temp);
						}
					}else if(entireArea[adPos[0]-2][i]!=1) {
						if(!isVisited(Arrays.asList(adPos[0]-2,i)))
						{
							adPos[0]--;
							count++;
							List<Integer> temp=new ArrayList<>();
							temp.add(adPos[0]-1);
							temp.add(i);
							visitedPaths.add(temp);
						}
					}else if(entireArea[adPos[0]][i]!=1) {
						if(!isVisited(Arrays.asList(adPos[0],i)))
						{
							adPos[0]++;
							count++;
							List<Integer> temp=new ArrayList<>();
							temp.add(adPos[0]-1);
							temp.add(i);
							visitedPaths.add(temp);
						}
					}else {
						adPos[0]=initalRow;
						adPos[1]=initalCol;
						i=adPos[1]-1;
						path++;
					}
				}
				adPos[1]=i;
			}
			if(adPos[0]<trigPos[0]) { // Adventure Row is Lesser than Gold/Trigger Row
				for(i=adPos[0]-1;i<trigPos[0]-1;) {
					if(entireArea[i][adPos[1]-1]!=1) {
						count++;
						i++;
					}else if(entireArea[i][adPos[1]-2]!=1) {
						count++;
					}
				}
				adPos[0]=i;
			}else { //Adventure Row is Greater than Gold/Trigger Row
				for(i=adPos[0]-1;i>trigPos[0]-1;) {
					if(entireArea[i-1][adPos[1]-1]!=1) {
						count++;
						i--;
					}else if(entireArea[i][adPos[1]]!=1){
						adPos[1]++;
						count++;
					}else if(entireArea[i-2][adPos[1]-2]!=1) {
						adPos[1]--;
						count++;
					}
				}
			}
			return count;
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
