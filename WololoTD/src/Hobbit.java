

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

	}

}