package main;

public class Heuristic {
	public static int manhattanCost(BoardState board)
	{
		int value = 0;
		int manDistance = 0;
	
		for (int i = 0; i < board.getPegPositions().length; i++) 
		{
			for (int j = 0; j < board.getPegPositions()[i].length; j++) 
			{
				if( board.getPegPositions()[i][j] == 1 )
				{
					manDistance = Math.abs(i - Search.getGoalPosition()[0]) + Math.abs(j - Search.getGoalPosition()[1]);
					value += manDistance;
					//System.out.println("Hi. I have value. I am worth: " + value);
				}
			}
		}
		return value;
	}
}
