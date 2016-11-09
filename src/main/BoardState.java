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

	void setChildren( List<BoardState> children )
	{
		this.children = children; 
	}

	public List<BoardState> getChildren() 
	{
		return children;
	}
	public int incrementPathCost(BoardState board)
	{
		return board.pathCost++; 
	}
	public int getPathCost(BoardState board) 
	{
		//System.out.println(board.pathCost);
		return board.pathCost;
	}
	public abstract int getHeuristicCost(BoardState board); 
	public abstract List<BoardState> expand(BoardState board);
	public abstract boolean checkGoalState(BoardState currentState, BoardState goalState);
	public abstract void printGameInfo(BoardState board);
	public abstract void printState(BoardState board);
	public abstract int getHeuristicValue(BoardState board);

	
}
