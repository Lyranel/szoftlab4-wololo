package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:09
 */
public abstract class UpdateAble implements IUpdateAble {
	
	protected float delta = 0;		//a delta ido
	protected float maxDelta = 1;	//maxDelta ha ez == delta akkor esemeny
	private static UpdateAbleList updateList = new UpdateAbleList();	//a statikus updateAbleList

	/**
	 * @return the updateList
	 */
	public static UpdateAbleList getUpdateList() {
		return updateList;
	}
	/**
	 * konstruktorban mikor letrejon a peldany akkor hozza adja magat az updateList-hez
	 */
	public UpdateAble(){
		updateList.add(this);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * noveljuk a delta-t
	 * @param time
	 */
	public void incDelta(float time){
		TDUtils.callerLog("UpdateAble", "incDelta", Float.toString(time), " A deltat noveljuk");
		delta += time;
	}

	/**
	 * update fuggveny a tobbi osztaly ezt foglya felulirni
	 * @param time
	 */
	public void update(float time){

	}
	
	/**
	 * eltavolitja magat az updateList-bol
	 * @param upd
	 */
	public void remove(){
		TDUtils.callerLog("UpdateAble", "remove", "", " kivesszuk magunkat az update listabol");
		
		updateList.remove(this);
	}
	

}