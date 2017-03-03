package game;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tree {
	Image tree;
	private int countOfLeaves;
	public ArrayList<EmptyLeafSpace> mtLeaves;
	
	Tree() throws SlickException{
		tree = new Image("res/images/tree.png");
		countOfLeaves = 0;
		mtLeaves = new ArrayList<EmptyLeafSpace>(20);
		addMtLeaves();
	}
	
	void addMtLeaves() throws SlickException{
		mtLeaves.add(new EmptyLeafSpace(720,320));
		mtLeaves.add(new EmptyLeafSpace(730,210));
		mtLeaves.add(new EmptyLeafSpace(625,400));
		mtLeaves.add(new EmptyLeafSpace(860,395));
		mtLeaves.add(new EmptyLeafSpace(820,305));
		mtLeaves.add(new EmptyLeafSpace(970,356));
		mtLeaves.add(new EmptyLeafSpace(950,255));
		mtLeaves.add(new EmptyLeafSpace(580,325));
		mtLeaves.add(new EmptyLeafSpace(940,430));
		mtLeaves.add(new EmptyLeafSpace(830,150));
		mtLeaves.add(new EmptyLeafSpace(600,315));
		mtLeaves.add(new EmptyLeafSpace(710,200));
		mtLeaves.add(new EmptyLeafSpace(605,445));
		mtLeaves.add(new EmptyLeafSpace(760,395));
		mtLeaves.add(new EmptyLeafSpace(800,305));
		mtLeaves.add(new EmptyLeafSpace(940,366));
		mtLeaves.add(new EmptyLeafSpace(900,205));
		mtLeaves.add(new EmptyLeafSpace(560,325));
		mtLeaves.add(new EmptyLeafSpace(940,400));
		mtLeaves.add(new EmptyLeafSpace(800,175));
	}
	
	void draw(){
		tree.draw(550,175);
		for(EmptyLeafSpace mt: mtLeaves){
			mt.draw();
		}
	}
	
	int getCountOfLeaves(){
		return countOfLeaves;
	}
	void setCountOfLeaves(int c){
		countOfLeaves += c;
	}
}