package com.space_capivara.classes;

public class Laser extends ObjectMobile{
    private String ImageLaser = getConfig().getImagesLaser()[0];

    public Laser(){
        start();
    }

    public void Shoot(String direction, int x, int y){
        setPosition_x(x);
        setPosition_y(y);
            switch (direction) {
                case "UP":
                    try {
                        getConfig();
						for (int i = 0; i < getConfig().getDistanceShoot(); i++) {                   
                            this.setImageLaser(0);
                            if (this.getPosition_y() == 0) {
                                break;
                            }
                            this.setPosition_y(this.getPosition_y() - 1);
                            sleep(getConfig().getSpeedShoot());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                    
                case "RIGHT":
                    try {
                        for (int i = 0; i < getConfig().getDistanceShoot(); i++) {
                            this.setImageLaser(1);
                            if (this.getPosition_x() == 9) {
                                break;
                            }
                            this.setPosition_x(this.getPosition_x() + 1);
                            sleep(getConfig().getSpeedShoot());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "DOWN":
                	
                    try {
                        for (int i = 0; i < getConfig().getDistanceShoot(); i++) {
                            this.setImageLaser(0);
                            if (this.getPosition_y() == 9) {
                                break;
                            }
                            this.setPosition_y(this.getPosition_y() + 1);
                            sleep(getConfig().getSpeedShoot());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                    
                case "LEFT":
                    try {
                        for (int i = 0; i < getConfig().getDistanceShoot(); i++) {
                            this.setImageLaser(1);
                            if (getPosition_x() == 0) {
                                break;
                            }
                            this.setPosition_x(getPosition_x() - 1);
                            sleep(getConfig().getSpeedShoot());
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }


    }


    public void setImageLaser(int index) {
        ImageLaser = getConfig().getImagesLaser()[index];
    }

    public String getImageLaser() {
        return ImageLaser;
    }


    public void run() {}
}
