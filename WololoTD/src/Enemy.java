

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public abstract class Enemy extends DamageAble {

	private Cell cLocation;
	private Player saruman;
	private float speed;
	public Player m_Player;

	public Enemy(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param location
	 */
	public void add(Cell location){

	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}

	public void move(){

	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){

	}

}

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Enemy extends Enemy {

	public Enemy(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}