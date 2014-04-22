import java.util.ArrayList;
import java.util.Random;

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Spawn extends UpdateAble {

	private int currentCount;	 	// A jelenlegi ellenseg szam
	private float difficulty = 0;	//a jatek nehezsege
	private int maxCount;			//a maximalis ellenseg szam
	private Player saruman;			//Szaruman a player

	public Spawn(){
		
	}
	
	/**
	 * A player konstuktora
	 * @param saru	a player amit beallitunk
	 */
	public Spawn(Player saru)
	{
		saruman = saru;
		delta = maxDelta;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Vissza ad egy cellat ahova spawnolunk
	 * @return
	 */
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
	/**
	 * vissza adja a maximalis ellenseg szamot
	 * @return
	 */
	public int getMaxCount() {
		return maxCount;
	}

	/**
	 * beallitja a maximalis ellensegszamot
	 * @param maxCount
	 */
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	
	/**
	 * növeli az ellenseg szamot
	 */
	public void incCount(){
		currentCount++;
	}


	/**
	 * A spawn update-je amiben letrehoz egy uj ellenseget
	 * @param time
	 */
	public void update(float time){
			
		incDelta(time);
		
		while(delta >= maxDelta)
		{
			delta -= maxDelta;
			
			if(currentCount < maxCount)
			{
				Cell sPoint = getSpawnPoint();
				
				Enemy myEvilChild = getEnemy(sPoint);
				
				//update, hogy nagy delta eseten ne ragadjon benn a spawn pontban
				myEvilChild.update(delta);
				
				incCount();
			}
			
			
		}
		
	}
	
	/**
	 * Vissza ad egy enemy tipust, a valasztos random vagy beallitott modon
	 * @param sPoint	a pont ahova eled az ellenseg
	 * @return
	 */
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