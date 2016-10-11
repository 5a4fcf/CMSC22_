package ex2;

public class Tester2 {
	public static void main(String args[]){
		GeometricObject a = new Circle(10.0);
		System.out.println(a);
		
		Resizable b = new ResizableCircle(100.0);
		System.out.println(b);
		b.resize(- 50);
		System.out.println(b);
	}
}
