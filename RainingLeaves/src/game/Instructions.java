package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Instructions  extends BasicGameState{
     public static final int ID = 3; 
     StateBasedGame game;
     public Image bg;
     
    public int getID(){
        return ID;
    }

    @Override
    public void init(GameContainer g, StateBasedGame sbg) throws SlickException {
        bg = new Image("res/images/ins.png");
        game = sbg;
    }

    @Override
    public void render(GameContainer gC, StateBasedGame sbg, Graphics g) throws SlickException {
    	bg.draw();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    	int posX = Mouse.getX();
        int posY = Mouse.getY();
        boolean mousePressed = Mouse.isButtonDown(0);
        if(posX >= 102 && posX <= 248 && posY<= 106 && posY >= 56){
        	if(mousePressed){
        		game.enterState(Main.ID, new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
        	}
        }
        
    }
    
}
