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
		
		this.add(pos);
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param location
	 */
	public void add(Cell location){
		TDUtils.callerLog("Enemy", "add", "Cell", "az enemy beallitja a helyet");
		cLocation = location;
		location.add(this);
	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}

	public void move(){
		TDUtils.callerLog("Enemy", "move", "", "az enemy mozog");
		Cell nextCell = cLocation.getNext();
		
		cLocation.remove(this);
		
		nextCell.add(this);
		cLocation = nextCell;
		
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