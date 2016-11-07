package main;

import java.util.Stack;

public class DepthFirstSearch extends Search 
{
	private Stack<BoardState> stack = new Stack<BoardState>();

	@Override
	public String toString() 
	{
		return "Depth First Search";
	}
	public boolean find(BoardState initialState, BoardState goalState) 
	{
		System.out.println("Searching... ");
		boolean found = false;

		stack.push(initialState);
		while (!found && !stack.empty()) 
		{
			//print every time a 10000th node is examined
			if (nodesExamined % 10000 == 0)
			{
				System.out.println(nodesExamined + " nodes examined. ");
				System.out.println("Still searching DFS... ");
			}
			
			BoardState currentState = stack.pop();
			if (!currentState.checkGoalState(currentState, goalState))
			{
				if (!closed.contains(currentState)) 
				{
					currentState.expand(currentState);
					closed.add(currentState);
					
					//add children to queue
					for( int i = 0; i < currentState.children.size(); i++ )
					{
						stack.add(currentState.children.get(i));
					}
				}
				else
				{
					loopDetectionCount();
				}	
			}

			else
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