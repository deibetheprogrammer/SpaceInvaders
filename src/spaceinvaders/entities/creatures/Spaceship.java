/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entities.creatures;

import spaceinvaders.Game;
import spaceinvaders.gfx.Assets;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author davidbendeck
 */
public class Spaceship extends Creature{
    Random rand = new Random();
    
    private Game game;
    private int gix = 0;

    public Spaceship(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        speed=1;
    }

    @Override
    public void tick() {
        if  (this.isExplode()>0){
            setExplode(this.isExplode()-1);
            if (this.isExplode()==0){
                    newX();
                gix = (gix +1) % 2;
            }
        }
        move();
        
    }
    
    @Override
    public void move() {
        x+=speed;
        if (x>game.width){
            newX();
            gix = (gix +1) % 2;
        }
        
    }
    
    @Override
    public void render(Graphics g) {
        if (isExplode()==0){
            g.drawImage(Assets.spaceship[gix], (int) x, (int) y, width, height,null);
        } else{
            g.drawImage(Assets.explosion, (int) x, (int) y, width, height,null);
        }
    }
    
    private void newX() {
        x = (float) -rand.nextInt(1000);
        System.out.println(x);
    }
    
}
