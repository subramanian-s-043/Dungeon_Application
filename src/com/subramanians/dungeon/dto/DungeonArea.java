package com.subramanians.dungeon.dto;

public class DungeonArea {
	private int[][] dungeonArea;
	private int[] adventurePoint;
	private int[] goldPoint;
	
	public DungeonArea(int[][] area,int[] startPoint,int[] goldPoint) {
		this.dungeonArea=area;
		this.adventurePoint=startPoint;
		this.goldPoint=goldPoint;
	}
	
	public int[][] getDungeonArea() {
		return dungeonArea;
	}
	public void setDungeonArea(int[][] dungeonArea) {
		this.dungeonArea = dungeonArea;
	}
	public int[] getAdventurePoint() {
		return adventurePoint;
	}
	public void setAdventurePoint(int[] adventurePoint) {
		this.adventurePoint = adventurePoint;
	}
	public int[] getGoldPoint() {
		return goldPoint;
	}
	public void setGoldPoint(int[] goldPoint) {
		this.goldPoint = goldPoint;
	}
	
	
}
