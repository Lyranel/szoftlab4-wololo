

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public abstract class PlayerControlled extends UpdateAble implements IPlaceAble {

	protected Cell home;
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
	public void update(float time){

	}

	/**
	 * 
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){

	}
	
	public String print(){
		return null;
	}

}