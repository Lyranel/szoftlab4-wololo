import java.util.ArrayList;
import java.util.Random;

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Spawn extends UpdateAble {

	private int currentCount;
	private float difficulty;
	private int maxCount;
	private Player saruman;

	public Spawn(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	private Cell getSpawnPoint(){
		return null;
	}

	public void incCount(){
		
	}

	/**
	 * 
	 * @param time
	 */
	public void incDelta(float time){

	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
			
		if(delta >= maxDelta)
		{
			if(currentCount < maxCount)
			{
				Cell sPoint = getSpawnPoint();
				
				Enemy myEvilChild;
				
				incCount();
			}
			
		}
		else
		{
				incDelta(time);
		}
		
	}
	
	private Enemy getEnemy(Cell sPoint)
	{
		 Random gen = new Random();
		 int i = gen.nextInt(100)+1;
		 
		 if(i > 0 && i <= 25)
		 {
			 return new Hobbit(sPoint, saruman);
		 }
		 else if(i > 25 && i <= 50)
		 {
			 return new Human(sPoint, saruman);
		 }
		 else if(i > 50 && i <= 75)
		 {
			 return new Dwarf(sPoint, saruman);
		 }
		 else if(i > 75 && i <= 100)
		 {
			 return new Elf(sPoint, saruman);
		 }
		
		return null;
	}

	
}