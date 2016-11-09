package main;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Search 
{
	private Queue<BoardState> fringe = new LinkedList<BoardState>();

	@Override
	public String toString() 
	{
		return "Breadth First Search";
	}

	@Override
	public boolean find(BoardState initialState, BoardState goalState) 
	{
		boolean found = false;
		BoardState currentState = null; 
		
		fringe.add(initialState);
		System.out.println("______________________________");
		System.out.println("------------------------------");
		System.out.println("Searching Breadth First... ");
		System.out.println("------------------------------");
		
		while (!found && fringe.size() != 0) 
		{
			//print every time a 10000th node is examined
			if (nodesExamined % 10000 == 0)
			{
				System.out.println(nodesExamined + " nodes examined. ");
				System.out.println("Still searching BFS... ");
			}
			
			currentState = fringe.poll();
			if (!currentState.checkGoalState(currentState, goalState))
			{
				if (!closed.contains(currentState)) 
				{
					currentState.expand(currentState);
					closed.add(currentState);
					
					//add children to queue
					for( int i = 0; i < currentState.children.size(); i++ )
					{
						fringe.add(currentState.children.get(i));
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
				System.out.println(" ");
				System.out.println("SOLUTION FOUND!");
				found = true; 
			}
			nodesExamined++; 
		}
		System.out.println(" ");
		System.out.println("BREADTH FIRST SEARCH STATS:");
		printSolution(currentState, found);
		return found;
	}
}