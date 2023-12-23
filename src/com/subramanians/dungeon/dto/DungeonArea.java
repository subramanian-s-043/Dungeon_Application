package com.subramanians.dungeon.dto;

public class DungeonArea {
	private int[][] dungeonArea;
	private int[] adventurePoint;
	private int[] goldPoint;
	private int[] monsterPoint;
	private int[] triggerPoint;

	public DungeonArea(int[][] area,int[] startPoint,int[] goldPoint,int[] monsterPoint,int[] triggerPoint) {
		this.dungeonArea=area;
		this.adventurePoint=startPoint;
		this.goldPoint=goldPoint;
		this.monsterPoint=monsterPoint;
		this.triggerPoint=triggerPoint;
	}
	
	public int[] getTriggerPoint() {
		return triggerPoint;
	}

	public void setTriggerPoint(int[] triggerPoint) {
		this.triggerPoint = triggerPoint;
	}
	public int[] getMonsterPoint() {
		return monsterPoint;
	}

	public void setMonsterPoint(int[] monsterPoint) {
		this.monsterPoint = monsterPoint;
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
