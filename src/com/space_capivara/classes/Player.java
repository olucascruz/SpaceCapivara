package com.space_capivara.classes;

public class Player extends Thread{
	Config config = new Config();
	
	
	private String ImagePlayer = config.getImagesPlayer()[0];
	private int position_x = 5;
	private int position_y = 9;
	private boolean can_shoot = true;
	private String ImageLaser = config.getImagesLaser()[0];
	private int shoot_position_x = 0;
	private int shoot_position_y = 0;
	private String direction = "UP";
	private int indexImage = 0;	
	
	
	public Player() {
		start();
	}
	
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public void setImageLaser(int index) {
		ImageLaser = config.getImagesLaser()[index];
	}
	public String getImageLaser() {
		return ImageLaser;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	public boolean isCan_shoot() {
		return can_shoot;
	}
	public void setCan_shoot(boolean can_shoot) {
		this.can_shoot = can_shoot;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public String getImagePlayer() {
		return ImagePlayer;
	}
	
	public void setImagePlayer(int num) {
		
		indexImage = indexImage + (num);
		
		if(indexImage > 3) {
			indexImage = 0;
		}else if(indexImage < 0) {
			indexImage = 3;
		}
				
		ImagePlayer = config.getImagesPlayer()[indexImage];
		
	}
	
	public void MoveForward() {
		if(this.direction == "UP") {
			this.position_y = this.position_y - 1;
		} else if(this.direction == "RIGHT") {
			this.position_x = this.position_x + 1;
		} else if(this.direction == "LEFT") {
			this.position_x = this.position_x - 1;
		} else if(this.direction == "DOWN") {
			this.position_y = this.position_y + 1;
		}
		
	}
	
	public void MoveForback() {
		if(this.direction == "UP") {
			this.position_y = this.position_y + 1;
		} else if(this.direction == "RIGHT") {
			this.position_x = this.position_x - 1;
		} else if(this.direction == "LEFT") {
			this.position_x = this.position_x + 1;
		} else if(this.direction == "DOWN") {
			this.position_y = this.position_y - 1;
		}
			
	}
	
	public void RotateRight() {
		setImagePlayer(1);
		switch(indexImage) {
			case 0:
				this.setDirection("UP");
				break;
			case 1:
				this.setDirection("RIGHT");
				break;
			case 2:
				this.setDirection("DOWN");
				break;
			case 3:
				this.setDirection("LEFT");
				break;
		}
	}
	public void RotateLeft() {
		setImagePlayer(-1);
		switch(indexImage) {
			case 0:
				this.setDirection("UP");
				break;
			case 1:
				this.setDirection("RIGHT");
				break;
			case 2:
				this.setDirection("DOWN");
				break;
			case 3:
				this.setDirection("LEFT");
				break;
		}
	}
	
	public void Shoot() {
		this.shoot_position_x = this.position_x;
		this.shoot_position_y = this.position_y;
		switch(this.direction) {
			case "UP":
				try {
					for(int i = 0; i < 3; i++) {
						this.setImageLaser(0);
						this.shoot_position_y = this.shoot_position_y - 1;
						sleep(200);
						} 
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "RIGHT":
				try {
				for(int i = 0; i < 3; i++) {
					this.setImageLaser(1);
					this.shoot_position_x = this.shoot_position_x + 1;
					sleep(200);
				}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "DOWN":
				try {
				for(int i = 0; i < 3; i++) {
					this.setImageLaser(0);
					this.shoot_position_y = this.shoot_position_y + 1;
					sleep(200);
				}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "LEFT":
				try {
				for(int i = 0; i < 3; i++) {
					this.setImageLaser(1);
					this.shoot_position_x = this.shoot_position_x - 1;
					sleep(200);
				}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
		}
	}
	public int getShoot_position_x() {
		return shoot_position_x;
	}
	public int getShoot_position_y() {
		return shoot_position_y;
	}
	public void run(){}

}