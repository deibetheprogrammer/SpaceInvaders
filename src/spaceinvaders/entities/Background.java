/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entities;

import spaceinvaders.Game;
import spaceinvaders.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author davidbendeck
 */
public class Background extends Entity{
    
    private Game game;

    public Background(Game game, float x, float y) {
        //super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        super(x, y, 100, 100);
        this.game = game;
    }

    
    
    @Override
    public void tick() {
    }

    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background,(int) x,(int)y, game.width, game.height,null);
    }
    
}
