

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Human extends Enemy {

	//ember ellenseg
	public Human(){

	}

	public Human(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.manaCost = 10;
		this.setHealth(TDUtils.HumanHP);
		this.maxDelta = TDUtils.HumanSpeed;
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

	protected void split(int health, Cell cLocation){
		Human Clone = new Human(cLocation, saruman);
		Clone.setHealth(health);
	}
	
	public String print(){
		String print = "Human - " + getHealth() + "/" + TDUtils.HumanHP + " speed: " + ((1/maxDelta)*speed);
		return print;
	}

}