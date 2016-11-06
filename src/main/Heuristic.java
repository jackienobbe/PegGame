package main;

public class Heuristic {
	public static int manhattanCost(BoardState board)
	{
		int value = 0;
		int manDistance = 0;

		for (int i = 0; i < board.getBoardState().length; i++) 
		{
			for (int j = 0; j < board.getBoardState()[i].length; j++) 
			{
				if( board.getBoardState()[i][j] == 1 )
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
		return evaluateCostMatrix(board, costMatrix);
	}

	private static int evaluateCostMatrix(BoardState board, int[][] costMatrix) 
	{
		int boardCost = 0;
		for (int i = 0; i < board.getBoardState().length; i++) 
		{
			for (int j = 0; j < board.getBoardState()[i].length; j++) 
			{
				if (board.getBoardState()[i][j] == 1) 
				{
					boardCost += costMatrix[i][j];
				}
			}
		}
		return boardCost;
	}


	public BoardState symmetricTransform( BoardState board )
	{

		for (int i = 0; i < board.getBoardState().length; i++) 
		{
			for (int j = 0; j < board.getBoardState()[i].length; j++) 
			{

			}
		}
		return board;
	}
}
