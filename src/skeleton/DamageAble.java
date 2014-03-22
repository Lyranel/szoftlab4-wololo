package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-m�rc.-2014 18:01:50
 */
public abstract class DamageAble extends UpdateAble implements IDamageAble {

	private int health;

	public DamageAble(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

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

	}

}