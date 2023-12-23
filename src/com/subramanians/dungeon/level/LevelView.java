package com.subramanians.dungeon.level;

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
		levelviewModel.createDungeonArea(rows,column,adventureRow,adventureColumn,goldRow,goldCol);
		levelviewModel.findShorestPath();
	}

	public void showPath(int minimumPath) {
		System.out.println("Minimum Number Of Steps: "+ minimumPath);		
	}
	
}
