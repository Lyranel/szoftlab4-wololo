package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:09
 */
public abstract class UpdateAble implements IUpdateAble {

	protected float delta = 0;
	protected float maxDelta = 1;
	private static UpdateAbleList updateList;

	public UpdateAble(){

	}

	public void finalize() throws Throwable {

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