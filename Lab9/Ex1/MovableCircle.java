package ex1;

public class MovableCircle extends MovablePoint implements Movable {
	private int radius;
	private MovablePoint center;
	public MovableCircle(int x , int y , int xSpeed , int ySpeed , int radius){
		super(x, y, xSpeed, ySpeed);
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}
	public String toString(){
		
		
return super.toString() + "\tradius : " + radius
	public void moveUp(){
		center.moveUp();
	}
	public void moveDown(){
		center.moveDown();
	}
	public void moveLeft(){
		center.moveLeft();
	}
	public void moveRight(){
		center.moveRight();
	}
}
