/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entities;

import java.awt.Color;
import spaceinvaders.Game;
import spaceinvaders.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author davidbendeck
 */
public class ScoreBoard extends Entity{
    
    private Game game;
    private int score = 0;
    
    public ScoreBoard(Game game, float x, float y) {
        //super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        super(x, y, 100, 100);
        this.game = game;
    }
    
    @Override
    public void tick() {
    }

    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawString("SCORE " + score,(int) x, (int) y);
    }
    
    public void addScore(int points) {
        score += points;
        System.out.print("score");
    }
    
}
