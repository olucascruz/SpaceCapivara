package com.space_capivara.classes;

public class Config {
	private final static int WIDTH_HUD = 200;
	private final static int WIDTH_SCREEN = 700 + WIDTH_HUD;
	private final static int HEIGHT_SCREEN = 700;
	private final static int SIZE_GRID = HEIGHT_SCREEN / 10;
	private int map_data[][] = new int[10][10];
	private String[] ImagesPlayer = {"shipUP.png","shipRight.png","shipDown.png","shipLeft.png"}; //Manter a ordem
	private String ImageEnemy = "enemy.png";
	
	
	public String getImageEnemy() {
		return ImageEnemy;
	}

	public String[] getImagesPlayer() {
		return ImagesPlayer;
	}

	public int[][] getMap_data() {
		return map_data;
	}
	
	public void setMap_data(int x, int y, int Object) {
		this.map_data[x][y] = Object;
	}
	
	public static int getSIZE_GRID() {
		return SIZE_GRID;
	}
	public static int getWIDTH_HUD() {
		return WIDTH_HUD;
	}
	
	public int getWIDTH_SCREEN() {
		return WIDTH_SCREEN;
	}
	public int getHEIGHT_SCREEN() {
		return HEIGHT_SCREEN;
	}
	
}
