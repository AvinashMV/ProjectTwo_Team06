import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ServerNumGenerator {

	public static void main (String [] args){
		
		int min = 1;
		int max = 1024;
		int randomNum;
		Random rand = new Random();
		
		while(true)
		{
			randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			System.out.println("Random Num :"+randomNum);
			
			int  n = rand.nextInt(max) + min;
			System.out.println("Random: "+n);

		}
		}
}
