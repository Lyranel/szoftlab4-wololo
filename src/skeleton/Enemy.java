package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:53
 */
public abstract class Enemy extends DamageAble {

	private Cell cLocation;
	private Player saruman;
	private float speed;

	public Enemy(){

	}

	public Enemy(Cell pos){
		TDUtils.callerLog("Enemy", "Enemy", "Cell", "Letrejott az enemy es megkapta a kezdocellat");
		
		pos.add(this);
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param location
	 */
	public void add(Cell location){

	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}

	public void move(){

	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){

	}
	
	/* (non-Javadoc)
	 * @see skeleton.DamageAble#update(float)
	 */
	@Override
	public void update(float time) {
		
		TDUtils.callerLog("Enemy", "update", Float.toString(time), " Update ido");
		
		super.update(time);
		
		if(time >= maxDelta)
		{
			move();
		}
		else
		{
			incDelta(time);
		}
		
	}
	

}