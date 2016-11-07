package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public BoardState goalBoardState; 

	public static void main(String[] args) 
	{

		Scanner scanner;
		try 
		{
			scanner = new Scanner(new File("PegSolInput.txt"));
			//System.out.print(scanner);
			String gameType; 
			gameType = scanner.next();
			System.out.println(gameType);
			
			
			if(gameType.equals("PS"))
			{
				System.out.println("Made it.");
				int boardDimensions = 0; 
				while(scanner.hasNextInt())
				{
					boardDimensions++; 
					System.out.println(boardDimensions);
				}
				int [][] gameBoard = new int[(int) Math.sqrt(boardDimensions)][(int) Math.sqrt(boardDimensions)];
				int i = 0;
				while(scanner.hasNextInt())
				{
					for(i = 0; i < Math.sqrt(boardDimensions); i++)
					{
						for(int j = 0; j < Math.sqrt(boardDimensions); j++)
						{
							gameBoard[i][j] = scanner.nextInt();
							System.out.println(gameBoard[i][j]);
						}
					}
				}
			}
			if(gameType.equals("MC"))
			{
				int[] gameBoard = new int[3];
				int i = 0; 
				while(scanner.hasNextInt())
				{
					gameBoard[i++] = scanner.nextInt(); 
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
			{2, 2, 1, 1, 0, 2, 2},
			{2, 2, 0, 0, 0, 2, 2}
	};
	int[][] initialStateFake2 = {	
			{2, 2, 0, 1, 1, 2, 2},
			{2, 2, 0, 1, 1, 2, 2},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 1, 0, 1, 1},
			{0, 1, 1, 1, 1, 0, 1},
			{2, 2, 0, 1, 0, 2, 2},
			{2, 2, 0, 0, 0, 2, 2}
	};
	int[][] initialStateFake3 = {	
			{2, 2, 0, 1, 1, 2, 2},
			{2, 2, 1, 1, 0, 2, 2},
			{1, 1, 0, 0, 0, 1, 0},
			{1, 0, 0, 1, 0, 1, 1},
			{0, 1, 0, 1, 0, 0, 1},
			{2, 2, 0, 0, 0, 2, 2},
			{2, 2, 0, 0, 0, 2, 2}
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

	int[] mcInitial = {3,3,1}; 
	int[] mcGoal = {0,0,1}; 

	//	BoardState initialBoardState = new PegSolBoardState(initialStateFake1, 0); 	
	//BoardState initialBoardState = new PegSolBoardState(initialStateFake2, 0); 	
	//BoardState initialBoardState = new PegSolBoardState(initialStateFake3, 0); 	

	//BoardState initialBoardState = new PegSolBoardState(originalBoard, 0); 			
	//	BoardState goalBoardState = new PegSolBoardState(goalState, 0);

	//		BoardState initialBoardState = new MCBoardState(mcInitial, 0); 			
	//		BoardState goalBoardState = new MCBoardState(mcGoal, 0);


	//System.out.println("Board Length: " + board.length);
	//	System.out.println("Original Board"); 
	//	System.out.println("------------------------"); 
	//		for (int i = 0; i < initialBoardState.getBoardState().length; i++)
	//		{
	//			for (int j = 0; j < initialBoardState.getBoardState()[i].length; j++)
	//			{
	//				System.out.print(initialBoardState.getBoardState()[i][j] + " ");
	//			}
	//			System.out.println(" ");
	//		}


	//	DepthFirstSearch dfs = new DepthFirstSearch();  
	//	dfs.find(initialBoardState, goalBoardState); 

	//		BreadthFirstSearch bfs = new BreadthFirstSearch();  
	//		bfs.find(initialBoardState, goalBoardState); 

	//		GreedyBestFirstSearch gbf = new GreedyBestFirstSearch(); 
	//		gbf.setGoalPosition(goalBoardState); 
	//		gbf.find(initialBoardState, goalBoardState); 

}

