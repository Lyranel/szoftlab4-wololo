import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Cell {

	private IPlaceAble building;
	private Set<Enemy> enemies;
	private HashMap<Integer, Cell> neighbours;
	private ArrayList<Cell> nextRoad;
	private State state;

	public Cell(){
		enemies = new TreeSet<Enemy>();
		nextRoad = new ArrayList<Cell>();
		state = State.EMPTY;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param enemy
	 */
	public void add(Enemy enemy){
		enemies.add(enemy);
	}

	/**
	 * 
	 * @param cell
	 */
	public void addNext(Cell cell){
		nextRoad.add(cell);
	}

	/**
	 * 
	 * @param building
	 */
	public void build(IPlaceAble building){
		
		if(building == null)
		{
			this.building = building;
			
			if(this.state == State.EMPTY)
			{
				this.state = State.TOWER;
			}
			else if (this.state == State.ROAD)
			{
				this.state = State.TRAP;
			}
		}
	}

	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){

		for (IDamageAble e: enemies)
		{
			try
			{
				e.damage(amount);
			}
			catch(Exception a)
			{
				
			}
			
		}
	}

	public int getEnemyCount(){
		return enemies.size();
	}

	public Set<Enemy> getEnemyList(){
		return enemies;
	}

	public Cell getNext(){
		return null;
	}
	

	public State getState(){
		return state;
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
		enemies.remove(enemy);
	}

	/**
	 * 
	 * @param n
	 * @param index
	 */
	public void setNeighbour(Cell n, int index){

	}
	
	public IPlaceAble getBuilding() {
		return this.building;

	}

}