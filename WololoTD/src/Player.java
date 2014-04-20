

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Player {

	private int enemyCount;
	private int mana;
	private MiddleEarth puppetMaster;

	public Player(){

	}
	
	public Player(MiddleEarth puppeteer, int enemyCount) {
		this.puppetMaster = puppeteer;
		this.enemyCount = enemyCount;
		this.mana = 100;
	}

	public void finalize() throws Throwable {
		//TODO	
	}

	/**
	 * 
	 * @param posY
	 * @param posX
	 */
	public void buildTower(int posY, int posX){
		

	}

	/**
	 * 
	 * @param posY
	 * @param posX
	 */
	public void buildTrap(int posY, int posX){

	}

	public void decreaseEnemyCount(){
		
		enemyCount--;
		
		if(this.enemyCount <= 0)
		{
			puppetMaster.win();
		}
		
	}

	public int getEnemyCount(){
		return enemyCount;
	}

	public void increaseEnemy(){

	}

	/**
	 * 
	 * @param mana
	 */
	public void increaseMana(int mana){
		
		this.mana += mana;
		
	}

	/**
	 * 
	 * @param num
	 */
	public void setEnemyCount(int num){

	}

	/**
	 * 
	 * @param posY
	 * @param posX
	 */
	public void upgradeTower(int posY, int posX){

	}

	/**
	 * 
	 * @param posY
	 * @param posX
	 */
	public void upgradeTrap(int posY, int posX){

	}

	public void lose() {
		puppetMaster.lose();
		
	}

}