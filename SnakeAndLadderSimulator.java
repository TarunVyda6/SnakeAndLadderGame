import java.util.Random;

public class SnakeAndLadderSimulator 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		int playerPosition = 0;
		int dieRolledCount = gameLoop ( playerPosition, random );
		System.out.println ("total die roll count is : " + dieRolledCount);
	}
	
	// uc2
	public static int dieRoll ( Random random )
	{
		
		int dieNumber = random.nextInt (6) + 1;
		return dieNumber;
	}
	
	// uc3
	public static int playerOptionCheck ( Random random, int playerPosition, int dieNumber )
	{
		final int noPlay = 0;
		final int ladder = 1;
		final int snake = 2;
		
		int playerOption = random.nextInt(3);
		switch ( playerOption )
		{
			case	noPlay	:	playerPosition = playerPosition;
						break;
			case	ladder	:	playerPosition = playerPosition + dieNumber;
						break;
			case	snake	:	playerPosition = playerPosition - dieNumber;
		}
		return playerPosition;
	}
	
	// uc4
	public static int gameLoop ( int playerPosition, Random random )
	{
		int dieRolledCount = 0;
		while ( playerPosition < 100 )
		{
			if ( playerPosition >= 0)
			{
				int tempPlayerPosition = playerPosition;
				int dieNumber = dieRoll ( random );
				dieRolledCount++;
				playerPosition = playerOptionCheck ( random, playerPosition, dieNumber );
				// uc5
				if ( playerPosition > 100 )
				{
					playerPosition = tempPlayerPosition;
				}
			}
			else
			{
				playerPosition = 0;
			}
			System.out.println ("player position is : " + playerPosition);
		}
		return dieRolledCount;
	}
}
