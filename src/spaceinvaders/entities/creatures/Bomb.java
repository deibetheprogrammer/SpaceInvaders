/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entities.creatures;

import spaceinvaders.Game;
import spaceinvaders.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author davidbendeck
 */
public class Bomb extends Creature{
    
    private Game game;

    public Bomb(Game game, float x, float y) {
        super(x, y, 10, 16);
        this.game = game;
        speed = 1.5f;
    }
    
    @Override
    public void tick() {
        if (isVisible()){
            move();
            if (y>game.height){
                reset(0,0);
            }
        }
    }
    @Override
    public void move(){
        y+=speed;
    }
    
    
    @Override
    public void render(Graphics g) {
        if(isVisible()){
            g.drawImage(Assets.shot, (int) x, (int) y, width, height,null);
        }
    }
    public void reset(float x, float y){
        setVisible(false);
        setX(x);
        setY(y);
    }
}
