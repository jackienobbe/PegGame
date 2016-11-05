package main;

import java.util.LinkedList;
import java.util.List;

public abstract class Search 
{
	protected List<BoardState> closed = new LinkedList<BoardState>();
	protected static List<BoardState> fringe = new LinkedList<BoardState>();

	static int pegsRemaining;// = 0; 
	static int nodesExamined = 0;
	public static int[] goalPosition = new int[2]; 

//	void setGoalPosition(BoardState goalState)
//	{
//		for (int i = 0; i < goalState.getPegPositions().length; i++ )
//		{
//			for(int j = 0; j < goalState.getPegPositions()[i].length; j++)
//			{
//				if(goalState.getPegPositions()[i][j] == 1)
//				{
//					goalPosition[0] = i; 
//					goalPosition[1] = j; 
//					//System.out.println(i + " " + j);
//				}
//			}
//		}
//		//System.out.println("HERE " + goalState.getPegPositions().length); 
//	}	
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

	public boolean checkGoalState( BoardState board, BoardState goalState, int pegsRemaining )
	{
		if ( pegsRemaining == 1)
		{
			System.out.println("Wiennnerrrrrr");
			return true; 
		}
		for( int i = 0; i < board.getPegPositions().length; i++ )
		{
			for( int j = 0; j < board.getPegPositions()[i].length; j++ )
			{
				if( board.getPegPositions()[i][j] != goalState.getPegPositions()[i][j])
				{
					//System.out.println("NOT GOAL");
					return false; 
				}
			}
		}
		System.out.println("GOOOOALLLLLLLL");
		return true; 
	}
	public abstract boolean find(BoardState initialState, BoardState goalState);
}

