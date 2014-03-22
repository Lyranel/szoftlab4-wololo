package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:53
 */
public class Elf extends Enemy {

	public Elf(){

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
		TDUtils.callerLog("Elf", "update", "", " mozgunk");
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){

	}

}