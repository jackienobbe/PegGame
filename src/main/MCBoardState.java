package main;

import java.util.LinkedList;
import java.util.List;

public class MCBoardState extends BoardState
{
	private static final int MISSIONARIES = 0;
	private static final int CANNIBALS = 1;
	private static final int BOAT = 2;

	private int cannibals;
	private int missionaries;
	private int boat;
	private int boatCapacity = 2; 

	int[] boardState = new int[3];
	int[] initialBoardState = new int[] {3,3,1}; 

	List<int[]> possibleMoves = new LinkedList<int[]>(); 

	public MCBoardState(int[] intlBoardState, int level) 
	{
		initializePossibleMoves(); 
		System.out.println("Length: " + initialBoardState.length); 
		for (int i = 0; i < initialBoardState.length; i++)
		{
			this.boardState[i] = initialBoardState[i]; 
			System.out.println("BoardState[" + i + "] " + boardState[i]); 
		}
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
	 * @return List of BoardStates containing the next possible moves
	 ***************************/
	public List<BoardState> expand( BoardState board )
	{
		for (int i = 0; i < initialBoardState.length; i++)
		{
			System.out.println("BoardState[" + i + "] " + boardState[i]); 
		}		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			if(possibleMoves.get(i)[MISSIONARIES] <= ((MCBoardState) board).getMissionaries() &&
					possibleMoves.get(i)[CANNIBALS] <= ((MCBoardState) board).getCannibals())
			{
				BoardState child = new MCBoardState(boardState, 1);  //currentBoard.getPathCost() + 1);
				if(((MCBoardState) board).getBoat() == 0)
				{
					child = addPossibleMove((MCBoardState) child, i); 
					System.out.println(child); 
				}
				if(((MCBoardState) board).getBoat() == 1)
				{
					child = subtractPossibleMove((MCBoardState) child, i); 
					System.out.println(child); 
				}
				if(isValid((MCBoardState) child))
				{
					board.children.add(child);
				}
			}
		}
		return children; 
	}

	/****
	 * This method "moves" missionaries and cannibals based on a possible move.  
	 * Used when the boat is on the goal side of the river. 
	 * @param board current state of game
	 * @param possibleMovesListPosition index of current possible move to be applied
	 * @return BoardState with applied move
	 */
	private BoardState addPossibleMove(MCBoardState board, int possibleMovesListPosition) 
	{
		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			board.missionaries += possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]; 
			board.cannibals += possibleMoves.get(possibleMovesListPosition)[CANNIBALS]; 
			board.boat += possibleMoves.get(possibleMovesListPosition)[BOAT]; 
			System.out.println("Here " + possibleMoves.get(i)); 
		}
		return board;
	}

	/****
	 * This method "moves" missionaries and cannibals based on a possible move.
	 * Used when the boat is on the starting bank.   
	 * @param board current state of game
	 * @param possibleMovesListPosition index of current possible move to be applied
	 * @return BoardState with applied move
	 */
	private BoardState subtractPossibleMove(MCBoardState board, int possibleMovesListPosition) 
	{
		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			System.out.println("Missionaries: " + possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]); 
			board.missionaries -= possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]; 
			board.cannibals -= possibleMoves.get(possibleMovesListPosition)[CANNIBALS]; 
			board.boat -= possibleMoves.get(possibleMovesListPosition)[BOAT]; 
			
			System.out.println("Here " + possibleMoves.get(i)); 
		}
		return board;
	}

	/*****
	 * Checks if game state in question is valid, in accordance with game rules.
	 * @return if the game state in question is valid
	 */
	public boolean isValid(MCBoardState board)
	{
		if ( board.getMissionaries() < board.getCannibals() && // More missionaries than cannibals on start bank
				board.getMissionaries() <= initialBoardState[MISSIONARIES] &&  // no more than start amount of missionaries
				board.getCannibals() <= initialBoardState[CANNIBALS] && 		 // no more than start amount of cannibals
				//initialBoardState[MISSIONARIES] - getMissionaries() <= initialBoardState[MISSIONARIES] && // end bank bound check
				//initialBoardState[CANNIBALS] - getCannibals() <= initialBoardState[CANNIBALS] && 		// end bank bound check
				initialBoardState[MISSIONARIES] - board.getMissionaries() >= initialBoardState[CANNIBALS] - board.getCannibals() // m > c on end bank
				&& board.getMissionaries() >= 0 && board.getCannibals() >= 0 )
		{
			return true; 
		}
		return false; 
	}

	public boolean checkGoalState(BoardState board, BoardState goalState)
	{
		return (getMissionaries() == 0 && getCannibals() == 0); 
	}
	public int getMissionaries() 
	{
		return this.missionaries;
	}
	public int getCannibals() 
	{
		return cannibals; 
	}
	public int getBoat()
	{
		return boat;
	}
	public int getBoatCapacity()
	{
		return boatCapacity;
	}

}
