package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class EmptyLeafSpace {
	public float x,y;
	Image mtLeaf;
	Rectangle bounds;
	boolean filled;
	public EmptyLeafSpace(int x, int y) throws SlickException{
		this.x = x;
		this.y = y;
		mtLeaf = new Image("res/images/mt.png");
		bounds = new Rectangle(x,y,mtLeaf.getWidth(),mtLeaf.getHeight());
		filled = false;
	}
	void draw(){
		mtLeaf.draw(x,y);
	}
	public void fall(int delta){
		y+=0.05*delta;
	}

}
