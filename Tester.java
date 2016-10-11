package ex1;

public class Tester {
	public static void main(String args[]){
		Movable m1 = new MovablePoint(5,6,10,3);
		System.out.println(m1);
		m1.moveLeft();
		m1.moveRight();
		m1.moveUp();
		//m1.moveDown();
		
		System.out.println(m1);
	
		Movable m2 = new MovableCircle(2,1,2,20,5);
		System.out.println(m2);
		m2.moveRight();
		m2.moveLeft();
		m2.moveDown();
		
		System.out.println(m2);
		
		Movable m3 = new MovableRectangle(2,3,4,5,10,5);
		System.out.println(m3);
		m3.moveUp();
		System.out.println(m3);
	}
}
