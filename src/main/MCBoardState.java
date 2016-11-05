package main;

import java.util.List;
import java.util.Vector;

public class MCBoardState extends BoardState
{
	Vector<Integer> vector = new Vector<Integer>();

	public MCBoardState(int[] intlBoardState, int level) 
	{
		int[] initialBoardState = new int[] {3,3,1}; 

		//Initialize Game Board vector using user provided initialBoardState
		for ( int i = 0; i < initialBoardState.length; i++ )
		{
			vector.add(initialBoardState[i]);
		}
		System.out.println(vector);

	}

	public List<BoardState> expand( MCBoardState board )
	{

		return children;
	}

	public boolean isValid()
	{
		boolean isValid = false; 

		if ( getMissionaries() < getCannibals() && getMissionaries() <= 3 && getCannibals() <= 3 && 
				getCannibals() - getMissionaries() >= 0 )
		{
			return true; 
		}
		return false; 

		if ( getMissionary >= 0 && missionaryRight >= 0 && cannibalLeft >= 0 && cannibalRight >= 0
				&& (missionaryLeft == 0 || missionaryLeft >= cannibalLeft)
				&& (missionaryRight == 0 || missionaryRight >= cannibalRight)) 
		{
			return true;
		}
		return false;
	}

	private int getCannibals() 
	{
		return vector.get(0); 
	}
	private int getMissionaries() 
	{
		return vector.get(1);
	}
	private int getBoat()
	{
		return vector.get(2);
	}

}
