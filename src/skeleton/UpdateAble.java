package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:09
 */
public abstract class UpdateAble implements IUpdateAble {

	protected float delta = 0;
	protected float maxDelta = 1;
	private static UpdateAbleList updateList = new UpdateAbleList();

	/**
	 * @return the updateList
	 */
	public static UpdateAbleList getUpdateList() {
		return updateList;
	}

	public UpdateAble(){
		updateList.add(this);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param time
	 */
	public void incDelta(float time){
		TDUtils.callerLog("UpdateAble", "incDelta", Float.toString(time), " A deltat noveljuk");
		delta += time;
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){

	}
	
	

}