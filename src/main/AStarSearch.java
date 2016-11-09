package main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch extends Search 
{
	PQsort pqs = new PQsort();
	PriorityQueue<BoardState> fringe = new PriorityQueue<BoardState>(10, pqs);

	@Override
	public boolean find(BoardState initialState, BoardState goalState) 
	{
		boolean found = false; 
		BoardState best = null; 

		fringe.add(initialState);
		System.out.println("______________________________");
		System.out.println("------------------------------");
		System.out.println("Searching A*... ");
		System.out.println("------------------------------");
		while (!found && !fringe.isEmpty() ) 
		{
			//print every time a 10000th node is examined
			if (nodesExamined % 10000 == 0)
			{
				System.out.println(nodesExamined + " nodes examined. ");
				System.out.println("Still searching A*... ");
			}
			//take top of priority q
			best = fringe.poll();

			if (!best.checkGoalState(best, goalState))
			{
				if(!closed.contains(best))
				{
					best.expand(best);
					closed.add(best);
					for( int i = 0; i < best.children.size(); i++ )
					{
						fringe.offer(best.children.get(i));
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
		System.out.println("A* SEARCH STATS:");
		printSolution(best, found); 
		return found;
	}

	/** 
	 * Implements Comparator to use a priority queue
	 */
	static class PQsort implements Comparator<BoardState> 
	{
		/**
		 * Compares to boardState objects based on heuristic value for insertion into p queue
		 * 
		 */
		@Override
		public int compare(BoardState board1, BoardState board2) 
		{
			if (board1.getHeuristicCost(board1) + board1.getPathCost(board1) > board2.getHeuristicCost(board2) + board2.getPathCost(board2))
			{
				return 1; 
			}
			if (board1.getHeuristicCost(board1) + board1.getPathCost(board1) < board2.getHeuristicCost(board2) + board2.getPathCost(board2))
			{
				return -1; 
			}
			return 0; 
		}
	}
}
