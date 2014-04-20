

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
		
		try {
		
			if (puppetMaster.getCell(posY, posX).getState() != State.EMPTY) {
				throw new Exception("This type of building cannot be placed to the specified position.");
			}
			
			else if (TDUtils.towerCost > mana) {
				throw new Exception("There is not enough mana to perform the tower summoning ritual.");
			}
			
			else {
				puppetMaster.getCell(posY, posX).build(new Tower(puppetMaster.getCell(posY, posX)));
				mana -= TDUtils.towerCost;
			}		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param posY
	 * @param posX
	 */
	public void buildTrap(int posY, int posX){
		
		try {
			
			if (puppetMaster.getCell(posY, posX).getState() != State.ROAD) {
				throw new Exception("This type of building cannot be placed to the specified position.");
			}
			
			else if (TDUtils.trapCost > mana) {
				throw new Exception("There is not enough mana to perform the trap summoning ritual.");
			}
			
			else {
				puppetMaster.getCell(posY, posX).build(new Trap(puppetMaster.getCell(posY, posX)));
				mana -= TDUtils.trapCost;
			}		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
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
	public void upgradeTower(int posY, int posX, Crystal type){
		
		try {
			
			if (puppetMaster.getCell(posY, posX).getState() != State.TOWER) {
				throw new Exception("This type of cell cannot be upgraded with this crystal.");
			}
			
			else if (TDUtils.towerCrystalCost > mana) {
				throw new Exception("There is not enough mana to perform the tower enhancement ritual.");
			}
			
			else {
				puppetMaster.getCell(posY, posX).getBuilding().upgrade(type);
				mana -= TDUtils.towerCrystalCost;
			}		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param posY
	 * @param posX
	 */
	public void upgradeTrap(int posY, int posX, Crystal type){
		
		try {
			
			if (puppetMaster.getCell(posY, posX).getState() != State.TRAP) {
				throw new Exception("This type of cell cannot be upgraded with this crystal.");
			}
			
			else if (TDUtils.trapCrystalCost > mana) {
				throw new Exception("There is not enough mana to perform the trap enhancement ritual.");
			}
			
			else {
				puppetMaster.getCell(posY, posX).getBuilding().upgrade(type);
				mana -= TDUtils.trapCrystalCost;
			}		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lose() {
		puppetMaster.lose();
		
	}

}