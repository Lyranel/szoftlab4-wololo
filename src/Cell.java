

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Cell {

	private IPlaceAble building;
	private Set<Enemy> enemies;
	private HashMap<int, Cell> neighbours;
	private Arraylist<Cell> nextRoad;
	private State state;
	public IPlaceAble m_IPlaceAble;
	public Enemy m_Enemy;

	public Cell(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param enemy
	 */
	public void add(Enemy enemy){

	}

	/**
	 * 
	 * @param cell
	 */
	public void addNext(Cell cell){

	}

	/**
	 * 
	 * @param building
	 */
	public void build(IPlaceAble building){

	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

	}

	public int getEnemyCount(){
		return 0;
	}

	public Set<Enemy> getEnemyList(){
		return null;
	}

	public Cell getNext(){
		return null;
	}

	public State getState(){
		return null;
	}

	/**
	 * 
	 * @param range
	 */
	public Set<Cell> getTargets(int range){
		return null;
	}

	/**
	 * 
	 * @param enemy
	 */
	public void remove(Enemy enemy){

	}

	/**
	 * 
	 * @param n
	 * @param index
	 */
	public void setNeighbour(Cell n, int index){

	}

}