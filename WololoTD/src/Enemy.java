import java.util.Random;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public abstract class Enemy extends DamageAble {

	private Cell cLocation;
	protected Player saruman;
	protected float speed = 1.0f;
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
		//Ha a random splittelés be van kapcsola
		if(TDUtils.split == 0){
			 Random gen = new Random();
			 int random = gen.nextInt(100)+1;
			 if(random <= 5){
					//Ha a random kapcsolo be van kapcsolva es ha jo random szamot kapunk
					//es a HP-nk nem kevesebb, mint egy, akkor kette valunk ugy, hogy
					//a HP-nk felezodik
					//Ha csak 1 a HP-ja, akkor a fele 0,5 lenne, amit lefele kerekitunk
					//ezert eben az esetben sincs splitteles
				 	if(this.getHealth() <= 0){
				 		this.death();
				 	}
				 	else if(this.getHealth() > 1)
					{
						saruman.increaseEnemy();
						this.setHealth(getHealth()/2);
						this.split(getHealth(), cLocation);
					}																
			 }
		}
		//Ha a splitteles teljesen ki van kapcsolva
		if(TDUtils.split == 2){
			super.damage(amount);
			
			if(this.getHealth() <= 0)
			{
				this.death();
			}
		}
		//Ha kotelezo  splitteles be van kapcsolva
		if(TDUtils.split == 1){
		 	if(this.getHealth() <= 1){
		 		this.death();
		 	}
		 	else{
				saruman.increaseEnemy();
				this.setHealth(getHealth()/2);
				this.split(getHealth(), cLocation);
		 	}
		}
		
	}

	protected void split(int health, Cell cLocation) {
		
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
