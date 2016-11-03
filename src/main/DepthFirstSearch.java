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
		//BoardState previous = initialState;
		while (!found && !stack.empty()) 
		{
			BoardState currentState = stack.pop();

			if (!checkGoalState(currentState, goalState, pegsRemaining))
			{
				expand(currentState);
			
				if (!closed.contains(currentState)) 
				{
					closed.add(currentState);
					
					for( int i = 0; i < currentState.children.size(); i++ )
					{
						stack.push(currentState.children.get(i));
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

}