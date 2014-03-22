package skeleton;

import java.util.ArrayList;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:02
 */
public class Spawn extends UpdateAble {

	private int currentCount;
	private int maxCount;
	private ArrayList<Cell> spawnPoints;

	public Spawn(){

	}
	
	public Spawn(ArrayList<Cell> firstRoadElementsList){
			TDUtils.callerLog("Spawn", "Spawn", "ArrayList<Cell>", "");
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
		return null;
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
		TDUtils.callerLog("Spawn", "update", Float.toString(time), " Update ido");
	}

	public void incCount(){

	}

}