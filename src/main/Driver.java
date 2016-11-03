package main;

public class Driver 
{

	private static final int BOARD_LEFT_BOUNDARY = 1;
	private static final int BOARD_UP_BOUNDARY = 1;
	private static final int JUMP_SIZE = 2;


	static boolean checkZeroMoveRight( BoardState currentBoard, int i, int j ) 
	{
		//System.out.println("checkMoveRight: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( j < currentBoard.getPegPositions().length - JUMP_SIZE)
		{
			// check that pegs exist in the correct positions
			if( currentBoard.getPegPositions()[i][j] == 0 && 
					currentBoard.getPegPositions()[i][j + 1] == 1 && 
					currentBoard.getPegPositions()[i][j + 2] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}
	//rename checkZeroMoveLeft
	static boolean checkZeroMoveLeft( BoardState currentBoard, int i, int j ) 
	{
		//System.out.println("checkMoveLeft: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( j > BOARD_LEFT_BOUNDARY )
		{
			// check that pegs exist in the correct positions
			if( currentBoard.getPegPositions()[i][j] == 0 && 
					currentBoard.getPegPositions()[i][j - 1] == 1 && 
					currentBoard.getPegPositions()[i][j - 2] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}
	static boolean checkZeroMoveUp( BoardState currentBoard, int i, int j ) 
	{
		//System.out.println("checkMoveUp: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( i > BOARD_UP_BOUNDARY)
		{
			// check that pegs exist in the correct positions
			if( currentBoard.getPegPositions()[i][j] == 0 && 
					currentBoard.getPegPositions()[i - 1][j] == 1 && 
					currentBoard.getPegPositions()[i - 2][j] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}
	static boolean checkZeroMoveDown( BoardState currentBoard, int i, int j ) 
	{
		//System.out.println("checkMoveDown: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( i < currentBoard.getPegPositions().length - JUMP_SIZE )
		{
			// check that pegs exist in the correct positions
			if( currentBoard.getPegPositions()[i][j] == 0 && 
					currentBoard.getPegPositions()[i + 1][j] == 1 && 
					currentBoard.getPegPositions()[i + 2][j] == 1 )
			{
				return true; 
			}
		}
		return false; 
	}

	public static BoardState movePegRight( BoardState board, int i, int j ) 
	{
		board.getPegPositions()[i][j] = 1; 
		board.getPegPositions()[i][j + 1] = 0; 
		board.getPegPositions()[i][j + 2] = 0; 		

		return board;
	}
	public static BoardState movePegLeft(BoardState currentBoard, int i, int j)
	{
		currentBoard.getPegPositions()[i][j] = 1; 
		currentBoard.getPegPositions()[i][j - 1] = 0; 
		currentBoard.getPegPositions()[i][j - 2] = 0; 		

		return currentBoard; 
	}
	public static BoardState movePegUp( BoardState currentBoard, int i, int j ) 
	{
		currentBoard.getPegPositions()[i][j] = 1; 
		currentBoard.getPegPositions()[i - 1][j] = 0; 
		currentBoard.getPegPositions()[i - 2][j] = 0; 		

		return currentBoard; 
	}
	public static BoardState movePegDown( BoardState currentBoard, int i, int j ) 
	{
		currentBoard.getPegPositions()[i][j] = 1; 
		currentBoard.getPegPositions()[i + 1][j] = 0; 
		currentBoard.getPegPositions()[i + 2][j] = 0; 		

		return currentBoard; 
	}

	public static BoardState replaceRight(BoardState currentBoard, int i, int j) 
	{
		currentBoard.getPegPositions()[i][j] = 0; 
		currentBoard.getPegPositions()[i][j - 1] = 1; 
		currentBoard.getPegPositions()[i][j - 2] = 1; 		

		return currentBoard; 
	}
	public static BoardState replaceLeft(BoardState currentBoard, int i, int j) 
	{
		currentBoard.getPegPositions()[i][j] = 0; 
		currentBoard.getPegPositions()[i][j + 1] = 1; 
		currentBoard.getPegPositions()[i][j + 2] = 1; 		

		return currentBoard;
	}
	public static BoardState replaceUp( BoardState currentBoard, int i, int j ) 
	{
		currentBoard.getPegPositions()[i][j] = 0; 
		currentBoard.getPegPositions()[i + 1][j] = 1; 
		currentBoard.getPegPositions()[i + 2][j] = 1; 		

		return currentBoard; 
	}
	public static BoardState replaceDown( BoardState currentBoard, int i, int j ) 
	{
		currentBoard.getPegPositions()[i][j] = 0; 
		currentBoard.getPegPositions()[i - 1][j] = 1; 
		currentBoard.getPegPositions()[i - 2][j] = 1; 		

		return currentBoard; 
	}

	//	public static int[] zeroFinder( BoardState currentBoard)
	//	{
	//		int[] zeroPlaces = new int[62];
	//		for( int i = 0; i < 7; i++ ) 
	//		{
	//			for ( int j = 0; j < 7; j++ )
	//			{
	//				if (currentBoard.getPegPositions()[i][j] == 0)
	//				{
	//					zeroPlaces[i]=i;
	//					zeroPlaces[i+1]=j;
	//				}
	//			}
	//		}
	//		return zeroPlaces;
	//	}

	public static void printArray( BoardState board )
	{
		System.out.println("------------------------"); 
		for (int k = 0; k < board.getPegPositions().length; k++)
		{
			for (int g = 0; g < board.getPegPositions()[k].length; g++)
			{
				System.out.print(board.getPegPositions()[k][g] + " ");
			}
			System.out.println(" ");
		}	
	}

	public void runGame()
	{
		// Search.find(initial, null);
	}
	

}