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
		initializeClosed(); 
		pegsRemaining = initialState.getPegsRemaining(initialState); 
		System.out.println("Searching... ");
		boolean found = false;

		stack.push(initialState);
		while (!found && !stack.empty()) 
		{
			System.out.println("Still searching... " + nodesExamined + " nodes examined.");

			BoardState currentState = stack.pop();
			currentState.getPegsRemaining(currentState);
			System.out.println("Tell me something good: " + currentState.getPegsRemaining(currentState));
 
			if (!checkGoalState(currentState, goalState))
			{
//				System.out.println("Pegs Rem again: " + pegsRemaining); 
//				System.out.println("Closed: " + closed[pegsRemaining]); 

				if (!closed[currentState.getPegsRemaining(currentState)].contains(currentState)) 
				{
					System.out.println("PegsRem: " + currentState.getPegsRemaining(currentState));
					System.out.println("Closed Contains Current? " + closed[currentState.getPegsRemaining(currentState)].contains(currentState));
					currentState.expand(currentState);
					closed[currentState.getPegsRemaining(currentState)].add(currentState);

					for( int i = 0; i < currentState.children.size(); i++ )
					{
						stack.push(currentState.children.get(i));
					}
				}
				else
				{
					System.out.println("mmm... not on closed. Stack size: " + stack.size()); 
					System.out.println("Found on closed list. Location: " + closed[currentState.getPegsRemaining(currentState)]); 
				}
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