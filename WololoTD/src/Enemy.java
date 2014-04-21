

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-�pr.-2014 16:46:26
 */
public abstract class Enemy extends DamageAble {

	private Cell cLocation;
	private Player saruman;
	private float speed = 1.0f;
	protected int manaCost;

	public Enemy(){

	}

	public Enemy(Cell sPoint, Player saruman2) {
		this.add(sPoint);
		this.saruman = saruman2;
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param location
	 */
	public void add(Cell location){
		cLocation = location;
		location.add(this);
	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){
		
		super.damage(amount);
		
		if(this.getHealth() <= 0)
		{
			this.death();
		}
		
	}

	private void death() {
		
		cLocation.remove(this);
		saruman.decreaseEnemyCount();
		saruman.increaseMana(manaCost);
		this.remove();
	}

	public void move(){
		
		Cell nextCell = cLocation.getNext();
		
		if(nextCell != null)	
		{
			cLocation.remove(this);
			nextCell.add(this);
			cLocation = nextCell;
			speed = 1.f;
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
		speed = 1 - amount;
	}

	@Override
	public void update(float time) {
		super.update(time);
		
		incDelta(time);
		
		while(delta >= maxDelta * (1 / speed))
		{
			move();
			delta -= maxDelta;
		}
		
		
	}

	public String print(){
		return null;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	

}
