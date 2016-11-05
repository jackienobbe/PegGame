package main;

import java.util.Stack;

public class DepthFirstSearch extends Search 
{
	private Stack<BoardState> stack = new Stack<BoardState>();

	DepthFirstSearch(){}

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
			BoardState currentState = stack.pop();
			//Driver.printArray(currentState);
			//System.out.println(currentState); 
			if (!checkGoalState(currentState, goalState, pegsRemaining))
			{
				//System.out.println(closed.contains(currentState));
				if (!closed.contains(currentState)) 
				{
					expand(currentState);
					closed.add(currentState);

					for( int i = 0; i < currentState.children.size(); i++ )
					{
						stack.push(currentState.children.get(i));
					}
				}
			}
			else
			{
				System.out.println("FOUND");
				Driver.printArray(currentState);
				found = true; 
			}				
			nodesExamined++; 
			//System.out.println("Still searching... " + nodesExamined + " nodes examined.");

		}
		System.out.println(found);
		return found;
	}

}