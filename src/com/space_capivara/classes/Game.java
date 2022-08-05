package com.space_capivara.classes;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Config config = new Config();
	Player player = new Player();
	
	public Game(){
		this.setPreferredSize(new Dimension(config.getWIDTH_SCREEN(), config.getHEIGHT_SCREEN()));
		this.addKeyListener(this);
	}
	
	public void tick() {
		if(player.getPosition_y() > 9) {
			player.setPosition_y(8); 
		}
		else if(player.getPosition_y() < 0) {
			player.setPosition_y(1); 
		}
		if(player.getPosition_x() > 9) {
			player.setPosition_x(8); 
		}
		else if(player.getPosition_x() < 0) {
			player.setPosition_x(1); 
		}
	}
	
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//BackGround
		g.setColor(Color.black);
		g.fillRect(0, 0, config.getWIDTH_SCREEN(), config.getHEIGHT_SCREEN());
		
		//HUD
		g.setColor(Color.red);
		g.fillRect(config.getWIDTH_SCREEN() - Config.getWIDTH_HUD(),
					0,
					Config.getWIDTH_HUD(),
					config.getHEIGHT_SCREEN());
		//Grid
		g.setColor(Color.white);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				g.drawRect(0 + Config.getSIZE_GRID() * i, //Position X
							0 + Config.getSIZE_GRID() * j, //Position Y
							Config.getSIZE_GRID(), //Size
							Config.getSIZE_GRID()); //Size
			}
		}
		
		player.Render(g);
		
		g.dispose();
		bs.show();
				
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.MoveForward();
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.MoveForback();
		}
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("opa");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.RotateRight();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.RotateLeft();
		}
		
		
		
	}
}