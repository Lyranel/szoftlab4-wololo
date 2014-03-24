package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:00
 */
public abstract class PlayerControlled extends UpdateAble implements IPlaceAble {

	protected Cell home;	//a cella amiben van

	public PlayerControlled(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * noveljuk a delta idot
	 * @param time
	 */
	public void incDelta(float time){

	}

	/**
	 * update metodusa
	 * @param time
	 */
	public void update(float time){

	}

	/**
	 * update metodus
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){

	}

}