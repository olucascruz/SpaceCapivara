package com.space_capivara.classes;

public class Map {
	
private int[][] map_data = new int[10][10];
	
	public int[][] getMap_data() {
		return map_data;
	}	
	
	
	public void setMap_data(int x, int y, int Object) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(i == x && y == j)
				map_data[i][j] = Object;
			}
					
		}
	}
	public void ClearMap() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				map_data[i][j] = 0;
			}
		}
	}

}
