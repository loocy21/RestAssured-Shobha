package GenricUtils;

import java.util.Random;

/**
 * This class has genric methods related java library
 * @author SHOBHA
 *
 */
public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
	}
	

}
