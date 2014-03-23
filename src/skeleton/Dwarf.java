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
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}
	
	public void move(){
		TDUtils.callerLog("Dwarf", "update", "", " mozgunk");
		super.move();
		
	}

	/**
	 * 
	 * @param amount
	 */
	public void slow(float amount){

	}

	

	
	
}