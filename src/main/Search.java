package main;

import java.util.LinkedList;
import java.util.List;

public abstract class Search 
{
	protected List<BoardState> closed = new LinkedList<BoardState>();
	protected static List<BoardState> fringe = new LinkedList<BoardState>();
	//protected static List<BoardState> children = new LinkedList<BoardState>();
	static int pegsRemaining;// = 0; 
	static int nodesExamined;

	static List<BoardState> expand( BoardState currentBoard )
	{
		pegsRemaining = 0; 
		for( int i = 0; i < currentBoard.getPegPositions().length; i++ )
		{
			for ( int j = 0; j < currentBoard.getPegPositions()[i].length; j++ )
			{
				if(currentBoard.getPegPositions()[i][j] == 0)
				{
					if(Driver.checkZeroMoveRight( currentBoard, i, j ))
					{						
						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegRight( child, i, j ); 
						currentBoard.children.add(child);

						//						System.out.println("Move Right"); 
						//						Driver.printArray(child);

					}

					if(Driver.checkZeroMoveUp( currentBoard, i, j ))
					{						
						//System.out.println("here"); 

						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegUp( child, i, j ); 
						currentBoard.children.add(child);

						//						System.out.println("Move UP"); 
						//						Driver.printArray(child);
					}
					if(Driver.checkZeroMoveLeft( currentBoard, i, j ))
					{
						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegLeft( child, i, j ); 
						currentBoard.children.add(child);

						//						System.out.println("Move left"); 
						//						Driver.printArray(child);
					}
					if(Driver.checkZeroMoveDown( currentBoard, i, j ))
					{						
						int[][] newPegs = new int[currentBoard.getPegPositions().length][currentBoard.getPegPositions().length];
						for( int g = 0; g < currentBoard.getPegPositions().length; g++)
						{
							for(int h = 0; h < currentBoard.getPegPositions()[g].length; h++)
							{
								newPegs[g][h] = currentBoard.getPegPositions()[g][h];
							}
						}
						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);

						child = Driver.movePegDown( child, i, j ); 
						currentBoard.children.add(child);

						//						System.out.println("Move down"); 
						//						Driver.printArray(child);
					}
				}
				else if (currentBoard.getPegPositions()[i][j] == 1)
				{
					pegsRemaining++; 
				}
			}
		}
		//currentBoard.setBranchingFactor(children.size());
		//currentBoard.setChildren(children);
		//		System.out.println("children");
		//		for(int s=0;s<children.size();s++){
		//		    System.out.println(children.get(s));
		//		} 

		fringe.addAll(currentBoard.children);	
		fringe.remove(currentBoard);
		if (pegsRemaining < 7)
		{
			System.out.println("Pegs Remaining: " + pegsRemaining);
		}
		nodesExamined++; 
		return currentBoard.children;
	}
	public boolean checkGoalState( BoardState board, BoardState goalState, int pegsRemaining )
	{
		if ( pegsRemaining == 1)
		{
			System.out.println("Wiennnerrrrrr");
			return true; 
		}
		for( int i = 0; i < board.getPegPositions().length; i++ )
		{
			for( int j = 0; j < board.getPegPositions()[i].length; j++ )
			{
				if( board.getPegPositions()[i][j] != goalState.getPegPositions()[i][j])
				{
					//System.out.println("NOT GOAL");
					return false; 
				}
			}
		}
		System.out.println("GOOOOALLLLLLLL");
		return true; 
	}
	public abstract boolean find(BoardState initialState, BoardState goalState);
}