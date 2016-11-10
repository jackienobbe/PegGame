package main;

import java.util.LinkedList;
import java.util.List;

public class MCBoardState extends BoardState
{
	private static final int MISSIONARIES = 0;
	private static final int CANNIBALS = 1;
	private static final int BOAT = 2;
	private static final int STEP_COST = 1; 

	private int cannibals;
	private int missionaries;
	private int boat;
	private int boatCapacity = 2; 

	//private int branchingFactor; 

	int[] boardState = new int[3];
	int[] initialBoardState = new int[] {3,3,1}; 

	List<int[]> possibleMoves = new LinkedList<int[]>(); 

	public MCBoardState(int missionaries, int cannibals, int boat, int pathCost) 
	{
		initializePossibleMoves(); 

		this.missionaries = missionaries;
		this.cannibals = cannibals;
		this.boat = boat;
		this.pathCost = pathCost + 1; 
		//System.out.println("New Board: (" + this.missionaries + ", " + this.cannibals  + ", " + this.boat + ")" ); 
	}

	/***************************
	 * This method initializes the possible moves
	 * for the inputed initial game state and game
	 * constraints. 
	 * 
	 * NOTE: This method could be improved by spawning
	 * possible moves based on a game board of varying 
	 * sizes. This one only accounts for the start state
	 * of 3 Missionaries, 3 Cannibals, and a 2 person boat.
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
	 * @param currentBoard is a current game state to find next moves
	 * @return List of BoardStates containing the next possible moves
	 ***************************/
	public List<BoardState> expand( BoardState currentBoard )
	{	
		for( int i = 0; i < possibleMoves.size(); i++ )
		{
			// check if next possible move is within
			if(possibleMoves.get(i)[MISSIONARIES] <= ((MCBoardState) currentBoard).getMissionaries() &&
					possibleMoves.get(i)[CANNIBALS] <= ((MCBoardState) currentBoard).getCannibals())
			{
				BoardState child = new MCBoardState(((MCBoardState) currentBoard).getMissionaries(), 
						((MCBoardState) currentBoard).getCannibals(), 
						((MCBoardState) currentBoard).getBoat(), 
						((MCBoardState) currentBoard).getPathCost(currentBoard));
				if(((MCBoardState) currentBoard).getBoat() == 0)
				{
					child = addPossibleMove((MCBoardState) child, i); 
				}
				if(((MCBoardState) currentBoard).getBoat() == 1)
				{
					child = subtractPossibleMove((MCBoardState) child, i); 
				}
				if(isValid((MCBoardState) child))
				{
					currentBoard.children.add(child);
					child.parent = currentBoard;
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
		board.missionaries += possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]; 
		board.cannibals += possibleMoves.get(possibleMovesListPosition)[CANNIBALS]; 
		board.boat += possibleMoves.get(possibleMovesListPosition)[BOAT]; 

		//System.out.println("ADD(" + board.missionaries + ", " + board.cannibals  + ", " + board.boat + ")" ); 

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
		board.missionaries -= possibleMoves.get(possibleMovesListPosition)[MISSIONARIES]; 
		board.cannibals -= possibleMoves.get(possibleMovesListPosition)[CANNIBALS]; 
		board.boat -= possibleMoves.get(possibleMovesListPosition)[BOAT]; 

		//System.out.println("SUB(" + board.missionaries + ", " + board.cannibals  + ", " + board.boat + ")" ); 

		return board;
	}

	/*****
	 * Checks if game state in question is valid, in accordance with game rules.
	 * @return if the game state in question is valid
	 */
	public boolean isValid(MCBoardState board)
	{
		if( board.getMissionaries() >= board.getCannibals() &&
				board.getMissionaries() <= initialBoardState[MISSIONARIES] &&
				board.getCannibals() <= initialBoardState[CANNIBALS] &&
				board.getBoat() <= initialBoardState[BOAT] &&
				board.getMissionaries() >= 0 && board.getCannibals() >= 0 && board.getBoat() >= 0)
		{
			return true; 
		}
		return false; 
	}

	/*** 
	 * Goal test function. Checks if current state is the goal state.
	 */
	public boolean checkGoalState(BoardState board, BoardState goalState)
	{
		if (((MCBoardState) board).getMissionaries() == 0 && ((MCBoardState)board).getCannibals() == 0)
		{
			return true; 
		}
		return false; 
	}

	/***
	 * Prints game state with the number of missionaries, cannibals, and boat presence
	 */
	public void printState( BoardState board)
	{
		if (board instanceof MCBoardState)
		{
			//System.out.println("------------------------"); 
			System.out.println("(" + ((MCBoardState) board).getMissionaries() + ", " + getCannibals() + ", " + getBoat() + ")");
		}
	}
	public boolean equals(Object o)
	{
		if(o instanceof MCBoardState)
		{
			BoardState board = (MCBoardState)o;
			if(this.getMissionaries() != ((MCBoardState)board).getMissionaries() || 
					this.getCannibals() != ((MCBoardState)board).getCannibals()	||
					this.getBoat() != ((MCBoardState)board).getBoat())
			{
				return false;
			}
		}
		return true;
	}  
//	
//	int[] getBoardState()
//	{
//		return boardState;
//	}
	
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

	/**
	 * Heuristic cost getter. Calls a heuristic function.
	 * Uncomment/comment to choose heuristic function.
	 */
	public int getHeuristicCost(BoardState board)
	{
		return (((MCBoardState) board).getMissionaries() + ((MCBoardState) board).getCannibals()) / ((MCBoardState) board).getBoatCapacity(); 
		//return ((MCBoardState) board).getMissionaries() + ((MCBoardState) board).getCannibals() - 1; 
	}
	/**
	 * Gets step cost for this game
	 * @return step cost
	 */
	public int getStepCost()
	{
		return STEP_COST; 
	}
}
