package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:50
 */
public abstract class DamageAble extends UpdateAble implements IDamageAble {

	private int health;

	public DamageAble(){
		//meghivjuk az UpdateAble konstrokturat,
		//hogy berakjuk az updateAbleList-be
		
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}

	/**
	 * 
	 * @param time
	 */
	public void incDelta(float time){
		super.incDelta(time);
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		
	}

}