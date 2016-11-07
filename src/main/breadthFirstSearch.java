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
		boolean found = false;

		queue.add(initialState);

		System.out.println("Searching... ");

		while (!found && queue.size() != 0) 
		{
			//print every time a 10000th node is examined
			if (nodesExamined % 10000 == 0)
			{
				System.out.println(nodesExamined + " nodes examined. ");
				System.out.println("Still searching BFS... ");
			}
			
			BoardState currentState = queue.poll();
			if (!currentState.checkGoalState(currentState, goalState))
			{
				if (!closed.contains(currentState)) 
				{
					currentState.expand(currentState);
					closed.add(currentState);
					
					//add children to queue
					for( int i = 0; i < currentState.children.size(); i++ )
					{
						queue.add(currentState.children.get(i));
					}
				}
				else
				{
					//Found on closed list, so increment number of loops detected
					loopDetectionCount();
				}
			}
			else // SOLUTION FOUND!
			{
				found = true; 
				
				System.out.println("Path backwards to Initial State:");
				System.out.println("--------------------------------");

				while(currentState != null)
				{
					Driver.printArray(currentState);
					currentState = currentState.parent;
				}
				System.out.println("^^ Path to Goal State!");

			}
			nodesExamined++; 
		}
		System.out.println("SEARCH STATS:");
		System.out.println("--------------------------------");
		System.out.println("Search used: Depth First Search");
		System.out.println("Solution found:" + found);
		System.out.println("Nodes Expanded: " + nodesExamined);
		System.out.println("Loops Detected: " + getLoopsDetected());
		
		return found;
	}
}