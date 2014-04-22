

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Trap extends PlayerControlled {

	private float slowAmount;		// a csapda lassitas merteke

	public Trap(){

	}
	
	/**
	 * A csapda konstruktora
	 * @param home
	 */
	public Trap(Cell home) {
		
		super.home = home;
		this.slowAmount = 0.1f;
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * az update metodus
	 * @param time
	 */
	public void update(float time){
		
		for(Enemy e: this.home.getEnemyList())
		{
			e.slow(slowAmount);
		}
	}

	/**
	 * upgrade amivel a lassitas merteke novelheto
	 * @param Cryst
	 */
	public void upgrade(Crystal Cryst){
		
		try {
			
			if (upgradeCount < 3) {
			
				if (Cryst.whatAmI.equals("trap")) {
					slowAmount += 0.1f;
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
		String print = new String("Slow: " + slowAmount * 100.f + "%");
		
		return print;
	}

	
	
}