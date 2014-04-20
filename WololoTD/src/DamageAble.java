

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public abstract class DamageAble extends UpdateAble implements IDamageAble {

	private int health;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

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
		health -= amount;
	}

	/**
	 * 
	 * @param time
	 */
	public void incDelta(float time){
		super.incDelta(time);
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){

	}

}