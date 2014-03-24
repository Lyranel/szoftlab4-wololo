package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:50
 */
public abstract class DamageAble extends UpdateAble implements IDamageAble {

	private int health = 5; //az eletero

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	public DamageAble(){
		//meghivjuk az UpdateAble konstrokturat,
		//hogy berakjuk az updateAbleList-be
		
	}

	public void finalize() throws Throwable {

	}

	/**
	 * levonjuk a serulest az eletbol
	 * @param amount
	 */
	public void damage(int amount){
		TDUtils.callerLog("Enemy", "damage", Integer.toString(amount), " eletponttal csokkent az elete");
		health -= amount;
	}

	/**
	 * a delta idot noveljuk
	 * @param time
	 */
	public void incDelta(float time){
		super.incDelta(time);
	}

	/**
	 * update a child felulirja majd
	 * @param time
	 */
	public void update(float time){
		
	}

}