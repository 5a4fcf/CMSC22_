
import java.util.Scanner;

public class Solution {
	
	 public static final int THREAD_COUNT = 10;
	 public static final int MIN = 0;
	    
    public static void main(String args[] ) throws Exception {
    	 
    	
    	
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); 
        int[][] grid = new int[size][size];
        grid[0][size/2] = 1;
        
        long startTime = System.currentTimeMillis();
        tester1(size,grid);
        System.out.println("time consumed in millisec: " + (System.currentTimeMillis() - startTime));
        
        System.out.println("------------------------------------------------------------------------");
        
        startTime = System.currentTimeMillis();
        tester2(size,grid);
        System.out.println("time consumed in millisec: " + (System.currentTimeMillis() - startTime));
        
        sc.close();
        
        
       
    }
    
    
    static void tester1(int size,int[][] grid){
    	RuleThirtyThread[] worker = new RuleThirtyThread[THREAD_COUNT];
        int cellsPerThread = size/THREAD_COUNT;
        int start = 1;
        int end = start + cellsPerThread - 1;
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            if (i == THREAD_COUNT - 1) {
                end = size;
            }
            worker[i] = new RuleThirtyThread(start,end,size,grid);
            start = end + 1;
            end = start + cellsPerThread - 1;
        }
        
        int i;
        for (i = 0; i < THREAD_COUNT; i++) {
            worker[i].start();
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                } catch (InterruptedException e) {
                    System.err.println("thread interrupted: " + e.getMessage());
                }
            }
        }
        worker[i - 1].print();
        
    }
    
    static void tester2(int size,int[][] grid){
    	RuleThirty rt = new RuleThirty(0,size,size,grid);
    	rt.run();
    	rt.print();
    }
}