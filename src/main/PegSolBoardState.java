package main;

import java.util.List;

public class PegSolBoardState extends BoardState
{
	int[][] pegPositions;
	int pathCost; 
	//public int pegsRemaining;
	
	public PegSolBoardState( int[][] pegPositions, int level )
	{
		this.pegPositions = pegPositions; 
		//this.pathCost = pathCost; 
		for(int i = 0; i < pegPositions.length; i++)
		{
			for(int j = 0; j < pegPositions[i].length; j++)
			if(pegPositions[i][j] == 1)
			{
				Search.pegsRemaining++;  
			}
		}
	}
	
	@Override
	public List<BoardState> expand( BoardState currentBoard )
	{
		for( int i = 0; i < currentBoard.getBoardState().length; i++ )
		{
			for ( int j = 0; j < currentBoard.getBoardState()[i].length; j++ )
			{
				if(currentBoard.getBoardState()[i][j] == 0)
				{
					if(Driver.checkZeroMoveRight( currentBoard, i, j ))
					{				
						int[][] newPegs = new int[currentBoard.getBoardState().length][currentBoard.getBoardState().length];
						for( int g = 0; g < currentBoard.getBoardState().length; g++)
						{
							for(int h = 0; h < currentBoard.getBoardState()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getBoardState()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegRight( child, i, j ); 
						currentBoard.children.add(child);

						//	System.out.println("Move Right"); 
						//	Driver.printArray(child);
					}

					if(Driver.checkZeroMoveUp( currentBoard, i, j ))
					{						
						//System.out.println("here"); 

						int[][] newPegs = new int[currentBoard.getBoardState().length][currentBoard.getBoardState().length];
						for( int g = 0; g < currentBoard.getBoardState().length; g++)
						{
							for(int h = 0; h < currentBoard.getBoardState()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getBoardState()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegUp( child, i, j ); 
						currentBoard.children.add(child);

						//	System.out.println("Move UP"); 
						//	Driver.printArray(child);
					}
					if(Driver.checkZeroMoveLeft( currentBoard, i, j ))
					{
						int[][] newPegs = new int[currentBoard.getBoardState().length][currentBoard.getBoardState().length];
						for( int g = 0; g < currentBoard.getBoardState().length; g++)
						{
							for(int h = 0; h < currentBoard.getBoardState()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getBoardState()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegLeft( child, i, j ); 
						currentBoard.children.add(child);

						//	System.out.println("Move left"); 
						//	Driver.printArray(child);
					}
					if(Driver.checkZeroMoveDown( currentBoard, i, j ))
					{						
						int[][] newPegs = new int[currentBoard.getBoardState().length][currentBoard.getBoardState().length];
						for( int g = 0; g < currentBoard.getBoardState().length; g++)
						{
							for(int h = 0; h < currentBoard.getBoardState()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getBoardState()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegDown( child, i, j ); 
						currentBoard.children.add(child);

						//	System.out.println("Move down"); 
						//	Driver.printArray(child);
					}
				}
			}
		}
		return children;
	}
	
	@Override
	public int getPegsRemaining(BoardState board)
	{
		int pegsRemaining = 0; 
		for (int i = 0; i < board.getBoardState().length; i++ )
		{
			for(int j = 0; j < board.getBoardState()[i].length; j++)
			{
				if(board.getBoardState()[i][j] == 1)
				{
					pegsRemaining++; 
				}
			}
		}
		return pegsRemaining; 
	}
	public int[][] getBoardState() 
	{
		return pegPositions;
	}
}
