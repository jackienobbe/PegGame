package main;

import java.util.LinkedList;
import java.util.List;

public abstract class BoardState
{
	List<BoardState> children = new LinkedList<BoardState>();
	BoardState parent = null;
	public int pathCost; 

	public abstract int incrementPathCost(BoardState board); 
	public abstract int getPathCost(BoardState board); 
	public abstract int getHeuristicCost(BoardState board); 
	public abstract List<BoardState> expand(BoardState board);
	public abstract boolean checkGoalState(BoardState currentState, BoardState goalState);
	public abstract void printGameInfo(BoardState board);
	public abstract void printState(BoardState board);
	public abstract int getHeuristicValue(BoardState board);
}
