package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Level extends BasicGameState{
	public static int ID = 2;
	StateBasedGame game;
	Image bg;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("res/images/level.png");
	    game = sbg;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw();
		
	}
	
//	85 485 332 244
//	388 485 635 244
//	697 485  942 244
//	102 106 248 56

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int d) throws SlickException {
		int posX = Mouse.getX();
        int posY = Mouse.getY();
        boolean mousePressed = Mouse.isButtonDown(0);
        if(posX >= 85 && posX <= 332 && posY<= 485 && posY >= 244){
        	if(mousePressed){
        		//intro.stop();
        		game.getState(1).init(gc, sbg);
        		game.enterState(Rainy.ID, new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
        	}
        }else if(posX >= 388 && posX <= 635 && posY<= 485 && posY >= 244){
        	if(mousePressed){
        		System.out.println("level 2");
        	}
       		 //game.enterState(Instructions.ID, new FadeOutTransition(Color.cyan),new FadeInTransition(Color.white));
       	}else if(posX >= 697 && posX <= 942 && posY<= 485 && posY >= 244){
        	if(mousePressed){
        		System.out.println("level mystery");
        	}
        }else if(posX >= 102 && posX <= 248 && posY<= 106 && posY >= 56){
        	if(mousePressed){
        		game.enterState(Main.ID, new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
        	}
        }
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
