package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:52
 */
public class Dwarf extends Enemy {

	public Dwarf(){

	}
	
	public Dwarf(Cell pos, Player saruman){
		super(pos,saruman);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	

	/**
	 * a serules metodusa
	 * @param amount ennyit serul
	 */
	public void damage(int amount){
		TDUtils.callerLog("Dwarf", "damage", "int", "Az ellenseg sebzodik");
		super.damage(amount);
	}
	/**
	 * mozgas metodusa
	 */
	public void move(){
		TDUtils.callerLog("Dwarf", "update", "", " mozgunk");
		super.move();
		
	}

	/**
	 * a lassulast intezi el
	 * @param amount
	 */
	public void slow(float amount){
		TDUtils.callerLog("Dwarf", "slow", "float", " Az ellenség lassul.");
	}

	

	
	
}