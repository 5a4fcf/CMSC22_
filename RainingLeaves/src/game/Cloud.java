package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cloud {
	public float x, y, xSpeed;
	Image cloud;
	
	Cloud(float x,float y,float xSpeed) throws SlickException{
		this.y = y;
		this.xSpeed = xSpeed;
		this.x = x;
		cloud = new Image("res/images/cloud.png");
	}
	
	void draw(float xx,float yy){
		cloud.draw(xx,yy,0.2f);
	}
	
	void update(){
		x+=xSpeed;
	}

}
