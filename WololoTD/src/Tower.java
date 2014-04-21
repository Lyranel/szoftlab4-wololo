import java.util.Iterator;
import java.util.Set;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-�pr.-2014 16:46:27
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
		
		super.home = home;
		this.damage = 15;
		this.range = 1;
		this.speed = 0.5f;
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Cell getMaxTargets(){
		
		if (targets.size() == 0) {
			return null;
		}
		
		Iterator<Cell> iter = targets.iterator();
		
		Cell minCell = iter.next();
		int minCount = minCell.getEnemyCount();
		
		while (iter.hasNext()) {
			Cell tempCell = iter.next();
			int tempCount = tempCell.getEnemyCount();
			
			if (tempCount < minCount) {
				minCell = tempCell;
			}
		}
		
		return minCell;
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
		
		try {
		
			if (upgradeCount < 3) {
			
				if (Cryst.whatAmI.equals("damage")) {
					damage += 5;
					upgradeCount++;
				}
				
				else if (Cryst.whatAmI.equals("range")) {
					range++;
					upgradeCount++;
				}
				
				else if (Cryst.whatAmI.equals("speed")) {
					speed -= 0.1f;
					upgradeCount++;
				}
				
				else throw new Exception("This building cannot be upgraded with this type of crystal.");
			}
			
			else throw new Exception("This building cannot be upgraded anymore.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String print() {
		String print = new String("Damage: "+ damage);
		print += "\n\t\t" + "Range: " + range; 
		print += "\n\t\t" + "Speed: " + speed;
		
		return print;
	}
	

}