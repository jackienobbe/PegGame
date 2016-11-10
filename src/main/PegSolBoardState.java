package main;

import java.util.List;

public class PegSolBoardState extends BoardState
{
	private static final int STEP_COST = 1; 
	private static final int BOARD_LEFT_BOUNDARY = 1;
	private static final int BOARD_UP_BOUNDARY = 1;
	private static final int JUMP_SIZE = 2;

	int[][] pegPositions;
	int pathCost; 

	/**
	 * Peg Solitaire board state constructor
	 * @param pegPositions matrix of peg positions
	 */
	public PegSolBoardState( int[][] pegPositions )
	{
		this.pegPositions = pegPositions; 
		//this.pathCost = pathCost; 
		for(int i = 0; i < pegPositions.length; i++)
		{
			for(int j = 0; j < pegPositions[i].length; j++)
			{
				if(pegPositions[i][j] == 1)
				{
					Search.pegsRemaining++;  
				}
			}
		}
	}

	/***
	 * Successor function. Spawns children nodes based on the possible
	 * moves of the current state.
	 */
	@Override
	public List<BoardState> expand( BoardState currentBoard )
	{
		for( int i = 0; i < ((PegSolBoardState) currentBoard).getBoardState().length; i++ )
		{
			for ( int j = 0; j < ((PegSolBoardState) currentBoard).getBoardState()[i].length; j++ )
			{
				if(((PegSolBoardState) currentBoard).getBoardState()[i][j] == 0)
				{
					if(checkZeroMoveDown( currentBoard, i, j ))
					{						
						int[][] newPegs = new int[((PegSolBoardState) currentBoard).getBoardState().length][((PegSolBoardState) currentBoard).getBoardState().length];
						for( int g = 0; g < ((PegSolBoardState) currentBoard).getBoardState().length; g++)
						{
							for(int h = 0; h < ((PegSolBoardState) currentBoard).getBoardState()[g].length; h++)
							{
								newPegs[g][h] = ((PegSolBoardState) currentBoard).getBoardState()[g][h];
							}
						}
						BoardState child = new PegSolBoardState(newPegs);  //currentBoard.getPathCost() + 1);

						child = movePegDown( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

						//						System.out.println("Move down"); 
						//						Driver.printArray(child);
					}

					if(checkZeroMoveRight( currentBoard, i, j ))
					{				
						BoardState child = makeChild(currentBoard);

						child = movePegRight( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

						//						System.out.println("Move Right"); 
						//						Driver.printArray(child);
					}

					if(checkZeroMoveLeft( currentBoard, i, j ))
					{
						BoardState child = makeChild(currentBoard);

						child = movePegLeft( child, i, j ); 
						currentBoard.children.add(child);
						child.parent = currentBoard; 

						//						System.out.println("Move left"); 
						//						Driver.printArray(child);
					}
					if(checkZeroMoveUp( currentBoard, i, j ))
					{						
						//System.out.println("here"); 

						//						int[][] newPegs = new int[currentBoard.getBoardState().length][currentBoard.getBoardState().length];
						//						for( int g = 0; g < currentBoard.getBoardState().length; g++)
						//						{
						//							for(int h = 0; h < currentBoard.getBoardState()[g].length; h++)
						//							{
						//								newPegs[g][h] = currentBoard.getBoardState()[g][h];
						//							}
						//						}
						//						BoardState child = new PegSolBoardState(makeChild(currentBoard), 1);  //currentBoard.getPathCost() + 1);
						BoardState child = makeChild(currentBoard);

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

	/***
	 * Creates a copy of the current board to do work on
	 * @param currentBoard
	 * @return copy of currentBoard
	 */
	private BoardState makeChild(BoardState currentBoard) 
	{
		int[][] newPegs = new int[((PegSolBoardState) currentBoard).getBoardState().length][((PegSolBoardState) currentBoard).getBoardState().length];
		for( int g = 0; g < ((PegSolBoardState) currentBoard).getBoardState().length; g++)
		{
			for(int h = 0; h < ((PegSolBoardState) currentBoard).getBoardState()[g].length; h++)
			{
				newPegs[g][h] = ((PegSolBoardState) currentBoard).getBoardState()[g][h];
			}
		}
		BoardState child = new PegSolBoardState(newPegs);  //currentBoard.getPathCost() + 1);
		return child;
	}

	/**
	 * Check if move possible to the right
	 * @param board current game state
	 * @param i y position of peg in question
	 * @param j x position of peg in question
	 * @return if move possible
	 */
	boolean checkZeroMoveRight( BoardState board, int i, int j ) 
	{
		//System.out.println("checkMoveRight: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( j < ((PegSolBoardState) board).getBoardState().length - JUMP_SIZE)
		{
			// check that pegs exist in the correct positions
			if( ((PegSolBoardState) board).getBoardState()[i][j] == 0 && 
					((PegSolBoardState) board).getBoardState()[i][j + 1] == 1 && 
					((PegSolBoardState) board).getBoardState()[i][j + 2] == 1 )
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
			if( ((PegSolBoardState) board).getBoardState()[i][j] == 0 && 
					((PegSolBoardState) board).getBoardState()[i][j - 1] == 1 && 
					((PegSolBoardState) board).getBoardState()[i][j - 2] == 1 )
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
		if ( i < ((PegSolBoardState) board).getBoardState().length - JUMP_SIZE )
		{
			// check that pegs exist in the correct positions
			if( ((PegSolBoardState) board).getBoardState()[i][j] == 0 && 
					((PegSolBoardState) board).getBoardState()[i + 1][j] == 1 && 
					((PegSolBoardState) board).getBoardState()[i + 2][j] == 1 )
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
			if( ((PegSolBoardState) board).getBoardState()[i][j] == 0 && 
					((PegSolBoardState) board).getBoardState()[i - 1][j] == 1 && 
					((PegSolBoardState) board).getBoardState()[i - 2][j] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}


	public static BoardState movePegRight( BoardState board, int i, int j ) 
	{
		((PegSolBoardState) board).getBoardState()[i][j] = 1; 
		((PegSolBoardState) board).getBoardState()[i][j + 1] = 0; 
		((PegSolBoardState) board).getBoardState()[i][j + 2] = 0; 		

		return board;
	}
	public static BoardState movePegLeft(BoardState board, int i, int j)
	{
		((PegSolBoardState) board).getBoardState()[i][j] = 1; 
		((PegSolBoardState) board).getBoardState()[i][j - 1] = 0; 
		((PegSolBoardState) board).getBoardState()[i][j - 2] = 0; 		

		return board; 
	}
	public static BoardState movePegUp( BoardState board, int i, int j ) 
	{
		((PegSolBoardState) board).getBoardState()[i][j] = 1; 
		((PegSolBoardState) board).getBoardState()[i - 1][j] = 0; 
		((PegSolBoardState) board).getBoardState()[i - 2][j] = 0; 		

		return board; 
	}
	public static BoardState movePegDown( BoardState board, int i, int j ) 
	{
		((PegSolBoardState) board).getBoardState()[i][j] = 1; 
		((PegSolBoardState) board).getBoardState()[i + 1][j] = 0; 
		((PegSolBoardState) board).getBoardState()[i + 2][j] = 0; 		

		return board; 
	}


	public int[][] getBoardState() 
	{
		return pegPositions;
	}

	public void printGameInfo(BoardState board)
	{
		//if (board instanceof PegSolBoardState)
		{
			System.out.println(" "); 
			System.out.println("The following grids represent states ");
			System.out.println("of the peg solitaire game. A 0 represents");
			System.out.println("a hole, a 1 represents a peg, and a 2 ");
			System.out.println("represents a position out of bounds.") ; 
			System.out.println(" "); 
		}
	}
	public void printState(BoardState board)
	{
		if (board instanceof PegSolBoardState)
		{
			System.out.println("------------------------"); 
			for (int k = 0; k < ((PegSolBoardState) board).getBoardState().length; k++)
			{
				for (int g = 0; g < ((PegSolBoardState) board).getBoardState()[k].length; g++)
				{
					System.out.print(((PegSolBoardState) board).getBoardState()[k][g] + " ");
				}
				System.out.println(" ");
			}
		}
	}

	public boolean checkGoalState( BoardState board, BoardState goalState )
	{

		for( int i = 0; i < ((PegSolBoardState) board).getBoardState().length; i++ )
		{
			for( int j = 0; j < ((PegSolBoardState) board).getBoardState()[i].length; j++ )
			{
				if( ((PegSolBoardState) board).getBoardState()[i][j] != ((PegSolBoardState) goalState).getBoardState()[i][j])
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
			for(int i = 0; i < ((PegSolBoardState) board).getBoardState().length; i++)
			{
				for(int j = 0; j < ((PegSolBoardState) board).getBoardState()[i].length; j++)
				{
					if(this.pegPositions[i][j] != ((PegSolBoardState) board).getBoardState()[i][j])
					{
						return false;
					}
				}
			}
			return true;
		}  
		else return false; 
	}
	
	public static int manhattanCost(BoardState board)
	{
		int value = 0;
		int manDistance = 0;

		for (int i = 0; i < ((PegSolBoardState) board).getBoardState().length; i++) 
		{
			for (int j = 0; j < ((PegSolBoardState) board).getBoardState()[i].length; j++) 
			{
				if( ((PegSolBoardState) board).getBoardState()[i][j] == 1 )
				{
					manDistance = Math.abs(i - Search.getGoalPosition()[0]) + Math.abs(j - Search.getGoalPosition()[1]);
					value += manDistance;
					//System.out.println("Hi. I have value. I am worth: " + value);
				}
			}
		}
		return value;
	}
	public static int weightedCost(BoardState board) 
	{
		int[][] costMatrix =  new int[][]{ 
			{ 0, 0, 4, 0, 4, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 4, 0, 3, 0, 3, 0, 4 },
			{ 0, 0, 0, 1, 0, 0, 0 }, 
			{ 4, 0, 3, 0, 3, 0, 4 },
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 4, 0, 4, 0, 0 }}; 
		return evaluateCost(board, costMatrix);
	}

	private static int evaluateCost(BoardState board, int[][] costMatrix) 
	{
		int boardCost = 0;
		for (int i = 0; i < ((PegSolBoardState) board).getBoardState().length; i++) 
		{
			for (int j = 0; j < ((PegSolBoardState) board).getBoardState()[i].length; j++) 
			{
				if (((PegSolBoardState) board).getBoardState()[i][j] == 1) 
				{
					boardCost += (costMatrix[i][j] / 4);
				}
			}
		}
		return boardCost;
	}

	@Override
	public int getHeuristicCost(BoardState board) 
	{
		return weightedCost(board);
	}
	@Override
	public int getHeuristicValue(BoardState board) 
	{
		return manhattanCost(board);
	}

	public int incrementPathCost(BoardState board)
	{
		return board.pathCost + STEP_COST; 
	}
	public int getPathCost(BoardState board) 
	{
		return board.pathCost;
	}
}