

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public abstract class UpdateAble implements IUpdateAble {

	protected float delta = 0;
	protected float maxDelta = 1;
	private static UpdateAbleList updateList;

	public UpdateAble(){

	}

	public void finalize() throws Throwable {

	}

	public static UpdateAbleList getUpdateList(){
		return null;
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