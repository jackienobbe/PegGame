package main;

public class Move 
{
	public BoardState initialState;
	public BoardState finalState;

	public Move(BoardState initialState, BoardState finalState)
	{
		this.initialState = initialState;
		this.finalState = finalState;
	}

	@Override 
	public String toString()
	{
		int[] move = findMove();
		int initialRow = move[0];
		int initialCol = move[1];
		int finalRow = move[2];
		int finalCol = move[3];
		return "(" + initialRow + ", " + initialCol + ") -> (" + finalRow + ", " + finalCol + ")";
	}

	private int[] findMove()
	{
		int[] move = new int[4];
		for(int i = 0; i < initialState.getPegPositions().length; i++)
		{
			for(int j = 0; j < initialState.getPegPositions()[i].length; j++)
			{
				int initialPeg = initialState.getPegPositions()[i][j];
				int finalPeg = finalState.getPegPositions()[i][j];

				if(initialPeg != finalPeg && initialPeg == 1)
				{
					move[0] = i;
					move[1] = j;
				} else if(initialPeg != finalPeg && finalPeg == 0)
				{
					move[2] = i;
					move[3] = j;
				}
			}
		}
		return move;
	}
}
