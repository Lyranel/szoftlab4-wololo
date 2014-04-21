

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Elf extends Enemy {

	public Elf(){

	}

	public Elf(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.manaCost = 12;
		this.setHealth(TDUtils.ElfHP);
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
	@Override
	public void slow(float amount){
		
	}
	public String print(){
		String print = "Elf - " + getHealth() + "/" + TDUtils.ElfHP + " speed: " + maxDelta;
		return print;
	}
	

}