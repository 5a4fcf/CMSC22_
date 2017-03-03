package game;



import java.util.Stack;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Sunny extends BasicGameState{
	StateBasedGame game;
	public  int ID = 5;
	
	
	private static int count;
	private boolean gameover , complete ;
	private int time;	
	private int x,y;
	private Image bg , go , comp , gen;
	private Tree tree;
	private Stack<Leaf> leaves;
	
	
	
	
	
	
	@Override
	public int getID() {
		return ID;
	}
	

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		game = sbg;
		count = Rainy.catcher.getCountOfLeaves();
		leaves = new Stack<Leaf>();
		x = 450 ; y = 200;
		for(int i =  0 ; i<count ; i++){
			leaves.push(new Leaf(x,y));
		}	
		tree = new Tree();	
    	bg = new Image("res/images/level1.png");	
    	comp = new Image("res/images/comp.png");
    	go = new Image("res/images/go.png");
    	gen = new Image("res/images/gen.png");
		gameover = false;
		complete = false;
    	
    	time = 0;
    	
	}
	
	@Override
	public void mouseDragged(int oldx , int oldy , int newx , int newy){
		if(!leaves.isEmpty() ){
			Leaf l = leaves.peek();
				l.move(newx,newy);
		}
		
	}
	
	@Override
	public void mouseReleased(int button , int x , int y){
		if(button == Input.MOUSE_LEFT_BUTTON){
			if(!leaves.isEmpty()){
				if(leaves.peek().collides(tree))
					leaves.pop();
				else
					leaves.pop();
			}
		}
	}

	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		time+=delta;
		if(time/1000 >= 20 ){
			time = 20000;
			if(tree.getCountOfLeaves() < 20){
				for(EmptyLeafSpace mt : tree.mtLeaves){
					mt.fall(delta);
				}
				while(!leaves.isEmpty()){
					leaves.peek().fall(delta);
					leaves.pop();
				}
				gameover = true;
				if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
    				game.enterState(0,new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
    			}
			}else{
				complete = true;
			}
			
		}else{
			if(tree.getCountOfLeaves() == 20){
				complete = true;
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
    				game.enterState(0,new FadeOutTransition(Color.white),new FadeInTransition(Color.white));
    			}
			}
			if(!leaves.isEmpty() && time/1000 <= 20){
				leaves.peek().fall(delta*5); 
				if(leaves.peek().getY() > 600)
					leaves.pop();
			}
		}
		
		
	}
 
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw();
		g.setColor(Color.black);
    	g.drawString("Time : " + (20 - time/1000), 50, 190);
		tree.draw();
		for(Leaf l : leaves){
			l.draw();
		}
		gen.draw();
		if(gameover){
			go.draw();
		}else if(complete){
			comp.draw();
		}
	}

}
