package com.space_capivara.classes;

public class Player extends ObjectMobile{

	
	private int life = 3;
	private String ImagePlayer = getConfig().getImagesPlayer()[0];
	private String ImageLaser = getConfig().getImagesLaser()[0];
	private int shoot_position_x = 0;
	private int shoot_position_y = 0;
	private String direction = "UP";
	private int indexImage = 0;	
	private boolean shootExist = false;
	
	
	

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
			this.life--;
			System.out.println("explosion");
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setImageLaser(int index) 
	{
		ImageLaser = getConfig().getImagesLaser()[index];
	}
	
	public String getImageLaser() 
	{
		return ImageLaser;
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
			setPosition_y(getPosition_y() - 1);
			
		} 
		else if(this.direction == "RIGHT") 
		{
			setPosition_x(getPosition_x() + 1);
			
		} 
		else if(this.direction == "LEFT") 
		{
			setPosition_x(getPosition_x() - 1);
			
		} 
		else if(this.direction == "DOWN") 
		{
			setPosition_y(getPosition_y() + 1);
			
		}
		
	}
	
	public void MoveForback() 
	{
		if(this.direction == "UP") 
		{
			setPosition_y(getPosition_y() + 1);
			
		} 
		else if(this.direction == "RIGHT") 
		{
			setPosition_x(getPosition_x() - 1);
			
		} 
		else if(this.direction == "LEFT") 
		{
			setPosition_x(getPosition_x() + 1);
			
		} 
		else if(this.direction == "DOWN") 
		{
			setPosition_y(getPosition_y() - 1);
			
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
		this.shoot_position_x = getPosition_x();
		this.shoot_position_y = getPosition_y();
		
		switch(this.direction) {
			case "UP":
				try {
					for(int i = 0; i < 3; i++)
					{
						this.setImageLaser(0);
						if(this.shoot_position_y == 0) 
						{
							break;
						}
						this.shoot_position_y = this.shoot_position_y - 1;
						sleep(200);
					}
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				break;
				
			case "RIGHT":
				try 
				{
					for(int i = 0; i < 3; i++) 
					{
						this.setImageLaser(1);
						
						if(this.shoot_position_x == 9) 
						{
							break;
						}
						this.shoot_position_x = this.shoot_position_x + 1;
						sleep(200);
					}
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				break;
				
			case "DOWN":
				try {
					for(int i = 0; i < 3; i++)
					{
						this.setImageLaser(0);
						if(this.shoot_position_y == 9)
						{
							break;
						}
						this.shoot_position_y = this.shoot_position_y + 1;
						sleep(200);
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				break;
				
			case "LEFT":
				try {
					for(int i = 0; i < 3; i++)
					{
						this.setImageLaser(1);
						if(this.shoot_position_x == 0) 
						{
							break;
						}
						this.shoot_position_x = this.shoot_position_x - 1;						
						sleep(200);
					}
					
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
		}
		this.setShootExist(false);
	}
	public int getShoot_position_x() {
		return shoot_position_x;
	}
	
	public int getShoot_position_y() {
		return shoot_position_y;
	}
	
	public void run(){}

}