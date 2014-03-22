package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:05
 */
public class Tower extends PlayerControlled {

	private int damage;

	public Tower(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Cell getMaxTargets(){
		return null;
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
		TDUtils.callerLog("Tower", "update", Float.toString(time), " Update ido");
	}
	
	

}