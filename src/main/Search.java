package main;

import java.util.LinkedList;
import java.util.List;

public abstract class Search 
{
	protected List<BoardState> closed = new LinkedList<BoardState>();
	protected static List<BoardState> fringe = new LinkedList<BoardState>();

	static void expand( BoardState currentBoard )
	{
		List<BoardState> children = new LinkedList<BoardState>();

		//Driver.zeroFinder(currentBoard);// an array for each state
		// loop qround the array con the zeros
		//single function
		//check the +1 +2 of the 0 x left checkleft
		//check the -1 -2 of the 0 x right so checkright
		////check the +1 +2 of the 0 y up so check up
		//check the -1 -2 of the 0 y down so check down
		//move the peg and add it's state to the children list 
		// call BoardState recursively with one of the states of the children 

		for( int i = 0; i < currentBoard.getPegPositions().length; i++ )
		{
			for ( int j = 0; j < currentBoard.getPegPositions()[i].length; j++ )
			{
				if(currentBoard.getPegPositions()[i][j] == 0)
				{
					if(Driver.checkZeroMoveRight( currentBoard, i, j ))
					{
						BoardState newPegs = null;
//						try 
//						{
//							newPegs = (BoardState) currentBoard.clone();
//							Driver.printArray(newPegs);
//						} catch (CloneNotSupportedException e) {
//							e.printStackTrace();
//						}

						//BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);
						Driver.printArray(newPegs);
						System.out.println("!!!!!"); 
						Driver.printArray(currentBoard);
						newPegs = Driver.movePegRight( newPegs, i, j ); 
						System.out.println("WOWOWOWO"); 
						Driver.printArray(currentBoard);

						children.add(newPegs);

						System.out.println("Move Right"); 
						Driver.printArray(newPegs);

						System.out.println("Curr"); 
						Driver.printArray(currentBoard);
						//Driver.replaceRight(currentBoard, i, j);

					}
					//					if(Driver.checkZeroMoveLeft( currentBoard, i, j ))
					//					{
					//						Driver.printArray(currentBoard);
					//						//int[][] newPegs = currentBoard.getPegPositions();
					//						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);
					//
					//						child = Driver.movePegLeft( currentBoard, i, j ); 
					//
					//						children.add(child);
					//
					//						//System.out.println("Move the zero left"); 
					//						Driver.printArray(child);
					//
					//						//Driver.replaceLeft(currentBoard, i, j);
					//					}

					//					if(Driver.checkZeroMoveUp( currentBoard, i, j ))
					//					{						
					//						int[][] newPegs = currentBoard.getPegPositions();
					//						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);
					//
					//						child = Driver.movePegUp( child, i, j ); 
					//
					//						children.add(child);
					//
					//						System.out.println("Move UP"); 
					//						Driver.printArray(child);
					//
					//						//Driver.replaceUp(currentBoard, i, j);
					//
					//					}

					//					if(Driver.checkZeroMoveDown( currentBoard, i, j ))
					//					{						
					//						int[][] newPegs = currentBoard.getPegPositions();
					//						BoardState child = new BoardState(newPegs, 1);  //currentBoard.getPathCost() + 1);
					//						child = Driver.movePegDown( child, i, j ); 
					//
					//						children.add(child);
					//
					//						System.out.println("Move down"); 
					//						Driver.printArray(child);
					//
					//						//Driver.replaceDown(currentBoard, i, j);
					//					}
				}
			}
		}
		//currentBoard.setBranchingFactor(children.size());
		//currentBoard.setChildren(children);

		fringe.addAll(children);
		fringe.remove(currentBoard);
		return;

	}
	public boolean checkGoalState( BoardState board, BoardState goalState)
	{
		for( int i = 0; i < board.getPegPositions().length; i++ )
		{
			for( int j = 0; j < board.getPegPositions()[i].length; j++ )
			{
				if( board.getPegPositions()[i][j] != goalState.getPegPositions()[i][j])
				{
					return false; 
				}
			}
		}
		return true; 
	}
	public abstract boolean find(BoardState initialState, BoardState goalState);
}