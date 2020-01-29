/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author davidbendeck
 */
public class Assets {
    
    
    public static BufferedImage player,  background, shot, explosion;
    public static BufferedImage[][] alien  = new BufferedImage[3][2];
    public static BufferedImage[] spaceship = new BufferedImage[2];
    
    
    public static void init(){
        
        player = ImageLoader.loadImage("/textures/player.png");
        alien[0][0] = ImageLoader.loadImage("/textures/alien0open.png");
        alien[0][1] = ImageLoader.loadImage("/textures/alien0closed.png");
        alien[1][0] = ImageLoader.loadImage("/textures/alien1open.png");
        alien[1][1] = ImageLoader.loadImage("/textures/alien1closed.png");
        alien[2][0] = ImageLoader.loadImage("/textures/alien2open.png");
        alien[2][1] = ImageLoader.loadImage("/textures/alien2closed.png");
        background = ImageLoader.loadImage("/textures/background.png");
        //spaceship[0] = ImageLoader.loadImage("/textures/spaceship.png");
        spaceship[0] = ImageLoader.loadImage("/textures/spaceship1.png");
        spaceship[1] = ImageLoader.loadImage("/textures/spaceship2.png");
        shot = ImageLoader.loadImage("/textures/shot.png");
        explosion = ImageLoader.loadImage("/textures/explosion.png");
    }
    
}
