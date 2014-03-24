package skeleton;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:05
 */
public class Tower extends PlayerControlled {

	private int damage;
	private int range;
	private int speed;
	private ArrayList<Cell> targetList = new ArrayList<Cell>();

//	public Tower(){
//
//	}
	
	public Tower(Cell home, Cell target) {
		this.home = home;
		this.targetList.add(target);
		TDUtils.callerLog("Cell", "build", "IPlaceAble", "");
		this.home.build(this);
		this.damage = 10;
		this.range = 2;
		this.speed = 1;
		TDUtils.callerLog("Cell", "getTargets", "int", "");
		//this.targetList = this.home.getTargets(this.range);

		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * vissza adjuk azt a cellat amiben a legtobb az ellenseg
	 * @return
	 */
	public Cell getMaxTargets(){
		TDUtils.callerLog("Tower", "getTargets", "", "-- Lekerdezi, hogy a torony szomszedjai kozul emlyiken van a legtobb ellenseg");
		
		for(Cell target : targetList){
			target.getEnemyCount();
		}
		 return targetList.get(0);
	}

	/**
	 * upgrade metodus
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){
		this.range++;
		TDUtils.callerLog ("Cell", "getTargets", "int", "");
		this.targetList = this.home.getTargets(this.range);
		
	}

	/* (non-Javadoc)
	 * @see skeleton.PlayerControlled#update(float)
	 */
	@Override
	public void update(float time) {
		TDUtils.callerLog("Tower", "update", Float.toString(time), " Update ido");
		//A Tower kideriti, hogy a szomszedos cellai
		//kozul melyiken van a legtobb ellenseg
		Cell target = getMaxTargets();
		target.damage(1);
		
	}
	/**
	 * vissza adjuk a targeteket
	 * @return
	 */
	public ArrayList<Cell> getTargetList() {
		return targetList;
	}
	/**
	 * beallitunk egy targetlist-et
	 * @param targetList
	 */
	public void setTargetList(ArrayList<Cell> targetList) {
		this.targetList = targetList;
	}
	
	

}