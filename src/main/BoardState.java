package main;

import java.util.LinkedList;
import java.util.List;

public abstract class BoardState
{

	List<BoardState> children = new LinkedList<BoardState>();
	//private int branchingFactor;

	public List<BoardState> expand(BoardState board)
	{
		return children;
	}
	
	public void setBranchingFactor()
	{
		
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

	public boolean equals(Object o)
	{
		if(o instanceof BoardState)
		{
//			BoardState board = (BoardState)o;
//			for(int i = 0; i < board.getPegPositions().length; i++)
//			{
//				for(int j = 0; j < board.getPegPositions()[i].length; j++)
//				{
//					if(this.pegPositions[i][j] != board.getPegPositions()[i][j])
//					{
//						return false;
//					}
//				}
//			}
			return true;
		}  
		else return false; 
	}
	public int getHeuristicCost(BoardState board) 
	{
		int heuristicCost = Heuristic.weightedCost(board); 
		return heuristicCost;
	}

	public int[][] getBoardState() 
	{
		return null;
	}

	public int getPegsRemaining( BoardState board ) 
	{
		return 7;
	}

}
