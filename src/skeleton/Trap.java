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
	
	public Trap(Cell home) {
		this.home = home;
		TDUtils.callerLog("Cell", "build", "IPlaceAble", "");
		this.home.build(this);
		this.slowAmount = 1;
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){
		this.slowAmount++;
	}

	/* (non-Javadoc)
	 * @see skeleton.PlayerControlled#update(float)
	 */
	@Override
	public void update(float time) {
		TDUtils.callerLog("Trap", "update", Float.toString(time), " Update ido");
		
	}
	
	

}