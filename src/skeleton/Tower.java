package skeleton;

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
	private Set<Cell> targetList;

	public Tower(){

	}
	
	public Tower(Cell home) {
		this.home = home;
		TDUtils.callerLog("Cell", "build", "IPlaceAble", "");
		this.home.build(this);
		this.damage = 10;
		this.range = 2;
		this.speed = 1;
		TDUtils.callerLog("Cell", "getTargets", "int", "");
		this.targetList = this.home.getTargets(this.range);
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Cell getMaxTargets(){
		return null;
	}

	/**
	 * 
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){
		this.range++;
		TDUtils.callerLog("Cell", "getTargets", "int", "");
		this.targetList = this.home.getTargets(this.range);
		
	}

	/* (non-Javadoc)
	 * @see skeleton.PlayerControlled#update(float)
	 */
	@Override
	public void update(float time) {
		TDUtils.callerLog("Tower", "update", Float.toString(time), " Update ido");
	}
	
	

}