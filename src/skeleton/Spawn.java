package skeleton;

import java.util.ArrayList;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:02
 */
public class Spawn extends UpdateAble {

	private int currentCount = 0;
	private int maxCount = 100;
	private ArrayList<Cell> spawnPoints;

	public Spawn(){

	}
	
	public Spawn(ArrayList<Cell> firstRoadElementsList){
			TDUtils.callerLog("Spawn", "Spawn", "ArrayList<Cell>", " Spawn pont lista lett beallitva");
			spawnPoints = firstRoadElementsList;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	private Cell getRndSPoint(){
		TDUtils.callerLog("Spawn", "getRndSPoint", "ArrayList<Cell>", " Spawn pont lista lett beallitva");
		return spawnPoints.get(0);
	}


	/**
	 * 
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
				
				Enemy toTest = new Dwarf(sPoint);
				
				incCount();
			}
			
			delta = 0;	
		}
		else
		{
			incDelta(time);
		}
		
	}

	public void incCount(){
		TDUtils.callerLog("Spawn", "incCount", "", " Teremtett Enemy szama");
		currentCount++;
	}
	
	public void addSpwnPoint(Cell sPoint) {
		TDUtils.callerLog("Spawn", "addSpwnPoint", "Cell", " Uj Spawn pontot vettunk fel");
		spawnPoints.add(sPoint);
	}

}