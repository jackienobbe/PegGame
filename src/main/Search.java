package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Search 
{
	@SuppressWarnings("unchecked")
	//List<List<BoardState>> closed = new ArrayList<List<BoardState>>(33);
	//protected Vector<BoardState>[] closed = new Vector[39]; // LinkedList<BoardState>();
	//public List<BoardState>[] closed = [39];
	ArrayList<BoardState>[] closed = (ArrayList<BoardState>[]) new ArrayList[39];
	protected static List<BoardState> fringe = new LinkedList<BoardState>();

	static int pegsRemaining; 
	int loopDetectionCount; 
	static int nodesExamined = 0;
	public static int[] goalPosition = new int[2]; 

	public void initializeClosed()
	{
		for(int i = 0; i < closed.length; i++)
		{
			closed[i] = new ArrayList<BoardState>();
		}		
	}
	static int[] getGoalPosition()
	{
		return goalPosition; 
	}

	//currentBoard.setBranchingFactor(children.size());
	//currentBoard.setChildren(children);
	//		System.out.println("children");
	//		for(int s=0;s<children.size();s++){
	//		    System.out.println(children.get(s));
	//		} 

	//		fringe.addAll(currentBoard.children);	
	//		fringe.remove(currentBoard);
	//		if (pegsRemaining < 6)
	//		{
	//			//System.out.println("Pegs Remaining: " + pegsRemaining);
	//		}
	//return currentBoard.children;

	/*** 
	 * This method increments the loop detection counter, and prints 
	 * the total number of detected loops.
	 */
	public void loopDetectionCount() 
	{
		loopDetectionCount++; 
		if (loopDetectionCount == 1)
		{
			System.out.println("Loop detected. " + loopDetectionCount + " loop detected.");
		}
		else
		{
			System.out.println("Loop detected. " + loopDetectionCount + " loops detected.");
		}
	}
	
	public abstract boolean find(BoardState initialState, BoardState goalState);
}

