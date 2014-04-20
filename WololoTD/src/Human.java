

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

}