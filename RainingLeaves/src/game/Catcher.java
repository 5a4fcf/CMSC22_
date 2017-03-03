package game;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public  class Catcher {
	private SpriteSheet basket;
	private int x , y;
	private int countOfLeaves;
	private Rectangle leafBounds ;
	private Rectangle bounds ;
	private Image catcher;
	private int level;
	private int life;
	
	
	Catcher() throws SlickException{
		basket = new SpriteSheet("res/images/catcher.png",300,300);
		leafBounds = new Rectangle(0,0,0,0);
		bounds = new Rectangle(0,0,0,0);
		catcher = basket.getSprite(4, 0);
		x = 10; y = 550;
		level = 1;
		life = 3;
		
	}
	
	public boolean collidesWith(Leaf leaves){
		leafBounds.setBounds(leaves.getX(), leaves.getY(), leaves.getWidth(), leaves.getHeight());
		bounds.setBounds(x+50, y, 100, basket.getHeight());
		return bounds.intersects(leafBounds);
	}
	
	public void update(Input input , ArrayList<Leaf> leaves) throws SlickException{
		if(input.isKeyDown(Input.KEY_LEFT)){
    		if(x-1 != 0){
    			x-=1;
    			catcher = basket.getSprite(2, 0);
    		}
    	}else if(input.isKeyDown(Input.KEY_RIGHT)){
    		if(x+100!=RainingLeaves.getWidth() ){
    			x+=1;
    			catcher = basket.getSprite(0, 0);
    		}
    	}else{
    		catcher = basket.getSprite(4, 0);
    	}
		for(Leaf l:leaves){
			if((l.getY())+80< RainingLeaves.getHeight() && this.collidesWith(l)){
				if(l.getType() == 1 && life!=0){
					life--;
				}
				l.setFallSpeed(y);
				countOfLeaves++;
			}
		}
		
	}
	
	public int getCountOfLeaves(){
		return countOfLeaves;
	}
	
	public void draw(){
			catcher.draw(x,y,0.5f);

	}
	
	public int getLevel(){
		return level;
	}
	public int getLife(){
		return life;
	}
}
