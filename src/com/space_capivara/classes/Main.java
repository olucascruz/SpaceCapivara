package com.space_capivara.classes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main{
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame("Space Capivara");
		String filePath = "spaceThreat.wav";
		
		musicStuff musicObject = new musicStuff();
		musicObject.playMusic(filePath);
		
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new Thread(game).start();
	}
}
