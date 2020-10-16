import java.util.Random;

public class SnakeAndLadderSimulator 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		int firstPlayerPosition = 0;
		int secondPlayerPosition = 0;
		int dieRolledCount = gameLoop ( firstPlayerPosition, secondPlayerPosition, random );
		System.out.println ("total die roll count is : " + dieRolledCount);
	}
	
	// uc2
	public static int dieRoll ( Random random )
	{
		
		int dieNumber = random.nextInt (6) + 1;
		return dieNumber;
	}
	
	// uc3
	public static int playerOptionCheck ( Random random, int PlayerPosition, int dieNumber )
	{
		final int noPlay = 0;
		final int ladder = 1;
		final int snake = 2;
		
		int playerOption = random.nextInt(3);
		switch ( playerOption )
		{
			case	noPlay	:	PlayerPosition = PlayerPosition;
						break;
			case	ladder	:	PlayerPosition = PlayerPosition + dieNumber;
		// uc7
						int dieNumber1 = dieRoll(random);
						PlayerPosition = playerOptionCheck ( random, PlayerPosition, dieNumber1 );
						break;
			case	snake	:	PlayerPosition = PlayerPosition - dieNumber;
		}
		return PlayerPosition;
	}
	
	// uc4
	public static int gameLoop ( int firstPlayerPosition, int secondPlayerPosition, Random random )
	{
		int dieRolledCountPlayer1 = 0;
		int dieRolledCountPlayer2 = 0;
		while ( firstPlayerPosition < 100 && secondPlayerPosition < 100 )
		{
			if ( firstPlayerPosition >= 0)
			{
				int tempfirstPlayerPosition = firstPlayerPosition;
				int dieNumber = dieRoll ( random );
				dieRolledCountPlayer1++;
				firstPlayerPosition = playerOptionCheck ( random, firstPlayerPosition, dieNumber );
				// uc5
				if ( firstPlayerPosition > 100 )
				{
					firstPlayerPosition = tempfirstPlayerPosition;
				}
			}
			else
			{
				firstPlayerPosition = 0;
			}
			System.out.println ("first player position is : " + firstPlayerPosition);
			
			if ( secondPlayerPosition >= 0)
			{
				int tempSecondPlayerPosition = secondPlayerPosition;
				int dieNumber = dieRoll ( random );
				dieRolledCountPlayer2++;
				secondPlayerPosition = playerOptionCheck ( random, secondPlayerPosition, dieNumber );
				// uc5
				if ( secondPlayerPosition > 100 )
				{
					secondPlayerPosition = tempSecondPlayerPosition;
				}
			}
			else
			{
				secondPlayerPosition = 0;
			}
			System.out.println ("second player position is : " + secondPlayerPosition );
		}
		if ( firstPlayerPosition == 100 )
		{
			System.out.println(" player 1 won ");
			return dieRolledCountPlayer1;
		}
		else
		{
			System.out.println(" player 2 won ");
			return dieRolledCountPlayer2;
		}
	}
}
