package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Main extends BasicGameState{
	public static final int ID = 0;
	
	private StateBasedGame game;
    private Image bg , start , level , instructions , credits , exit , select;
    private Music intro;
    
    private int nav , x , y;
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	    	
	       bg = new Image("res/images/back.png");
	       start = new Image("res/images/start.png");
	       level = new Image("res/images/sel.png");
	       instructions = new Image("res/images/instructions.png");
	       credits = new Image("res/images/credits.png");
	       exit = new Image("res/images/exit.png");
	       select = new Image("res/images/ul.png");
	       game = sbg;
	       intro = new Music("res/sounds/int.ogg");
	       intro.setVolume(0.5f);
	       intro.loop();
	       nav = 1;
	       x = 350;
	       y = 130;
	       
    }

      @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    	  
    	  bg.draw();
    	  start.draw(350,130);
    	  level.draw(350,220);
    	  instructions.draw(350,310);
    	  credits.draw(350,400);
    	  exit.draw(350,490); 
    	  select.draw(x,y);
    	  
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    	Input key = gc.getInput();
    	if(key.isKeyPressed(Input.KEY_DOWN)){
    		if(nav == 5){nav = 5;}
    		else{nav++;}
    	}else if(key.isKeyPressed(Input.KEY_UP)){
    		if(nav == 1){nav = 1;}
    		else{nav--;}
    	}else if(key.isKeyDown(Input.KEY_ENTER)){
    		if(nav == 5){
    			System.exit(0);
    		}else{
    			game.getState(nav).init(gc, sbg);
        		game.enterState(nav, new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
    		}
    		
    	}
    	
    	switch(nav){
    	case 1:
    		x = 350;
    		y = 130;
    		break;
    	case 2:
    		x = 350;
    		y = 220;
    		break;
    	case 3:
    		x = 350;
    		y = 310;
    		break;
    	case 4:
    		x = 350;
    		y = 400;
    		break;
    	case 5:
    		x = 350;
    		y = 490;
    		break;
    	}
        
    }
    
   
    @Override
    public int getID() {
        return 0;
    }

}

