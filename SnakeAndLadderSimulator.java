import java.util.Random;

public class SnakeAndLadderSimulator 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		int playerPosition = 0;
		playerPosition = gameLoop ( playerPosition, random );
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
		// uc5
		while ( playerPosition < 100 )
		{
			if ( playerPosition >= 0)
			{
				int tempPlayerPosition = playerPosition;
				int dieNumber = dieRoll ( random );
				playerPosition = playerOptionCheck ( random, playerPosition, dieNumber );
				if ( playerPosition > 100 )
				{
					playerPosition = tempPlayerPosition;
				}
			}
			else
			{
				playerPosition = 0;
			}
		}
		return playerPosition;
	}
}
