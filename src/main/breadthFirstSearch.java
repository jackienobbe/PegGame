package main;

import java.util.LinkedList;
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

		while (!found && queue.size() != 0) 
		{
			BoardState currentState = queue.poll();
			//			System.out.println(queue.size());

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
				//System.out.println("Still searching... " + nodesExamined + " nodes expanded.");
			}
			else
			{
				System.out.println("FOUND");
				Driver.printArray(currentState);
				found = true; 
			}
			nodesExamined++; 
		}
		System.out.println(found);
		return found;
	}
}
