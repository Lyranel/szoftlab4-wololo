

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Elf extends Enemy {

	//Tunde ellenseg, gyors, es nem lassitja a csapda
	public Elf(){

	}

	public Elf(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.manaCost = 12;
		this.setHealth(TDUtils.ElfHP);
		this.maxDelta = TDUtils.ElfSpeed;
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
	
	protected void split(int health, Cell cLocation){
		Elf Clone = new Elf(cLocation, saruman);
		Clone.setHealth(health);
	}
	public String print(){
		String print = "Elf - " + getHealth() + "/" + TDUtils.ElfHP + " speed: " + ((1/maxDelta)*speed);
		return print;
	}
	

}