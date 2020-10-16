import java.util.Random;

public class SnakeAndLadderSimulator
{
	public static void main(String[] args) 
	{
		int playerPosition = 0;
		int dieNumber = dieRoll();
	}
	
	// uc1
	public static int dieRoll()
	{
		Random random = new Random();
		int dieNumber = random.nextInt(6) + 1;
		return dieNumber;
	}
	
	
}

