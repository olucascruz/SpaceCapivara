package com.space_capivara.classes;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Config config = new Config();
	Player player = new Player();
	Enemy enemy = new Enemy();
	Map map = new Map();
	Menu menu = new Menu();
	HUD hud = new HUD();
	
	boolean game_selected = false;
	
	public Game(){
		this.setPreferredSize(new Dimension(config.getWIDTH_SCREEN(), config.getHEIGHT_SCREEN()));
		this.addKeyListener(this);
	}
	
	public void tick() {
		if(game_selected) {
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
	}
	
	public void Map(Graphics g) {
		map.ClearMap();
		map.setMap_data(player.getPosition_x(), player.getPosition_y(), 1);
		if(map.getMap_data()[enemy.getPosition_x()][enemy.getPosition_y()] == 1) {
			player.loseLife();
		}
			
		map.setMap_data(enemy.getPosition_x(), enemy.getPosition_y(), 2);
		
		if(map.getMap_data()[player.getShoot_position_x()][player.getShoot_position_y()] == 2) {
			enemy.loseLife();
		}
		
		if(player.istShootExist()) {
			map.setMap_data(player.getShoot_position_x(), player.getShoot_position_y(), 3);
		}
		
		if(game_selected) {
			// Ships
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					if(map.getMap_data()[i][j] == 3) {
						g.drawImage(new ImageIcon(getClass().getResource(player.getImageLaser())).getImage(),
								i*Config.getSIZE_GRID(),
								j*Config.getSIZE_GRID(), null);
					}
					// 1 no map representa o player
					if(map.getMap_data()[i][j] == 1) {
						g.drawImage(new ImageIcon(getClass().getResource(player.getImagePlayer())).getImage(),
								i*Config.getSIZE_GRID(),
								j*Config.getSIZE_GRID(), null);
					// 2 no map representa o inimigo
					}else if(map.getMap_data()[i][j] == 2) {
						g.drawImage(new ImageIcon(getClass().getResource(enemy.getImageEnemy())).getImage(),
								i*Config.getSIZE_GRID(),
								j*Config.getSIZE_GRID(), null);
					// 3 no map representa o tiro	
						
					}
				}
			}
			
			// HUD
			
			// Capivara feliz
			g.drawImage(new ImageIcon(getClass().getResource(hud.getCapi_feliz())).getImage(), 750, 50,
					200,
					200, null);
			// Capivara raivosa
			g.drawImage(new ImageIcon(getClass().getResource(hud.getCapi_raivosa())).getImage(), 750, 50,
					200,
					200, null);
			// Capivara triste
			g.drawImage(new ImageIcon(getClass().getResource(hud.getCapi_triste())).getImage(), 750, 50,
					200,
					200, null);
			
			// Vidas
			g.drawImage(new ImageIcon(getClass().getResource(hud.getCoracao1())).getImage(), 750, 280,
					50,
					50, null);
			g.drawImage(new ImageIcon(getClass().getResource(hud.getCoracao2())).getImage(), 825, 280,
					50,
					50, null);
			g.drawImage(new ImageIcon(getClass().getResource(hud.getCoracao3())).getImage(), 900, 280,
					50,
					50, null);
			
			// Nave inimiga
			g.drawImage(new ImageIcon(getClass().getResource(hud.getInimigo())).getImage(), 810, 430,
					80,
					80, null);
		} else {
			// Background
			if(!menu.isTeam_selected()) {
				// Fundo
				g.drawImage(new ImageIcon(getClass().getResource(menu.getFundo_menu())).getImage(), 0, 0,
						1000,
						700, null);
				// Título
				g.drawImage(new ImageIcon(getClass().getResource(menu.getGame_title())).getImage(), 250, -40,
						700,
						300, null);
				// Seta
				g.drawImage(new ImageIcon(getClass().getResource(menu.getArrow())).getImage(), 100, 340 + menu.getArrow_position(),
						70,
						70, null);
				// Botão jogar
				g.drawImage(new ImageIcon(getClass().getResource(menu.getBtn_jogar())).getImage(), 80, 250,
						600,
						250, null);
				// Botão créditos
				g.drawImage(new ImageIcon(getClass().getResource(menu.getBtn_creditos())).getImage(), 80, 390,
						600,
						250, null);
			} else {
				// Fundo
				g.drawImage(new ImageIcon(getClass().getResource(menu.getFundo_team())).getImage(), 0, 0,
						1000,
						700, null);
				// Créditos
				g.drawImage(new ImageIcon(getClass().getResource(menu.getCreditos())).getImage(), 340, 50,
						700,
						600, null);
			}
			
		}
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		// Background
		g.drawImage(new ImageIcon(getClass().getResource("space.png")).getImage(), 0, 0,
				config.getHEIGHT_SCREEN(),
				config.getWIDTH_SCREEN(), null);
		
		//HUD
		g.setColor(new Color(60, 20, 80));
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
		
		Map(g);
		g.dispose();
		bs.show();
				
	}
	
	
	//Move o player e o inimigo
	//Limpa a o map após mover o player
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(game_selected) {
				player.MoveForward();
				map.ClearMap();
			} else {
				menu.setBtn_jogar_selected(true);
				menu.setArrow_position(0);
			}
			map.ClearMap();
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(game_selected) {
				player.MoveForback();
				map.ClearMap();
			} else {
				if(!menu.isTeam_selected()) {
					menu.setBtn_jogar_selected(false);
					menu.setArrow_position(130);
				}
			}
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(!game_selected) {
				if(!menu.isBtn_jogar_selected()) {
					menu.setBtn_jogar_selected(true);
					menu.setTeam_selected(true);
				} else if (menu.isTeam_selected()){
					menu.setBtn_jogar_selected(true);
					menu.setTeam_selected(false);
					menu.setArrow_position(0);
				} else {
					game_selected = true;
				}
			}
		}
	}
	
	
	//Rataciona o player
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(game_selected) {
				player.RotateRight();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(game_selected) {
				player.RotateLeft();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(game_selected) {
				player.Shoot();
			}
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
		
	}

	
}