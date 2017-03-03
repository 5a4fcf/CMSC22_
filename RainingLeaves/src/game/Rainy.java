package game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Rainy extends BasicGameState
{
	StateBasedGame game;
	public static final int ID = 1;
	
	private Image bg , gameover;
	public static Catcher catcher;
	private static ArrayList<Leaf> leaves;
	private ArrayList<Cloud> clouds;
	private int time;	
	private Random r = new Random();			
	private int spawnTime = 0;					
	private int spawnDelay = 1000;	
	private float speed;
	private boolean go;
	
	@Override
	public int getID() { return ID;}
	
	public static ArrayList<Leaf> getLeaves(){
		return leaves;
	}
	
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		game = sbg;
		gc.getInput().enableKeyRepeat();							
    	bg = new Image("res/images/level1.png");
    	gameover = new Image("res/images/go.png");
    	leaves = new ArrayList<Leaf>(100);								
    	clouds = new ArrayList<Cloud>(4);									
    	initClouds();														
		addRandomLeaves();												
    	catcher = new Catcher();	
    	time = 0;
    	speed = 0.5f;
    	go = false;

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    	bg.draw();	
    	g.setColor(Color.black);
    	g.drawString("Time : " + (30 - time/1000), 50, 190);
    	g.drawString("Leaves : " + catcher.getCountOfLeaves(), 50, 240);
    	g.drawString("Lives : " + catcher.getLife(), 50, 290);
    	for(Leaf l : leaves){l.draw();}												
    	catcher.draw();																				
    	for(Cloud c: clouds){c.draw(c.x, c.y);}	
    	if(go){
    		gameover.draw();
    	}

		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {		
    	time+=delta;
    	
    	if(time/1000 == 30){
    		time = 30000;
    		if(catcher.getCountOfLeaves() < 20  || catcher.getLife() == 0){
    			go = true;
    			if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
    				game.enterState(0,new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
    			}
    		}else{
    			game.getState(5).init(gc, sbg);
        		game.enterState(5, new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
    		}
    		
    	}else{
    		if(catcher.getLife() == 0){
    			go = true;
    			if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
    				game.enterState(0,new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
    			}
    		}else{
    			for(Cloud c: clouds){c.update();}															
            	catcher.update(gc.getInput() , leaves);														
            	spawnTime+=delta*r.nextInt(10);	
            	if(spawnTime>spawnDelay){																	
            		spawnTime = 0;
            		addRandomLeaves();		
            	}
            	for(Leaf l : leaves){
            		l.update(RainingLeaves.getHeight(), delta);										
            	}
    		}
    		
    	}
    	
	}
	
    
    private void initClouds() throws SlickException{						
    	for(int i = 0 ; i!=4 ; i++){
    		Cloud c ;
    		if(i == 0){
        		c = new Cloud(50,-30,-0.007f);
        	}else if(i == 1){
        		c = new Cloud(300,0,-0.006f);
        	}else if(i == 2){
        		c = new Cloud(500,-5,0.005f);
        	}else{
        		c = new Cloud(150,-15,0.003f);
        	}
    		clouds.add(c);
    	}
    }
    
    private void addRandomLeaves()  throws SlickException{

    		Leaf e = new Leaf();	
    		e.setFallSpeed(speed);
    		e.setX(clouds.get(r.nextInt(4)).x + r.nextFloat() + r.nextInt(150));	
    		e.setY(80);
    		leaves.add(e);			
		
	}
 
}

