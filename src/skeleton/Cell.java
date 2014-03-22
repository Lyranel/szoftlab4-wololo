package skeleton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-m�rc.-2014 18:01:46
 */
public class Cell {

	private IPlaceAble building;
	private Set<Enemy> enemies;
	private HashMap<Integer, Cell> neighbours;
	private Cell nextRoad;
	private State state;

	public Cell(){
		enemies = new HashSet<Enemy>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param enemy
	 */
	public void add(Enemy enemy){
		TDUtils.callerLog("Cell", "add", "Enemy", "a cella kapott egy Enemy-t");
		enemies.add(enemy);
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
	public Cell getTargets(int range){
		return null;

	}

	/**
	 * 
	 * @param enemy
	 */
	public void remove(Enemy enemy){
			TDUtils.callerLog("Cell", "remove", "Enemy", "ami el lesz tavolitva");
			enemies.remove(enemy);
	}

	/**
	 * 
	 * @param n
	 * @param index
	 */
	public void setNeighbour(Cell n, int index){
			TDUtils.callerLog("Cell", "setNeighbour", "Cell, int", index + ".-ik szomszed beallitva");
	}

	/**
	 * 
	 * @param cell
	 */
	public void setNext(Cell cell){

	}

}