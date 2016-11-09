package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class Search 
{
	public List<BoardState> closed = new LinkedList<BoardState>(); 
	Scanner scanner = new Scanner(System.in);
	public long start = System.currentTimeMillis();
	public long end = start + 120*1000; // 120 seconds * 1000 ms/sec
	public boolean continueSearch = true;

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

			System.out.println("Moves Required: " + (solution.size()-1));
			System.out.println("Solution:");
			solution.get(0).printGameInfo(board); 

			for(int i = solution.size() - 1; i >= 0; i--)
			{
				solution.get(i).printState(solution.get(i));
			}
		}
		System.out.println(" ");
	}
}

