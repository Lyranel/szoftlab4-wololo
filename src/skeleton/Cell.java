package skeleton;

import java.util.HashMap;
import java.util.HashSet;
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

	public Cell(){
		enemies = new HashSet<Enemy>();
		state = State.EMPTY;
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
		this.building = building;
		if (this.state == State.EMPTY) {
			this.state = State.TOWER;
			
		}
		
		else if (this.state == State.ROAD) {
			this.state = State.TRAP;
			
		}

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
		TDUtils.callerLog("Cell", "getNext", "", " lekerjuk a kovetkezo cellat");
		return nextRoad;
	}

	public State getState(){
		return this.state;
	}

	/**
	 * 
	 * @param range
	 */
	public Set<Cell> getTargets(int range){
		return null;

	}
	
	public IPlaceAble getBuilding() {
		return this.building;
		
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
		TDUtils.callerLog("Cell", "SetNext", "Cell", "bealitom az utat");
		this.nextRoad = cell;
		
	}

}