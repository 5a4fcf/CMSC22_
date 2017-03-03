package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.StateBasedGame;

public class RainingLeaves extends StateBasedGame{
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 728;
	

	public RainingLeaves(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Main());
		addState(new Instructions());
		addState(new Level());
		addState(new Credits());
		addState(new Rainy());
		addState(new Sunny());
	}
	
	public static int getWidth(){
		return WIDTH;
	}
	
	public static int getHeight(){
		return HEIGHT;
	}
	
	public static void main(String[] arguments) throws SlickException{
        AppGameContainer app = new AppGameContainer(new RainingLeaves("It's Raining Leaves"));
        //app.setIcon("res/images/icon.png");
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setShowFPS(false);;
        app.start();
	}

}