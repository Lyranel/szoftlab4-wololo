import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-�pr.-2014 16:46:26
 */
public class Cell {

	private IPlaceAble building;
	private Set<Enemy> enemies;
	private HashMap<Integer, Cell> neighbours;
	private ArrayList<Cell> nextRoad;
	private State state;

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