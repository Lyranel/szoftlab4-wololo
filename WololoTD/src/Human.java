

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
		this.setHealth(TDUtils.HumanHP);
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

	
	
	public String print(){
		String print = "Human - " + getHealth() + "/" + TDUtils.HumanHP + " speed: " + maxDelta;
		return print;
	}

}