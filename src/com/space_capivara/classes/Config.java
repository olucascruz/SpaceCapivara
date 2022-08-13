package com.space_capivara.classes;

public class Config {
	private final static int WIDTH_HUD = 300;
	private final static int WIDTH_SCREEN = 700 + WIDTH_HUD;
	private final static int HEIGHT_SCREEN = 700;
	private final static int SIZE_GRID = HEIGHT_SCREEN / 10;
	
	private String[] ImagesPlayer = {"shipUP.png","shipRight.png","shipDown.png","shipLeft.png"}; //Manter a ordem
	private String[] ImagesLaser = {"laserY.png","laserX.png"}; //Manter a ordem
	private String[] ImageEnemy = {"enemy.png", "explosion.png"};
	
	
	public String[] getImageEnemy() {
		return ImageEnemy;
	}

	public String[] getImagesLaser() {
		return ImagesLaser;
	}

	public String[] getImagesPlayer() {
		return ImagesPlayer;
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
