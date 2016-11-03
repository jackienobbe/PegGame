package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends Search 
{
	private Stack<BoardState> stack = new Stack<BoardState>();
	//private List<Move> moves = new LinkedList<Move>();

	DepthFirstSearch(){}

	@Override
	public String toString() 
	{
		return "Depth First Search";
	}

	public boolean find(BoardState initialState, BoardState goalState) 
	{
		boolean found = false;

		stack.push(initialState);
		//BoardState previous = initialState;
		while (!found && !stack.empty()) 
		{
			BoardState current = stack.pop();
			System.out.println("Stack 1:" + stack.toString()); 

			if (!checkGoalState(current, goalState))
			{
				expand(current);
				System.out.println();
				for( int i = 0; i < current.children.size(); i++ )
				{
					stack.push(current.children.get(i));
					System.out.println("Stack 2:" + stack.toString()); 
				}
			
				System.out.println("Stack 3:" + stack.toString()); 
			}
			else
			{
				found = true; 
			}

			//	if (!current.equals(initialState)) 
			//	{
			//		Move move = new Move(previous, current);
			//		moves.add(move);
			//	}
			//	if (current.getChildren().size() == 0) 
			//	{
			//		return moves;
			//	} 
			//	else if (!closed.contains(current)) 
			//	{
			//		closed.add(current);
			//		for (BoardState child : current.getChildren()) 
			//		{
			//			stack.push(child);
			//		}
			//	}
		}
		return found;
	}

}