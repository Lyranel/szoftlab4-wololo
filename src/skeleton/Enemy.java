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

	public Enemy(Cell pos, Player saruman){
		TDUtils.callerLog("Enemy", "Enemy", "Cell", "Letrejott az enemy es megkapta a kezdocellat");
		
		this.add(pos);
		this.saruman = saruman;
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
		TDUtils.callerLog("Enemy", "damage", "int", "Az ellenseg sebzodik");
		super.damage(amount);
		if(this.getHealth() <= 0)
		{
			this.death();
		}
		
	}

	private void death() {
		TDUtils.callerLog("Enemy", "death", "", "Az ellenseg halott");
		cLocation.remove(this);
		
		saruman.decreaseEnemyCount();
		saruman.increaseMana(10);
		
		this.remove();
		
	}

	public void move(){
		TDUtils.callerLog("Enemy", "move", "", "az enemy mozog");
		Cell nextCell = cLocation.getNext();
		
		if(nextCell != null)
		{
		cLocation.remove(this);
		
		nextCell.add(this);
		cLocation = nextCell;
		}
		else
		{
			saruman.lose();
		}
		
		
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){
		TDUtils.callerLog("Enemy", "slow", "float", " Az ellenség lassul.");
	}
	
	/* (non-Javadoc)
	 * @see skeleton.DamageAble#update(float)
	 */
	@Override
	public void update(float time) {
		
		TDUtils.callerLog("Enemy", "update", Float.toString(time), " Update ido");
		
		super.update(time);
		
		if(delta >= maxDelta)
		{
			move();
			delta = 0;	
		}
		else
		{
			incDelta(time);
		}
		
	}
	

}