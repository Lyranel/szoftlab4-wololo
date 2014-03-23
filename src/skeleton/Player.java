package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:59
 */
public class Player {

	private int enemyCount;
	private int mana;
	private MiddleEarth puppetMaster;

	
	public Player(MiddleEarth puppetMaster, int enemyCount){
		this.puppetMaster = puppetMaster;
		this.enemyCount = enemyCount;
		this.mana = 100;
		TDUtils.callerLog("Player", "Player", "MiddleEarth, int", "Megkapta a puppetmastert, es az enemyCountot");
	}
	
	public Player(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param pos
	 */
	public void buildTower(int pos){

	}

	/**
	 * 
	 * @param pos
	 */
	public void buildTrap(int pos){

	}

	public void decreaseEnemyCount(){
		TDUtils.callerLog("Player", "decreaceEnemyCount", "", "Egy ellenseggel kevesebb");
		enemyCount--;
		if(this.enemyCount <= 0)
		{
			puppetMaster.win();
		}
		
	}

	public int getEnemyCount(){
		return 0;
	}

	/**
	 * 
	 * @param mana
	 */
	public void increaseMana(int mana){
		TDUtils.callerLog("Player", "increaseMana", "Int", "noveljuk a manank");
		this.mana += mana;
	}

	/**
	 * Because the enemy only knows the player
	 */
	public void lose()
	{
		TDUtils.callerLog("Player", "lose", "", "lose uzenet");
		puppetMaster.lose();
	}
	
	/**
	 * 
	 * @param num
	 */
	public void setEnemyCount(int num){
		enemyCount = num;
	}

	/**
	 * 
	 * @param pos
	 */
	public void upgradeTower(int pos){

	}

	/**
	 * 
	 * @param pos
	 */
	public void upgradeTrap(int pos){

	}

	public void testBuild(String type) {
		
		int testTowerCost = 50;
		int testTrapCost = 30;
		
		if (type.equals("tower")) {
			
			if (this.mana >= testTowerCost) {
				TDUtils.callerLog("MiddleEarth", "getCell", "", "");
				TDUtils.callerLog("Cell", "getState", "", "");
				if (this.puppetMaster.getCell(0, 2).getState() == State.EMPTY) {
					TDUtils.createLog("Tower", "testTower", "Player", "saruman", "");
					Tower testTower = new Tower(this.puppetMaster.getCell(0, 2));
					TDUtils.callerLog("Player", "decreaseMana", "int", "");
					this.increaseMana(-1*testTowerCost);
				}
				
				else System.out.println("A kivalasztott cellara nem lehet epiteni.");
			}
				
			else System.out.println("Nincs eleg mana az epiteshez.");
			
		}
		
		if (type.equals("trap")) {
			
			if (this.mana >= testTrapCost) {
				TDUtils.callerLog("MiddleEarth", "getCell", "", "");
				TDUtils.callerLog("Cell", "getState", "", "");
				if (this.puppetMaster.getCell(0, 0).getState() == State.ROAD) {
					TDUtils.createLog("Trap", "testTrap", "Player", "saruman", "");
					Trap testTrap = new Trap(this.puppetMaster.getCell(0, 0));
					TDUtils.callerLog("Player", "decreaseMana", "int", "");
					this.increaseMana(-1*testTrapCost);			
				}
				
				else System.out.println("A kivalasztott cellara nem lehet epiteni.");
			}
				
			else System.out.println("Nincs eleg mana az epiteshez.");
		
		}
		
	}
	
	public void testUpgrade(String type) {
		
		int testUpgradeCost = 30;
		
		if (this.mana >= testUpgradeCost) {
			TDUtils.callerLog("MiddleEarth", "getCell", "", "");
			TDUtils.callerLog("Cell", "getState", "", "");
			if (this.puppetMaster.getCell(0, 2).getState() == State.TOWER) {
				TDUtils.callerLog("Tower", "upgrade", "Crystal", "");
				this.puppetMaster.getCell(0, 2).getBuilding().upgrade(new RangeC());
				TDUtils.callerLog("Player", "decreaseMana", "int", "");
				this.increaseMana(-1*testUpgradeCost);	
				
			}
			
			else if (this.puppetMaster.getCell(0, 0).getState() == State.TRAP) {
				TDUtils.callerLog("Trap", "upgrade", "Crystal", "");
				this.puppetMaster.getCell(0, 0).getBuilding().upgrade(new TrapC());
				TDUtils.callerLog("Player", "decreaseMana", "int", "");
				this.increaseMana(-1*testUpgradeCost);	
				
			}
			
			else System.out.println("A kivalasztott cella nem fejlesztheto.");
		}
		
		else System.out.println("Nincs eleg mana a fejleszteshez.");
		
	}

}
