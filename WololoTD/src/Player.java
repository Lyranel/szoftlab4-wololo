

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class Player {

	private int enemyCount;
	private int mana;
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	private MiddleEarth puppetMaster;

	public Player(){

	}
	
	public Player(MiddleEarth puppeteer) {
		this.puppetMaster = puppeteer;
		this.mana = 150;
	}

	public void finalize() throws Throwable {
		//TODO	
	}

	/**
	 * Torony epites
	 * @param posY
	 * @param posX
	 */
	public void buildTower(int posY, int posX){
		
		try {
			//Csak akkor tudunk tornyot epiteni, ha a cella allapota ures...
			if (puppetMaster.getCell(posY, posX).getState() != State.EMPTY) {
				throw new Exception("This type of building cannot be placed to the specified position.");
			}
			
			//...es van eleg penzunk ra
			else if (TDUtils.towerCost > mana) {
				throw new Exception("There is not enough mana to perform the tower summoning ritual.");
			}
			
			else {
				Cell outCell = puppetMaster.getCell(posY, posX);
				int pos = getMapIndex(outCell)+1;
				puppetMaster.getCell(posY, posX).build(new Tower(puppetMaster.getCell(posY, posX),pos));
				mana -= TDUtils.towerCost;
			}		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Csapda epites
	 * @param posY
	 * @param posX
	 */
	public void buildTrap(int posY, int posX){
		
		try {
			//Csak utra lehet csapdat epiteni
			if (puppetMaster.getCell(posY, posX).getState() != State.ROAD) {
				throw new Exception("This type of building cannot be placed to the specified position.");
			}
			//es csak akkor, ha vanr a eleg penzunk
			else if (TDUtils.trapCost > mana) {
				throw new Exception("There is not enough mana to perform the trap summoning ritual.");
			}
			
			else {
				Cell outCell = puppetMaster.getCell(posY, posX);
				int pos = getMapIndex(outCell)+1;
				puppetMaster.getCell(posY, posX).build(new Trap(puppetMaster.getCell(posY, posX),pos));
				mana -= TDUtils.trapCost;
			}		
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Globalisan mennyi elleneseg van meg a palyan
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
		enemyCount++;
	}

	/**
	 * Megnoveljuk a mana-t
	 * @param mana
	 */
	public void increaseMana(int mana){
		
		this.mana += mana;
		
	}

	/**
	 * Beallitjuk az enemyCount-ot
	 * @param num
	 */
	public void setEnemyCount(int num){
		enemyCount = num;
	}

	/**
	 * Torony fejlesztes
	 * @param posY
	 * @param posX
	 */
	
	public void upgradeTower(int posY, int posX, Crystal type){
		
		try {
			//csak tornyot akarjunk toronyfejeleszteni...
			if (puppetMaster.getCell(posY, posX).getState() != State.TOWER) {
				throw new Exception("This type of cell cannot be upgraded with this crystal.");
			}
			//es csak akkor, ha van eleg penzunk
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
	 * CSapda fejlesztes
	 * @param posY
	 * @param posX
	 */
	public void upgradeTrap(int posY, int posX, Crystal type){
		
		try {
			//Csak csapdat akarjunk csapdafejleszteni...
			if (puppetMaster.getCell(posY, posX).getState() != State.TRAP) {
				throw new Exception("This type of cell cannot be upgraded with this crystal.");
			}
			//...es csak akkor, ha van ra eleg penzunk
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
	
	public int getMapIndex(Cell i)
	{
		return puppetMaster.getMapIndex(i);
	}
	

}
