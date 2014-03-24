package skeleton;

import java.util.ArrayList;
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
	private ArrayList<Enemy> enemies;
	private HashMap<Integer, Cell> neighbours;
	private Cell nextRoad;
	private State state;

	public Cell(){
		enemies = new ArrayList<Enemy>();
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
		TDUtils.callerLog("Cell", "damage", "", " Meghivja a rajta levo egyik ellensegen a sebzest.");
		TDUtils.doLogging = false;
		Enemy testEnemy = new Hobbit();
		TDUtils.doLogging = true;
		testEnemy.damage(amount);
		
	}

	public int getEnemyCount(){
		TDUtils.callerLog("Cell", "getEnemyCount", "", " Visszaadja, hogy hany ellenseg van rajta");
		return 1;
	}

	public ArrayList<Enemy> getEnemyList(){
		TDUtils.callerLog("Cell", "getEnemyList", "", " lekerjuk a a cellan talalhato ellensegeket");
		return this.enemies;
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
	public ArrayList<Cell> getTargets(int range){
		TDUtils.callerLog("Cell", "getTargets", "int", " lekerjuk a kovetkezo cellat");
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
		this.state = State.ROAD;
		
	}

	public void setEnemy(Enemy e) {
		this.enemies = new ArrayList<Enemy>();
		enemies.add(e);
		
		
	}

}