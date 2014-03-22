package skeleton;

import java.util.HashMap;
import java.util.Set;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:46
 */
public class Cell {

	private IPlaceAble building;
	private Set<Enemy> enemies;
	private HashMap<Integer, Cell> neighbours;
	private Cell nextRoad;
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
	public void getTargets(int range){

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
			System.out.println("called: Cell_setNeighbour: " + index);
	}

	/**
	 * 
	 * @param cell
	 */
	public void setNext(Cell cell){

	}

}