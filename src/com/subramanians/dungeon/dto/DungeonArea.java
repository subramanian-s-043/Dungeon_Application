package com.subramanians.dungeon.dto;

public class DungeonArea {
	private int[][] dungeonArea;
	private int[] adventurePoint;
	private int[] goldPoint;
	private int[] monsterPoint;
	private int[] triggerPoint;
	private int[][] pitPos;
	
	public DungeonArea(int[][] area,int[] startPoint,int[] goldPoint,int[][] pitPos,int[] mons,int[] trigg) {
		this.dungeonArea=area;
		this.adventurePoint=startPoint;
		this.goldPoint=goldPoint;
		this.pitPos=pitPos;
		this.monsterPoint=mons;
		this.triggerPoint=trigg;
	}
	
	public int[][] getPitPos() {
		return pitPos;
	}

	public void setPitPos(int[][] pitPos) {
		this.pitPos = pitPos;
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
