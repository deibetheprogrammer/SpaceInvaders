/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;


import spaceinvaders.display.Display;
import spaceinvaders.gfx.Assets;
import spaceinvaders.input.KeyManager;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import spaceinvaders.entities.Background;
import spaceinvaders.entities.ScoreBoard;
import spaceinvaders.entities.creatures.Alien;
import spaceinvaders.entities.creatures.Bomb;
import spaceinvaders.entities.creatures.Creature;
import spaceinvaders.entities.creatures.Player;
import spaceinvaders.entities.creatures.Shot;
import spaceinvaders.entities.creatures.Spaceship;

/**
 *
 * @author davidbendeck
 */
public class Game implements Runnable {
    Random rand = new Random();
    
    // Lol un comment para git
    
    private int ticks = 0;
    private Display display;
    public int width, height;
    public String title;
    
    private boolean running = true;
    
    private BufferStrategy bs;
    private Graphics  g;
    
    //States
    
    private ScoreBoard scoreboard;
    private Player player;
    private Background background;
    private Spaceship spaceship;
    private Shot shot;
    private final ArrayList<Bomb> bombs = new ArrayList<>();
    private final ArrayList<Alien> aliens = new ArrayList<>();
    private Thread thread;
    
    //Input
    private KeyManager keyManager;

    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        init();
        //loop();

    }
    
    private void init(){
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        scoreboard = new ScoreBoard(this,0,10);
        player = new Player(this, 0,this.height-Creature.DEFAULT_CREATURE_HEIGHT);
        background = new Background(this, 0, 0);
        spaceship = new Spaceship(this,0,32);
        shot = new Shot(this,player.getX(),player.getY());
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                int type = i/2;
                aliens.add(new Alien(this, j * (int) (Commons.ALIENWIDTH * 1.5), 32*3 + i * (int) (Commons.ALIENHEIGHT * 1.5),type));
            }
        }
        
        
    }
    
    //int x = 0;
    private void tick(){
        
        ticks++;
        ticks %= 60;
        keyManager.tick();
        player.tick();

        if (keyManager.space && !shot.isVisible()){
            shot.setX(player.getX()+(int)(player.getWidth()/2));
            shot.setY(player.getY());
            shot.setVisible(true);
            System.out.println("shot should be visible"+shot.getY());
        }
        shot.tick();
        spaceship.tick();
        if (collision(shot,spaceship)){
            shot.reset(player.getX(),player.getY());
            spaceship.setExplode(10);
            scoreboard.addScore(200);
        }
        
        int minx = width;
        int maxx = 0;
        float as = 0;
        for (int i =0; i<aliens.size();i++){
            Alien a = aliens.get(i);
            if (a.isVisible() && a.isExplode()==0){
                as=a.getSpeed();
                minx = Math.min(minx,(int)a.getX());
                maxx = Math.max(maxx,(int)a.getX());
            }
        } 
        //System.out.println("max y min"+minx+" "+maxx+" "+as);

        if ((as > 0 && maxx > width - Commons.ALIENWIDTH) || (as < 0 && minx < 0)) {
            as = -as;
            for (int i = 0; i < aliens.size(); i++) {
                Alien a = aliens.get(i);
                a.setSpeed(as);
                a.setY((float) (a.getY() + Commons.ALIENHEIGHT * 0.8));
            }
            

        }
  
        for (int i =0; i<aliens.size();i++){
            Alien ET = aliens.get(i);
            ET.tick();
            
            if (ET.isVisible() && shot.isVisible()) {
                if (collision(shot, ET)) {
                    shot.reset(player.getX(), player.getY());
                    ET.setExplode(10);
                    aliens.remove(i);
                    scoreboard.addScore(50);
                }
            }
            
            else if (ET.isVisible()) {
                if (collision(ET,player)) {
                    JOptionPane.showMessageDialog(null, "You lost, invasion was a success!");
                    running = false;
                }
                else if (ET.getY() > this.height - 32) {
                    JOptionPane.showMessageDialog(null, "You lost, invasion was a success!");
                    running = false;
                    break;
                }
                    
            }
            
            
                
        }
        
        if (aliens.isEmpty()) {
            JOptionPane.showMessageDialog(null,"You won !");
            running = false;
        }
        
        else if (ticks == 0) {
            Alien ET = aliens.get(rand.nextInt(aliens.size()-1));
            bombs.add(new Bomb(this,ET.getX(),ET.getY()));
        }
        
        for (int i = 0; i < bombs.size(); i++) {
            Bomb b = bombs.get(i);
            b.tick();
            if (b.isVisible()) {
                if (collision(b, player)) {
                    JOptionPane.showMessageDialog(null,"You lost, invasion was a success!");
                    running = false;
                }
            }
            
            else {
                bombs.remove(b);
            }
        }
        
        
        
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
       
        
        background.render(g);
        scoreboard.render(g);
        shot.render(g);
        player.render(g);
        spaceship.render(g);
        
        ListIterator<Alien> 
                iterator = aliens.listIterator(); 
  
        for (int i =0; i<aliens.size();i++){
            aliens.get(i).render(g); 
        } 
        
        for (int i = 0; i < bombs.size(); i++) {
            bombs.get(i).render(g);
        }


        bs.show();
        g.dispose();
                
    }
    public void run(){
        
        int fps = 60;
        double timePerTick = 1000000000 /  fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        while(running){
            now = System.nanoTime();
            delta+=(now  - lastTime) / timePerTick;
            lastTime = now;
            if(delta >= 1){
                tick();
                render();
                delta --;
            }
            if (keyManager.esc)
                running = false;
        }
        stop();
    // Publicar los resultados    
    }
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        System.exit(0);
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public boolean collision(Creature a, Creature b){
        return a.getBounds().intersects(b.getBounds());
        
    }
    
}
