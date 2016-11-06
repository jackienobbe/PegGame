package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class MCBoardState extends BoardState
{
	private static final int MISSIONARIES = 0;
	private static final int CANNIBALS = 1;
	private static final int BOAT = 2;

	private int cannibals;
	private int missionaries;
	//private int cannibals;
	//private int missionariesRight;
	private int boat;

	int [] boardState = new int[3];
	List<int[]> possibleMoves = new LinkedList<int[]>(); 
	public MCBoardState(int[] intlBoardState, int level) 
	{
		int[] initialBoardState = new int[] {3,3,1}; 

		//Initialize Game Board vector using user provided initialBoardState
		//		for ( int i = 0; i < initialBoardState.length; i++ )
		//		{
		//			boardState.add(initialBoardState[i]);
		//		}
		//		System.out.println(vector);

	}

	/***************************
	 * This method initializes the possible moves
	 * for the inputed initial game state and game
	 * constraints. 
	 ***************************/
	public void initializePossibleMoves()
	{
		possibleMoves.add(new int[]{1,0,1}); 
		possibleMoves.add(new int[]{2,0,1}); 
		possibleMoves.add(new int[]{0,1,1}); 
		possibleMoves.add(new int[]{0,2,1}); 
		possibleMoves.add(new int[]{1,1,1}); 
	}

	/***************************
	 * This method spawns new states to explore from the possible moves
	 * from the given state. The "successor" function.
	 * @param board is a current game state to find next moves
	 ***************************/
	public List<BoardState> expand( MCBoardState board )
	{
		// Check if boat is on the 
		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			if(possibleMoves.get(i)[MISSIONARIES] <= board.getMissionaries() &&
					possibleMoves.get(i)[CANNIBALS] <= board.getCannibals())
			{
				if(isValid())
				{
					BoardState child = new MCBoardState(boardState, 1);  //currentBoard.getPathCost() + 1);

					if(board.getBoat() == 0)
					{
						child = addPossibleMove((MCBoardState) child, i); 
					}
					if(board.getBoat() == 1)
					{
						child = subtractPossibleMove((MCBoardState) child, i); 
					}
					board.children.add(child);
				}
			}
		}
		return children; 
	}

	private BoardState addPossibleMove(MCBoardState board, int possibleMovesListPosition) 
	{
		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			board.missionaries += possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]; 
			board.cannibals += possibleMoves.get(possibleMovesListPosition)[CANNIBALS]; 
			board.boat += possibleMoves.get(possibleMovesListPosition)[BOAT]; 
		}
		return board;
	}
	private BoardState subtractPossibleMove(MCBoardState board, int possibleMovesListPosition) 
	{
		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			board.missionaries -= possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]; 
			board.cannibals -= possibleMoves.get(possibleMovesListPosition)[CANNIBALS]; 
			board.boat -= possibleMoves.get(possibleMovesListPosition)[BOAT]; 
		}
		return board;
	}
	public boolean isValid()
	{
		if ( getMissionaries() < getCannibals() && getMissionaries() <= 3 && 
				getCannibals() <= 3 && getCannibals() - getMissionaries() <= 0
				&& getMissionaries() > 0 )
		{
			return true; 
		}
		return false; 
	}

	private int getMissionaries() 
	{
		return missionaries;
	}
	private int getCannibals() 
	{
		return cannibals; 
	}
	private int getBoat()
	{
		return boat;
	}

}
