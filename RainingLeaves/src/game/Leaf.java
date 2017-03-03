package game;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Leaf {
	private float x, y, fallSpeed;
	public boolean isMovable;
	private int type;
	private Image[] leaves;
	private Image leaf;
	private Random r = new Random();
	private Rectangle bounds;
	
	
	public Leaf() throws SlickException{
		x = y = 0;
		fallSpeed = 0.05f;
		leaves = new Image[5];
		leaves[0] = new Image("res/images/normal.png");
		leaves[1] = new Image("res/images/bonus.png");
		leaves[2] = new Image("res/images/normal.png");
		leaves[3] = new Image("res/images/dry.png");
		leaves[4] = new Image("res/images/dry.png");
		int rand = r.nextInt(4);
		leaf = leaves[rand];
		type = rand;
		bounds = new Rectangle(x,y,getWidth(),getHeight());
		isMovable = true;
	}
	
	public Leaf(int i , int j) throws SlickException{
		x = i;
		y = j;
		fallSpeed = 0.05f;
		leaves = new Image[5];
		leaves[0] = new Image("res/images/normal.png");
		leaves[1] = new Image("res/images/bonus.png");
		leaves[2] = new Image("res/images/normal.png");
		leaves[3] = new Image("res/images/dry.png");
		leaves[4] = new Image("res/images/dry.png");
		int rand = r.nextInt(4);
		leaf = leaves[rand];
		bounds = new Rectangle(x,y,getWidth(),getHeight());
		isMovable = true;

	}
	
	public boolean leafCollision(Leaf[] leaves){
		for(Leaf l: leaves){
			if(l.bounds.intersects(bounds) && l!=this)
				return true;
		}
		return false;
	}
	
	public boolean collides(Tree t){
		for(EmptyLeafSpace e: t.mtLeaves){
			if(bounds.contains(e.bounds.getCenterX()+5,e.bounds.getCenterY()+5) && !e.filled){
				x = e.x+10;
				y = e.y+20;
				e.mtLeaf = this.leaf;
				e.filled = true;;
				t.setCountOfLeaves(1);
				return true;
			}
		}
		return false;
	}

	public void move(int newx,int newy){
		x = newx;
		y = newy;
		bounds.setX(x);
		bounds.setY(y);
	}
	public void update(int height , int delta){
		if(y+80 >= height){
			y+=0;
		}else{
			y+=fallSpeed * delta;
		}
	}
	
	public void setBounds(int x , int y){
		bounds.setX(x);
		bounds.setY(y);
	}
	
	public float getWidth(){
		return leaf.getWidth();
	}
	public float getHeight(){
		return leaf.getHeight();
	}
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public float getFallSpeed(){
		return fallSpeed;
	}
	public void setFallSpeed(float s){
		fallSpeed = s;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	
	public int getType(){
		return type;
	}
	public void draw(){
		leaf.draw(x,y);
	}
	
	public void draw(int i , int j){
		leaf.draw(x - i,y - j);
		
	}
	
	public void fall(int delta){
		y+=0.05*delta;
	}
	
	
	

}

