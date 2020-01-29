/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author davidbendeck
 */
public abstract class Entity {
    
    protected float x, y;
    protected int width, height;
    private boolean visible = true;
    
    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeigth(){
        return height;
    }
    
    public void setX(float x){
        this.x =  x;
    }
    public void setY(float y){
        this.y =  y;
    }
    public void setWidth(int width){
        this.width =  width;
    }
    public void setHeigth(int height){
        this.height =  height;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public Rectangle getBounds() {
	return new Rectangle((int)x, (int) y, width, height);
    }


}
