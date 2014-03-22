package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:55
 */
public class Human extends Enemy {

	public Human(){

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
		super.move();
		TDUtils.callerLog("Elf", "update", "", " mozgunk");
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){

	}

}