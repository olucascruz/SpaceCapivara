package com.space_capivara.classes;

public class MusicManager {
	public static void music()
	{
	    {
	        FileInputStream("/res/music.wav");
	        MD = BGM.getData();
	        loop = new ContinuousAudioDataStream(MD);
	    }
	    MGP.start(loop);
	}
}