package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-m�rc.-2014 18:01:52
 */
public class Dwarf extends Enemy {

	public Dwarf(){

	}
	
	public Dwarf(Cell pos){
		super(pos);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}
	
	public void move(){
		super.move();
		TDUtils.callerLog("Dwarf", "update", "", " mozgunk");
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){

	}

	

	
	
}