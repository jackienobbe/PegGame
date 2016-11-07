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
		BoardState currentState = null;
		
		stack.push(initialState);
		while (!found && !stack.empty()) 
		{
			//print every time a 10000th node is examined
			if (nodesExamined % 10000 == 0)
			{
				System.out.println(nodesExamined + " nodes examined. ");
				System.out.println("Still searching DFS... ");
			}
			//System.out.println(currentState);
			currentState = stack.pop();
			//System.out.println("Canns: " + ((MCBoardState) currentState).getCannibals());

			if (!currentState.checkGoalState(currentState, goalState))
			{
				//System.out.println("next tgought");

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
					//Found on closed list, so increment number of loops detected
					loopDetectionCount();
				}	
			}
			else // SOLUTION FOUND!
			{
				found = true; 
			}		
			nodesExamined++; 
		}
		printSolution(currentState, found); 
		return found;
	}
}