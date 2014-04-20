

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public abstract class UpdateAble implements IUpdateAble {

	protected float delta = 0;		//a delta ido
	protected float maxDelta = 1;	//a max delta ha ez == delta akkor esemeny
	private static UpdateAbleList updateList = new UpdateAbleList();	//hozzaferes a statikus updateList-hez

	public UpdateAble(){
		updateList.add(this);
	}

	public void finalize() throws Throwable {

	}

	public static UpdateAbleList getUpdateList(){
		return updateList;
	}

	/**
	 * 
	 * @param time
	 */
	public void incDelta(float time){
		delta += time;
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){

	}
	
	public void remove(){
		updateList.remove(this);
	}

}