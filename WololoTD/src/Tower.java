import java.util.Set;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Tower extends PlayerControlled {

	private int damage;
	private float fogTimer;
	private int range;
	private float speed;
	private Set<Cell> targets;

	public Tower(){

	}
	
	/**
	 * 
	 * @param home
	 */
	public Tower(Cell home) {
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Cell getMaxTargets(){
		return null;
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){

	}

	/**
	 * 
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){

	}

}