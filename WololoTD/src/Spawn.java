import java.util.ArrayList;
import java.util.Random;

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Spawn extends UpdateAble {

	private int currentCount;
	private float difficulty = 0;
	private int maxCount;
	private Player saruman;

	public Spawn(){
		
	}
	
	public Spawn(Player saru)
	{
		saruman = saru;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	private Cell getSpawnPoint(){
		
		if(TDUtils.spawn == 0)
		{
			return Road.roadList.get(new Random().nextInt(Road.roadList.size()));
		}
		else if(TDUtils.spawn == 1)
		{
			return Road.roadList.get(0);
		}
		
		return null;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public void incCount(){
		currentCount++;
	}


	/**
	 * 
	 * @param time
	 */
	public void update(float time){
			
		incDelta(time);
		
		while(delta >= maxDelta)
		{
			if(currentCount < maxCount)
			{
				Cell sPoint = getSpawnPoint();
				
				Enemy myEvilChild = getEnemy(sPoint);
				
				//myEvilChild.update(delta - (time % maxDelta));
				myEvilChild.update((delta % maxDelta)+ time-delta);
				
				incCount();
			}
			
			delta -= maxDelta;
		}
		
	}
	
	private Enemy getEnemy(Cell sPoint)
	{
		 Random gen = new Random();
		 
		 if(TDUtils.enemy == 0)
		 {
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
		 }
		 else if(TDUtils.enemy == 1)
		 {
			 return new Dwarf(sPoint, saruman);
		 }
		 else if(TDUtils.enemy == 2)
		 {
			 return new Elf(sPoint, saruman);
		 }
		 else if(TDUtils.enemy == 3)
		 {
			 return new Hobbit(sPoint, saruman);
		 }
		 else if(TDUtils.enemy == 4)
		 {
			 return new Human(sPoint, saruman);
		 }
		 
		return null;
	}

	
}