package com.space_capivara.classes;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import java.util.Random;

public class Enemy {
	Config config = new Config();
	
	private String ImageEnemy = config.getImageEnemy();
	private int position_x = 5;
	private int position_y = 2;
	

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
		
		setPosition_x(random_local_x.nextInt(10)); 
		setPosition_y(random_local_y.nextInt(10));
		 
	}
	
	
	

public void Render(Graphics g) {
	
	g.drawImage(new ImageIcon(getClass().getResource(this.ImageEnemy)).getImage(),
			this.getPosition_x()*Config.getSIZE_GRID(),
			this.getPosition_y()*Config.getSIZE_GRID(), null);
	
}


}
