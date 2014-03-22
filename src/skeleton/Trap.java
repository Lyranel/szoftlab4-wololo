package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:06
 */
public class Trap extends PlayerControlled {

	private float slowAmount;

	public Trap(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){

	}

	/* (non-Javadoc)
	 * @see skeleton.PlayerControlled#update(float)
	 */
	@Override
	public void update(float time) {
		TDUtils.callerLog("Trapt", "update", Float.toString(time), " Update ido");
		
	}
	
	

}