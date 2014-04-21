

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Hobbit extends Enemy {

	public Hobbit(){
		
	}

	public Hobbit(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.manaCost = 7;
		this.setHealth(TDUtils.HobbitHP);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){
		super.damage(amount);
	}

	public void move(){
		super.move();
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){
		//TODO: slow(float amount)
	}
	public String print(){
		String print = "Hobbit - " + getHealth() + "/" + TDUtils.HobbitHP + " speed: " + maxDelta;
		return print;
	}

}