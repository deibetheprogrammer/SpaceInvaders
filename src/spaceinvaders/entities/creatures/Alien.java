/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entities.creatures;

import spaceinvaders.Game;
import spaceinvaders.gfx.Assets;
import java.awt.Graphics;
import spaceinvaders.Commons;

/**
 *
 * @author davidbendeck
 */
public class Alien extends Creature{
    
    public final int WIDTH = 32;
    public final int HEIGHT = 32;
    private Game game;
    private int gix = 0;
    private int chgix =0;
    private int tipo;

    public Alien(Game game, float x, float y, int tipo) {
        super(x, y, Commons.ALIENWIDTH, Commons.ALIENHEIGHT);
        this.game = game;
        this.tipo = tipo;
        speed=0.5f;
    }

    @Override
    public void tick() {
        if (isVisible()){
            chgix =(chgix+1)%20;
            if (chgix==0) gix = (gix +1) % 2;
            if  (this.isExplode()>0){
                x=0;
                setExplode(0);
                setVisible(false);
            }
            move();
        }
    }
    public void move() {
        x+=speed;
    }
    
    @Override
    public void render(Graphics g) {
        if (isVisible()) {
            if (isExplode() == 0) {
                g.drawImage(Assets.alien[tipo][gix], (int) x, (int) y, width, height, null);
            } else {
                g.drawImage(Assets.explosion, (int) x, (int) y, width, height, null);
            }
        }
    }
    
}
