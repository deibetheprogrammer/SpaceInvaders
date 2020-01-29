/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;
import spaceinvaders.display.Display;

/**
 *
 * @author davidbendeck
 */
public class Laucher {
    public static void main(String[] args){
        Game  game = new Game("Space Invaders",640,480);
        game.start();
        System.exit(0);
    }
}
