package skeleton;

import java.util.ArrayList;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:02
 */
public class Spawn extends UpdateAble {

	private int currentCount = 0;	//a jelenlegi ellenseg szam
	private int maxCount = 100;		//maximalis szam
	private ArrayList<Cell> spawnPoints; //a cellak amire lehet spawnolni
	private Player saruman; //a player 

	public Spawn(){

	}
	
	/**
	 * konstruktor
	 * @param firstRoadElementsList
	 * @param saruman
	 */
	public Spawn(ArrayList<Cell> firstRoadElementsList, Player saruman){
			TDUtils.callerLog("Spawn", "Spawn", "ArrayList<Cell>", " Spawn pont lista lett beallitva");
			spawnPoints = firstRoadElementsList;
			this.saruman = saruman;
	}
	/**
	 * vissza adjuk a max ellenseget
	 * @return
	 */
	public int getMaxCount() {
		return maxCount;
	}
	/**
	 * beallitjuk a max ellenseget
	 * @param maxCount
	 */
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
/**
 * kivalasztunk egy cellat amire lerakjuk az ellenseget
 * @return
 */
	private Cell getRndSPoint(){
		TDUtils.callerLog("Spawn", "getRndSPoint", "ArrayList<Cell>", " Spawn pont lista lett beallitva");
		return spawnPoints.get(0);
	}


	/**
	 * update metodus
	 * @param time
	 */
	public void update(float time){
		TDUtils.callerLog("Spawn", "update", Float.toString(time), " Update ido");
		
		if(delta >= maxDelta)
		{
			if(currentCount < maxCount)
			{
			//TODO-	Enemy létrehozása
				
				Cell sPoint = getRndSPoint();
				
				Enemy toTest = new Dwarf(sPoint, saruman);
				
				incCount();
			}
			
			delta = 0;	
		}
		else
		{
			incDelta(time);
		}
		
	}
	/**
	 * a jelenlegi ellenseg szam novelese
	 */
	public void incCount(){
		TDUtils.callerLog("Spawn", "incCount", "", " Teremtett Enemy szama");
		currentCount++;
	}
	/**
	 * spawnpontot adunk hozza
	 * @param sPoint
	 */
	public void addSpwnPoint(Cell sPoint) {
		TDUtils.callerLog("Spawn", "addSpwnPoint", "Cell", " Uj Spawn pontot vettunk fel");
		spawnPoints.add(sPoint);
	}

}