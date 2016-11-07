package main;

import java.util.LinkedList;
import java.util.List;

public abstract class BoardState
{
	List<BoardState> children = new LinkedList<BoardState>();
	private int branchingFactor;
	BoardState parent = null; 

	public List<BoardState> expand(BoardState board)
	{
		return children;
	}
	
	public void setBranchingFactor(BoardState board)
	{
		board.branchingFactor = board.children.size(); 
	};

	public void setBoardState( int[][] newBoard, BoardState board)
	{
		//board.pegPositions = newBoard; 
	}

	void setChildren( List<BoardState> children )
	{
		this.children = children; 
	}

	public List<BoardState> getChildren() 
	{
		return children;
	}
	public int incrementPathCost()
	{
		return 0;  //pathCost++; 
	}
	public int getHeuristicCost(BoardState board) 
	{
		int heuristicCost = Heuristic.getHeuristicCost(board); 
		return heuristicCost;
	}

	public int[][] getBoardState() 
	{
		return null;
	}

	public boolean checkGoalState(BoardState currentState, BoardState goalState) {
		// TODO Auto-generated method stub
		return false;
	}
}
