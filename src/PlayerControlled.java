

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public abstract class PlayerControlled extends UpdateAble implements IPlaceAble {

	private Cell home;
	private int manaCost;
	protected int upgradeCount = 0;

	public PlayerControlled(){

	}

	public void finalize() throws Throwable {
		super.finalize();
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

	/**
	 * 
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){

	}

}