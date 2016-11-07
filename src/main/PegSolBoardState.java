package main;

import java.util.List;

public class PegSolBoardState extends BoardState
{
	int[][] pegPositions;
	int pathCost; 

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
					if(checkZeroMoveDown( currentBoard, i, j ))
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

						child = movePegDown( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

//						System.out.println("Move down"); 
//						Driver.printArray(child);
					}
					
					if(checkZeroMoveRight( currentBoard, i, j ))
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

						child = movePegRight( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

//						System.out.println("Move Right"); 
//						Driver.printArray(child);
					}

					
					if(checkZeroMoveLeft( currentBoard, i, j ))
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

						child = movePegLeft( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

//						System.out.println("Move left"); 
//						Driver.printArray(child);
					}
					if(checkZeroMoveUp( currentBoard, i, j ))
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

						child = movePegUp( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

//						System.out.println("Move UP"); 
//						Driver.printArray(child);
					}
				}
			}
		}
		return children;
	}

	private static final int BOARD_LEFT_BOUNDARY = 1;
	private static final int BOARD_UP_BOUNDARY = 1;
	private static final int JUMP_SIZE = 2;

	static boolean checkZeroMoveRight( BoardState board, int i, int j ) 
	{
		//System.out.println("checkMoveRight: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( j < board.getBoardState().length - JUMP_SIZE)
		{
			// check that pegs exist in the correct positions
			if( board.getBoardState()[i][j] == 0 && 
					board.getBoardState()[i][j + 1] == 1 && 
					board.getBoardState()[i][j + 2] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}
	static boolean checkZeroMoveLeft( BoardState board, int i, int j ) 
	{
		//System.out.println("checkMoveLeft: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( j > BOARD_LEFT_BOUNDARY )
		{
			// check that pegs exist in the correct positions
			if( board.getBoardState()[i][j] == 0 && 
					board.getBoardState()[i][j - 1] == 1 && 
					board.getBoardState()[i][j - 2] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}
	static boolean checkZeroMoveUp( BoardState board, int i, int j ) 
	{
		// check if move will be out of bounds
		if ( i > BOARD_UP_BOUNDARY)
		{
			// check that pegs exist in the correct positions
			if( board.getBoardState()[i][j] == 0 && 
					board.getBoardState()[i - 1][j] == 1 && 
					board.getBoardState()[i - 2][j] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}
	static boolean checkZeroMoveDown( BoardState board, int i, int j ) 
	{
		//System.out.println("checkMoveDown: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( i < board.getBoardState().length - JUMP_SIZE )
		{
			// check that pegs exist in the correct positions
			if( board.getBoardState()[i][j] == 0 && 
					board.getBoardState()[i + 1][j] == 1 && 
					board.getBoardState()[i + 2][j] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}

	public static BoardState movePegRight( BoardState board, int i, int j ) 
	{
		board.getBoardState()[i][j] = 1; 
		board.getBoardState()[i][j + 1] = 0; 
		board.getBoardState()[i][j + 2] = 0; 		

		return board;
	}
	public static BoardState movePegLeft(BoardState board, int i, int j)
	{
		board.getBoardState()[i][j] = 1; 
		board.getBoardState()[i][j - 1] = 0; 
		board.getBoardState()[i][j - 2] = 0; 		

		return board; 
	}
	public static BoardState movePegUp( BoardState board, int i, int j ) 
	{
		board.getBoardState()[i][j] = 1; 
		board.getBoardState()[i - 1][j] = 0; 
		board.getBoardState()[i - 2][j] = 0; 		

		return board; 
	}
	public static BoardState movePegDown( BoardState board, int i, int j ) 
	{
		board.getBoardState()[i][j] = 1; 
		board.getBoardState()[i + 1][j] = 0; 
		board.getBoardState()[i + 2][j] = 0; 		

		return board; 
	}

	public int getIndex(BoardState board)
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

	public boolean checkGoalState( BoardState board, BoardState goalState )
	{
		
		for( int i = 0; i < board.getBoardState().length; i++ )
		{
			for( int j = 0; j < board.getBoardState()[i].length; j++ )
			{
				if( board.getBoardState()[i][j] != goalState.getBoardState()[i][j])
				{
					//System.out.println("NOT GOAL");
					return false; 
				}
			}
		}
		return true; 
	}
	public boolean equals(Object o)
	{
		if(o instanceof PegSolBoardState)
		{
			BoardState board = (PegSolBoardState)o;
			for(int i = 0; i < board.getBoardState().length; i++)
			{
				for(int j = 0; j < board.getBoardState()[i].length; j++)
				{
					if(this.pegPositions[i][j] != board.getBoardState()[i][j])
					{
						return false;
					}
				}
			}
			return true;
		}  
		else return false; 
	}
}