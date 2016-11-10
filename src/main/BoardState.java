package main;

import java.util.LinkedList;
import java.util.List;

public abstract class BoardState
{
	List<BoardState> children = new LinkedList<BoardState>();
	//private int branchingFactor;
	public enum gameType {MC, PegSol}; 
	BoardState parent = null;
	public int pathCost; 

	/***************************
	 * Successor function. This method spawns new states to explore from the possible moves
	 * from the given state. 
	 * @param currentBoard is a current game state to find next moves
	 * @return List of BoardStates containing the next possible moves
	 */
	public abstract List<BoardState> expand(BoardState board);
	/**
	 * Goal test function. Checks if current state is the goal state.
	 */
	public abstract boolean checkGoalState(BoardState currentState, BoardState goalState);

	/**
	 * Increment path cost from start to this state with game specific .
	 * @param board 
	 * @return
	 */
	public int incrementPathCost(BoardState board)
	{
		return board.pathCost + board.getStepCost(); 
	}
	/**
	 * Gets path cost to input board state
	 * @param board
	 * @return path cost
	 */
	public int getPathCost(BoardState board) 
	{
		return board.pathCost;
	}
	public abstract int getHeuristicCost(BoardState board); 
	/*** 
	 * Checks if current state is the goal state.
	 * @param currentState a board state to check
	 * @param goalState a board in goal state to compare to
	 */
	public abstract void printState(BoardState board);
	public abstract int getStepCost(); 
	
}
