package skeleton;

import java.util.ArrayList;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:06
 */
public class Trap extends PlayerControlled {

	private float slowAmount;	// a lassitas merteke

//	public Trap(){
//
//	}
	
	public Trap(Cell home, Enemy e) {
		this.home = home;
		this.home.setEnemy(e);
		TDUtils.callerLog("Cell", "build", "IPlaceAble", "");
		this.home.build(this);
		this.slowAmount = 1;
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * upgrade metodus
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){
		this.slowAmount++;
	}

	/* (non-Javadoc)
	 * @see skeleton.PlayerControlled#update(float)
	 */
	@Override
	public void update(float time) {
		TDUtils.callerLog("Trap", "update", Float.toString(time), " Update ido");
		ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
		enemyList = this.home.getEnemyList();
		for(Enemy e : enemyList){
			e.slow(1);
		}
	}
	
	

}