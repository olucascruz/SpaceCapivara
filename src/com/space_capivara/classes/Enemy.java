package com.space_capivara.classes;

import java.util.Random;

public class Enemy extends ObjectMobile {
	
	private int life = 100;
	private String ImageEnemy = getConfig().getImageEnemy()[0];
	
	
	public Enemy() {
		start();
		setPosition_x(5);
		setPosition_y(1);
	}
	
	
	public void loseLife() {
		try {
			this.setLife(this.getLife() - 10);
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
		ImageEnemy = getConfig().getImageEnemy()[n];
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


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}

}
