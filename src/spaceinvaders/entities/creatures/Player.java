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
public class Player extends Creature{
    
    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, 32, 32);
        this.game = game;
    }
    
    @Override
    public void tick() {
        getInput();
        move();
    }
    @Override
    public void move(){
        x+=xMove;
        if (x<0){
            x=0;
        } else if (x>game.width - width) {
            x= game.width -width;
        }
    }
    private void getInput(){
        xMove=0;
        
        if (game.getKeyManager().left)
            xMove = - speed;
        if (game.getKeyManager().right)
            xMove =  speed;
    }
    
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, width, height,null);
    }
    
}
