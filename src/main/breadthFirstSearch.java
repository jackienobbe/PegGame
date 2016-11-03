package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch extends Search 
{
	private Queue<BoardState> queue = new LinkedList<BoardState>();

	BreadthFirstSearch(){}

	@Override
	public String toString() 
	{
		return "Breadth First Search";
	}
	
	@Override
	public boolean find(BoardState initialState, BoardState goalState) 
	{
		System.out.println("Howdy."); 
		boolean found = false;

		queue.add(initialState);

		System.out.println("Searching... ");

		while (!found && queue.size() == 0) 
		{
			BoardState currentState = queue.poll();
			if (!checkGoalState(currentState, goalState, pegsRemaining))
			{
				expand(currentState);

				if (!closed.contains(currentState)) 
				{
					closed.add(currentState);

					for( int i = 0; i < currentState.children.size(); i++ )
					{
						queue.add(currentState.children.get(i));
					}
				}
				System.out.println("Still searching... " + nodesExamined + " nodes expanded.");

			}
			else
			{
				System.out.println("FOUND");
				Driver.printArray(currentState);
				found = true; 
			}
		}
		System.out.println(found);
		return found;
	}


//	public List<Move> find(BoardState initialState, BoardState goalState) {
//		queue.add(initialState);
//		BoardState previous = initialState;
//		while (!queue.isEmpty()) {
//			BoardState current = queue.poll();
//			expand(current);
//			if (!current.equals(initialState)) {
//				Move move = new Move(previous, current);
//				moves.add(move);
//			}
//			if (current.getChildren().size() == 0) {
//				return moves;
//			} else if (!closed.contains(current)) {
//				closed.add(current);
//				for (BoardState child : current.getChildren()) {
//					queue.add(child);
//				}
//			}
//		}
//		return moves;
//	}
}
