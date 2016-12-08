package bridge;

public abstract class Shape {
	protected Color color;
	
	public Shape(Color c){
		this.color = c;
	}
	
	public abstract void applyColor();
}
