package main;

import java.util.LinkedList;
import java.util.List;

public abstract class Search 
{
	public String searchType = "Search"; 
	public List<BoardState> closed = new LinkedList<BoardState>(); 
	protected static List<BoardState> fringe = new LinkedList<BoardState>();

	static int pegsRemaining; 
	int loopDetectionCount; 
	static int nodesExamined = 0;
	public static int[] goalPosition = new int[2]; 

	static int[] getGoalPosition()
	{
		return goalPosition; 
	}

	/*** 
	 * This method increments the loop detection counter, and prints 
	 * the total number of detected loops.
	 */
	public void loopDetectionCount() 
	{
		loopDetectionCount++; 
		if (loopDetectionCount % 10000 == 0)
		{
			System.out.println("Loops detected! " + loopDetectionCount + "+ loops detected.");
		}
	}
	public int getLoopsDetected()
	{
		return loopDetectionCount; 
	}

	public abstract boolean find(BoardState initialState, BoardState goalState);
	public void printSolution(BoardState board, boolean found)
	{
		System.out.println("--------------------------------");
		System.out.println("Solution Found: " + found);
		System.out.println("Nodes Expanded: " + nodesExamined);
		System.out.println("Loops Detected: " + getLoopsDetected());

		if(found)
		{
			List<BoardState> solution = new LinkedList<BoardState>(); 
			// follow parents to find solution
			while(board != null)
			{		
				solution.add(board);
				board = board.parent;
			}

			System.out.println(" ");
			System.out.println("Moves Required: " + (solution.size()-1));
			System.out.println("Solution Path:");
			for(int i = solution.size() - 1; i >= 0; i--)
			{
				solution.get(i).printState(solution.get(i));
			}
		}

	}
}

