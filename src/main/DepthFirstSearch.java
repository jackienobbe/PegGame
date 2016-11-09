package main;

import java.util.Stack;

public class DepthFirstSearch extends Search 
{
	private Stack<BoardState> fringe = new Stack<BoardState>();

	@Override
	public String toString() 
	{
		return "Depth First Search";
	}
	public boolean find(BoardState initialState, BoardState goalState) 
	{
		boolean found = false;
		BoardState currentState = null;
		continueSearch = true; 

		fringe.push(initialState);
		System.out.println("______________________________");
		System.out.println("------------------------------");
		System.out.println("Searching Depth First... ");
		System.out.println("------------------------------");

		while(continueSearch == true)
		{
			while (!found && fringe.size() != 0 && System.currentTimeMillis() < end) 
			{
				//print every time a 10000th node is examined
				if (nodesExamined % 10000 == 0)
				{
					System.out.println(nodesExamined + " nodes examined. ");
					System.out.println("Still searching DFS... ");
				}
				currentState = fringe.pop();
				//currentState.incrementPathCost(currentState); 

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
					continueSearch = false; 
				}		
				nodesExamined++; 
			}
			if(!found)
			{
				System.out.println(" ");
				System.out.println("Solution could not be found in two minutes.");
				System.out.println("Would you like to continue searching? Y for Yes. ");
				char c = scanner.next().charAt(0);
				if (c == 'Y')
				{
					start = System.currentTimeMillis();
					end = start + 120 * 1000; // 120 seconds + 1000 ms/sec 
					System.out.println("Continuing search with DFS...");
				}
				else
				{
					continueSearch = false; 
					found = false; 
				}
			}
		}
		System.out.println(" ");
		System.out.println("DEPTH FIRST SEARCH STATS:");
		printSolution(currentState, found);
		return found;
	}
}