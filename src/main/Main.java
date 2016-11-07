package main;

public class Main 
{
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

//		int[] mcInitial = {3,3,1}; 
//		int[] mcGoal = {0,0,1}; 

		//BoardState initialBoardState = new PegSolBoardState(initialStateFake1, 0); 	
		BoardState initialBoardState = new PegSolBoardState(initialStateFake2, 0); 	
		//BoardState initialBoardState = new PegSolBoardState(initialStateFake3, 0); 	

		//BoardState initialBoardState = new PegSolBoardState(originalBoard, 0); 			
		BoardState goalBoardState = new PegSolBoardState(goalState, 0);

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


//		DepthFirstSearch dfs = new DepthFirstSearch();  
//		dfs.find(initialBoardState, goalBoardState); 

				BreadthFirstSearch bfs = new BreadthFirstSearch();  
				bfs.find(initialBoardState, goalBoardState); 

		//		GreedyBestFirstSearch gbf = new GreedyBestFirstSearch(); 
		//		gbf.setGoalPosition(goalBoardState); 
		//		gbf.find(initialBoardState, goalBoardState); 

	}
}

