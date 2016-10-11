package ex2;
import java.lang.*;

public class Circle implements GeometricObject {
	protected double radius = 1.0 ;
	
	public Circle(double radius){
		this.radius = radius;
	}
	public double getPerimeter(){
		return 2*Math.PI*radius;
	}
	public double getArea(){
		return Math.PI*Math.pow(radius, 2);
	}
	
	public String toString(){
		return "A circle with radius : " + radius + " ,area: " + getArea() + " , perimeter: " + getPerimeter();
	}
}
