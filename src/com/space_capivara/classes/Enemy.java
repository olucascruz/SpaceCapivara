package com.space_capivara.classes;

import java.util.Random;

public class Enemy extends Thread {
	Config config = new Config();
	
	private int life = 3;
	private String ImageEnemy = config.getImageEnemy()[0];
	private int position_x = 5;
	private int position_y = 2;
	
	public Enemy() {
		start();
	}
	
	
	public void loseLife() {
		try {
			this.life--;
			System.out.println("explosion enemy");
			explosion();
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void explosion() {
		setImageEnemy(1);
	}
	
	public String getImageEnemy() {
		return ImageEnemy;
	}
	public void setImageEnemy(int n) {
		ImageEnemy = config.getImageEnemy()[n];
	}
	
	public int getPosition_x() {
		return position_x;
	}
	

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	
	
	
	public int getPosition_y() {
		return position_y;
	}
	
	
	
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
	public void MoveEnemy() {
		Random random_local_x = new Random();
		Random random_local_y = new Random();
		setImageEnemy(0);
		setPosition_x(random_local_x.nextInt(10)); 
		setPosition_y(random_local_y.nextInt(10));
		 
	}
	public void run(){
		try {
			while(true) {
				this.MoveEnemy();
				Thread.sleep(800);
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
