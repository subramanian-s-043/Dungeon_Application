package com.subramanians.dungeon.level;

import java.util.List;
import java.util.Scanner;

public class LevelView {
	LevelViewModel levelviewModel;
	
	public LevelView() {
		levelviewModel=new LevelViewModel(this);
	}
	
	public void getLevel1() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of Rows and Column: ");
		int rows=scanner.nextInt();
		int column=scanner.nextInt();
		System.out.println("Enter the Adventure Point: ");
		int adventureRow=scanner.nextInt();
		int adventureColumn=scanner.nextInt();
		System.out.println("Enter the Gold Point: ");
		int goldRow=scanner.nextInt();
		int goldCol=scanner.nextInt();
		System.out.println("Enter the Monster Point: ");
		int monsRow=scanner.nextInt();
		int monsCol=scanner.nextInt();
		System.out.println("Enter the trigger Point: ");
		int triggRow=scanner.nextInt();
		int triggCol=scanner.nextInt();
		System.out.println("Enter Number of Pits: ");
		int pits=scanner.nextInt();
		int[][] pitPos=new int[pits][2];
		for(int i=0;i<pits;i++) {
			System.out.println("Enter the Pit Point: ");
			pitPos[i][0]=scanner.nextInt();
			pitPos[i][1]=scanner.nextInt();
		}
		levelviewModel.createDungeonArea(rows,column,adventureRow,adventureColumn,goldRow,goldCol,pitPos,monsRow,monsCol,triggRow,triggCol);
		levelviewModel.findShorestPath();
//		levelviewModel.findPath();
	}

	
	public void showPath(int minimumPath) {
		System.out.println("Minimum Number Of Steps: "+ minimumPath);		
	}

	public void printMsg(String string) {
		System.out.println(string);
		
	}

	public void printPath(List<List<Integer>> adventurePaths) {
		for(List<Integer> temp: adventurePaths) {
			System.out.print("["+temp.get(0)+","+temp.get(1)+"]"+"->");
		}
		
	}
	
}
