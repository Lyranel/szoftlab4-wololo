

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Human extends Enemy {

	public Human(){

	}

	public Human(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.manaCost = 10;
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

}