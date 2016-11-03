package main;

import java.util.List;

public class Main {

	public BoardState goalBoardState; 
	
	public Main()
	{
		
	}
	public static void main(String[] args) 
	{
		// Read from fizzity file, please.
		int[][] originalBoard = {	
				{2, 2, 1, 1, 1, 2, 2},
				{2, 2, 1, 1, 1, 2, 2},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{2, 2, 1, 1, 1, 2, 2},
				{2, 2, 1, 1, 1, 2, 2}
					};
		int[][] initialStateFake1 = {	
				{2, 2, 0, 0, 0, 2, 2},
				{2, 2, 0, 0, 0, 2, 2},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{2, 2, 0, 0, 1, 2, 2},
				{2, 2, 0, 0, 0, 2, 2}
			};
		
		int[][] goalStateFake1 = {	
				{2, 2, 1, 1, 1, 2, 2},
				{2, 2, 1, 1, 1, 2, 2},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 0, 0, 1},
				{2, 2, 1, 0, 1, 2, 2},
				{2, 2, 1, 1, 1, 2, 2}
					};
		
		int[][] goalState = {	
				{2, 2, 0, 0, 0, 2, 2},
				{2, 2, 0, 0, 0, 2, 2},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{2, 2, 0, 0, 0, 2, 2},
				{2, 2, 0, 0, 0, 2, 2}
			};
		//BoardState board = new BoardState(initialStateFake1, 0); 	
		
		BoardState initialBoardState = new BoardState(initialStateFake1, 0); 			
		BoardState goalBoardState = new BoardState(goalState, 0);
		
		//System.out.println("Board Length: " + board.length);
		System.out.println("Original Board"); 
		System.out.println("------------------------"); 
		for (int i = 0; i < initialBoardState.getPegPositions().length; i++)
		{
			for (int j = 0; j < initialBoardState.getPegPositions()[i].length; j++)
			{
				System.out.print(initialBoardState.getPegPositions()[i][j] + " ");
			}
			System.out.println(" ");
		}
	
		DepthFirstSearch dfs = new DepthFirstSearch();  
		dfs.find(initialBoardState, goalBoardState); 
	}
}
