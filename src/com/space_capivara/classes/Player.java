package com.space_capivara.classes;

public class Player extends ObjectMobile{

	private int life = 3;
	private String ImagePlayer = getConfig().getImagesPlayer()[0];
	private String direction = "UP";
	private int indexImage = 0;	
	private boolean shootExist = false;
	private Laser laser = new Laser();
	
	
	public Player()
	{
		start();
		setPosition_x(5);
		setPosition_y(9);
	}
	
	public boolean istShootExist() 
	{
		return shootExist;
	}

	public void setShootExist(boolean shootExist) 
	{
		this.shootExist = shootExist;
	}

	
	
	public void loseLife() 
	{
		try {
			this.setLife(this.getLife() - 1);
			System.out.println("explosion");
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getDirection()
	{
		return direction;
	}
	
	public void setDirection(String direction) 
	{
		this.direction = direction;
	}
	
	public String getImagePlayer() 
	{
		return ImagePlayer;
	}
	
	public void setImagePlayer(int num) 
	{
		
		indexImage = indexImage + (num);
		
		if(indexImage > 3) {
			indexImage = 0;
		}else if(indexImage < 0) {
			indexImage = 3;
		}
				
		ImagePlayer = getConfig().getImagesPlayer()[indexImage];
		
	}
	
	public void MoveForward() 
	{
		if(this.direction == "UP") 
		{	
			if(getPosition_y() != 0) {
				setPosition_y(getPosition_y() - 1);
			}
			
		} 
		else if(this.direction == "RIGHT") 
		{
			if(getPosition_x() != 9) {
				setPosition_x(getPosition_x() + 1);
			}
			
		} 
		else if(this.direction == "LEFT") 
		{
			if(getPosition_x() != 0) {
				setPosition_x(getPosition_x() - 1);
			}
			
		} 
		else if(this.direction == "DOWN") 
		{
			if(getPosition_y() != 9) {
				setPosition_y(getPosition_y() + 1);
			}
			
		}
		
	}
	
	public void MoveForback() 
	{
		if(this.direction == "UP") 
		{
			if(getPosition_y() != 9) {
				setPosition_y(getPosition_y() + 1);
			}
			
		} 
		else if(this.direction == "RIGHT") 
		{
			if(getPosition_x() != 0) {
			setPosition_x(getPosition_x() - 1);
			}
			
		} 
		else if(this.direction == "LEFT") 
		{	
			if(getPosition_x() != 9) {
				setPosition_x(getPosition_x() + 1);
			}
			
		} 
		else if(this.direction == "DOWN") 
		{
			if(getPosition_y() != 0) {
				setPosition_y(getPosition_y() - 1);
			}
			
		}
			
	}
	
	public void RotateRight() 
	{
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
	
	public void RotateLeft() 
	{
		setImagePlayer(-1);
		switch(indexImage) 
		{
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
		this.setShootExist(true);
		laser.Shoot(this.getDirection(), getPosition_x(),getPosition_y());
		this.setShootExist(false);
	}
	
	
	public void run(){}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public Laser getLaser() {
		return laser;
	}

}