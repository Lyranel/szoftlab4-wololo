

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-�pr.-2014 16:46:26
 */
public abstract class DamageAble extends UpdateAble implements IDamageAble {

	private int health;

	public DamageAble(){

	}

	public void finalize() throws Throwable {
		super.finalize();
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