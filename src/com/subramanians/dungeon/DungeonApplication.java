package com.subramanians.dungeon;

import com.subramanians.dungeon.level.LevelView;

public class DungeonApplication {
	
	public static void main(String[] args) {
		DungeonApplication application=new DungeonApplication();
		application.start();
	}
	
	private void start() {
		LevelView app=new LevelView();
		app.getLevel1();
	}
}
