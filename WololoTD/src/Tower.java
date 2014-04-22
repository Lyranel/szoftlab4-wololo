import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Tower extends PlayerControlled {

	private int damage;
	private boolean fog;
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
		
		if (TDUtils.fog == 1) {
			this.range = 0;
		}
		else this.range = 1;
		
		super.home = home;
		this.damage = 15;
		this.speed = 0.5f;
		this.fogTimer = 0;
		this.targets = new HashSet<Cell>();
		super.home.getTargets(range, targets);
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Cell getMaxTargets(){
		
		if (targets.size() == 0) {
			return null;
		}
		
		Iterator<Cell> iter = targets.iterator();
		
		Cell maxCell = iter.next();
		int maxCount = maxCell.getEnemyCount();
		
		while (iter.hasNext()) {
			Cell tempCell = iter.next();
			int tempCount = tempCell.getEnemyCount();
			
			if (tempCount > maxCount) {
				maxCell = tempCell;
			}
		}
		
		return maxCell;
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		
		if (getMaxTargets().getEnemyCount() > 0) {
			incDelta(time);
		}
		
		while(delta >= maxDelta * speed)
		{
			shoot();
			delta -= maxDelta * speed;
			
			if (TDUtils.fog == 0) {
				
				if (fogTimer >= time) {
					fogTimer -= time;
				}
				else fogTimer = 0;
			
				Random gen = new Random();
				int i = gen.nextInt(100);
				
				if (i < 15) {
					fogTimer+= 2;
				}
			}
		}
		
		if (TDUtils.fog == 0) {
			
			if (fogTimer > 0 && !fog) {
				fog = true;
				range--;
			}
			else if (fogTimer < 0.001 && fog) {
				fog = false;
				range++;
			}
		}
	}
	
	private void shoot()
	{
		Cell target = getMaxTargets();
		ArrayList<Enemy> Enemylist = new ArrayList<Enemy>(target.getEnemyList());
		for (Enemy e : Enemylist) {
			e.damage(damage);
		}
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
					home.getTargets(range, targets);
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
