package com.space_capivara.classes;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class musicStuff {
	
	void playMusic (String musiclocation)
	{
		try 
		{
			File musicPath = new File(musiclocation);
			
			if (musicPath.exists()) 
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
