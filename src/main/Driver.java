package main;

public class Driver 
{
	private static final int BOARD_LEFT_BOUNDARY = 1;
	private static final int BOARD_UP_BOUNDARY = 1;
	private static final int JUMP_SIZE = 2;

	static boolean checkZeroMoveRight( BoardState board, int i, int j ) 
	{
		//System.out.println("checkMoveRight: y" + i + ", x" + j );
		// check if move will be out of bounds
		if ( j < board.getPegPositions().length - JUMP_SIZE)
		{
			// check that pegs exist in the correct positions
			if( board.getPegPositions()[i][j] == 0 && 
					board.getPegPositions()[i][j + 1] == 1 && 
					board.getPegPositions()[i][j + 2] == 1 )
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
			if( board.getPegPositions()[i][j] == 0 && 
					board.getPegPositions()[i][j - 1] == 1 && 
					board.getPegPositions()[i][j - 2] == 1 )
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
			if( board.getPegPositions()[i][j] == 0 && 
					board.getPegPositions()[i - 1][j] == 1 && 
					board.getPegPositions()[i - 2][j] == 1 )
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
		if ( i < board.getPegPositions().length - JUMP_SIZE )
		{
			// check that pegs exist in the correct positions
			if( board.getPegPositions()[i][j] == 0 && 
					board.getPegPositions()[i + 1][j] == 1 && 
					board.getPegPositions()[i + 2][j] == 1 )
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
	public static BoardState movePegLeft(BoardState board, int i, int j)
	{
		board.getPegPositions()[i][j] = 1; 
		board.getPegPositions()[i][j - 1] = 0; 
		board.getPegPositions()[i][j - 2] = 0; 		

		return board; 
	}
	public static BoardState movePegUp( BoardState board, int i, int j ) 
	{
		board.getPegPositions()[i][j] = 1; 
		board.getPegPositions()[i - 1][j] = 0; 
		board.getPegPositions()[i - 2][j] = 0; 		

		return board; 
	}
	public static BoardState movePegDown( BoardState board, int i, int j ) 
	{
		board.getPegPositions()[i][j] = 1; 
		board.getPegPositions()[i + 1][j] = 0; 
		board.getPegPositions()[i + 2][j] = 0; 		

		return board; 
	}

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