package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:54
 */
public class Hobbit extends Enemy {

	public Hobbit(){

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
		TDUtils.callerLog("Hobbit", "damage", "int", "Az ellenseg sebzodik");
	}

	public void move(){
		super.move();
		TDUtils.callerLog("Hobbit", "update", "", " mozgunk");
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){
		TDUtils.callerLog("Elf", "slow", "float", " Az ellenség lassul.");
	}

}