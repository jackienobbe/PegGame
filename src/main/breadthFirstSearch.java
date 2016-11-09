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
		continueSearch = true; 

		fringe.add(initialState);
		System.out.println("______________________________");
		System.out.println("------------------------------");
		System.out.println("Searching Breadth First... ");
		System.out.println("------------------------------");

		while(continueSearch == true)
		{
			while (!found && fringe.size() != 0 && System.currentTimeMillis() < end) 
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
					continueSearch = false; 
				}
				nodesExamined++; 
			}
			if(!found)
			{
				System.out.println(" ");
				System.out.println("Solution could not be found in a short time.");
				System.out.println("Would you like to continue searching? Y for Yes. ");
				char c = scanner.next().charAt(0);
				if (c == 'Y')
				{
					start = System.currentTimeMillis();
					end = start + 120 * 1000; // 120 seconds + 1000 ms/sec 
					System.out.println("Continuing search with BFS...");
				}
				else
				{
					continueSearch = false; 
					found = false; 
				}
			}
		}
		System.out.println(" ");
		System.out.println("BREADTH FIRST SEARCH STATS:");
		printSolution(currentState, found);
		return found;
	}
}