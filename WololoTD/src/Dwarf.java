

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Dwarf extends Enemy {

	public Dwarf(){

	}

	public Dwarf(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.setHealth(TDUtils.DwarfHP);
		this.manaCost = 10;
		this.speed = TDUtils.DwarfSpeed;
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
		String print = "Dwarf - " + getHealth() + "/" + TDUtils.DwarfHP + " speed: " + (maxDelta*speed);
		return print;
	}

}