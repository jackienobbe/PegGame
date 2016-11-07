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
		initializeClosed(); 
		//pegsRemaining = initialState.getPegsRemaining(initialState); 
		System.out.println("Searching... ");
		boolean found = false;

		stack.push(initialState);
		while (!found && !stack.empty()) 
		{
			System.out.println("Still searching... " + nodesExamined + " nodes examined.");

			BoardState currentState = stack.pop();
			currentState.getIndex(currentState);
 
			if (!currentState.checkGoalState(currentState, goalState))
			{
				if (!closed[currentState.getIndex(currentState)].contains(currentState)) 
				{
					currentState.expand(currentState);
					closed[currentState.getIndex(currentState)].add(currentState);

					for( int i = 0; i < currentState.children.size(); i++ )
					{
						stack.push(currentState.children.get(i));
					}
				}
			}
			else
			{
				System.out.println("FOUND");
				found = true; 
			}		
			nodesExamined++; 
		}
		System.out.println(found);
		return found;
	}
}