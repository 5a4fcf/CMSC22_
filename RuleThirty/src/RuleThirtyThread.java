import java.util.Arrays;

public class RuleThirtyThread extends Thread{
	int start ,end, size ;
	int[][] grid;
	
	public RuleThirtyThread(int start,int end, int size , int[][] grid){
		this.start = start;
		this.end = end;
		this.size = size;
		this.grid = grid;
	}
	
	
	
	public void run(){
		 int[][] rule = new int[][]{{1,1,1},{1,1,0},{1,0,1},{1,0,0},{0,1,1},{0,1,0},{0,0,1},{0,0,0}};
	     int[] result = new int[]{0,0,0,1,1,1,1,0} , three = new int[3];
	     int i,j,k;
	     
	     for(i = 1 ; i<size ; i++)
	            for(j = start; j<size ; j++){
	                three[1] = grid[i-1][j];
	                if(j>0)
	                    three[0] = grid[i-1][j-1];
	                else
	                    three[0] = 0;
	                if(j+1==size)
	                    three[2] = 0;
	                else
	                       three[2] = grid[i-1][j+1];
	                for(k = 0 ; k<8 ; k++)
	                    if(Arrays.equals(rule[k],three)) 
	                        grid[i][j] = result[k];
	            }
	}
	
	public void print(){
		for(int i = 0 ; i<size ; i++){
            for( int j = 0 ; j <size ; j++)
                System.out.print(grid[i][j]);
            System.out.println();
        }
	}
}
