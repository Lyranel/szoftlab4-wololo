package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:53
 */
public abstract class Enemy extends DamageAble {

	private Cell cLocation;		//az enemy-t tartalmazo cella
	private Player saruman;		//a player
	private float speed;		//az enemy sebessege

	public Enemy(){

	}

	/**
	 * konstruktor 
	 * @param pos kezdo cella
	 * @param saruman a player
	 */
	public Enemy(Cell pos, Player saruman){
		TDUtils.callerLog("Enemy", "Enemy", "Cell", "Letrejott az enemy es megkapta a kezdocellat");
		
		this.add(pos);
		this.saruman = saruman;
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * beallitja a sajat helyet az enemy
	 * @param location
	 */
	public void add(Cell location){
		TDUtils.callerLog("Enemy", "add", "Cell", "az enemy beallitja a helyet");
		cLocation = location;
		location.add(this);
	}

	/**
	 * az enemy megserult
	 * @param amount
	 */
	public void damage(int amount){
		TDUtils.callerLog("Enemy", "damage", "int", "Az ellenseg sebzodik");
		//meghivjukj a damageAble damage metodusat
		super.damage(amount);
		//ha az enemy elete kissebb vagy egyenlo mint nulla
		if(this.getHealth() <= 0)
		{
			//meghallt az enemy
			this.death();
		}
		
	}
	/**
	 * az enemy meghallt ezek utan kitakarit
	 */
	private void death() {
		TDUtils.callerLog("Enemy", "death", "", "Az ellenseg halott");
		//kiveszi magat a cellabol ahol tartozkodik
		cLocation.remove(this);
		//csokkentjuk az ellenseget szamat
		saruman.decreaseEnemyCount();
		//noveljuk a manat
		saruman.increaseMana(10);
		//kivesszuk az updateList-bol
		this.remove();
		
	}
	/**
	 * a move metodus ez alapjan mozgunk majd
	 */
	public void move(){
		TDUtils.callerLog("Enemy", "move", "", "az enemy mozog");
		//elkerjuk a kovetkezo cellat
		Cell nextCell = cLocation.getNext();
		//ha a cella nem nulla
		if(nextCell != null)
		{
			//akkor innen kivesszuk az ellenseget
			cLocation.remove(this);
			//es berakjuk az uj cellaba
			nextCell.add(this);
			//at allitjuk a cLocation-t
			cLocation = nextCell;
		}
		else
		{
			//vesztettunk
			saruman.lose();
		}
		
		
	}

	/**
	 * lassitjuk az ellent
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
		//meghivjuk a parent update-et
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