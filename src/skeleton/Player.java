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

}