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
			BoardState currentState = stack.pop();
			//System.out.println("Stack 1:" + stack.toString()); 

			if (!checkGoalState(currentState, goalState))
			{
				expand(currentState);
				System.out.println("Children: " + children.size());
				for( int i = 0; i < children.size(); i++ )
				{
					stack.push(children.get(i));
					System.out.println("ChildrenStack || SIZE: " + stack.size() + stack.toString()); 
				}
			}
			else
			{
				System.out.println("FOUND");
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