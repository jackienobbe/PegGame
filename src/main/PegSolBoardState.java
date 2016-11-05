package main;

import java.util.List;

public class PegSolBoardState extends BoardState
{
	int[][] pegPositions;
	int pathCost; 

	private static int pegsRemaining;
	public PegSolBoardState( int[][] pegPositions, int level )
	{
		this.pegPositions = pegPositions; 
		this.pathCost = pathCost; 
	}
	
	public List<BoardState> expand( BoardState currentBoard )
	{
		pegsRemaining = 0; 
		for( int i = 0; i < currentBoard.getPegPositions().length; i++ )
		{
			for ( int j = 0; j < currentBoard.getPegPositions()[i].length; j++ )
			{
				if(currentBoard.getPegPositions()[i][j] == 0)
				{
					if(Driver.checkZeroMoveRight( currentBoard, i, j ))
					{				
						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
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

						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegUp( child, i, j ); 
						currentBoard.children.add(child);

						//						System.out.println("Move UP"); 
						//						Driver.printArray(child);
					}
					if(Driver.checkZeroMoveLeft( currentBoard, i, j ))
					{
						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegLeft( child, i, j ); 
						currentBoard.children.add(child);

						//						System.out.println("Move left"); 
						//						Driver.printArray(child);
					}
					if(Driver.checkZeroMoveDown( currentBoard, i, j ))
					{						
						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegDown( child, i, j ); 
						currentBoard.children.add(child);

						//	System.out.println("Move down"); 
						//	Driver.printArray(child);
					}
				}
				else if (currentBoard.getPegPositions()[i][j] == 1)
				{
					pegsRemaining++; 
				}
			}
		}
		return children;
	}
	
	public int[][] getPegPositions() 
	{
		return pegPositions;
	}

}
