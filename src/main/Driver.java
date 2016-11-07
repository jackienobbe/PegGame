package main;

public class Driver 
{
	public static void printArray( BoardState board )
	{
		System.out.println("------------------------"); 
		for (int k = 0; k < board.getBoardState().length; k++)
		{
			for (int g = 0; g < board.getBoardState()[k].length; g++)
			{
				System.out.print(board.getBoardState()[k][g] + " ");
			}
			System.out.println(" ");
		}	
	}

	public void runGame()
	{
		// Search.find(initial, null);
	}
	
	
}