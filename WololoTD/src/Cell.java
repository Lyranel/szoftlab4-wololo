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
	private ArrayList<Cell> neighbours;
	private ArrayList<Cell> nextRoad;
	private State state;

	public Cell(){
		enemies = new TreeSet<Enemy>();
		nextRoad = new ArrayList<Cell>();
		neighbours = new ArrayList<Cell>();
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
		
		this.building = building;
			
		if(this.state == State.EMPTY) {
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
		//TODO: Kell a random valasztas
		return null;
	}
	

	public State getState(){
		return state;
	}

	/**
	 * 
	 * @param range
	 */
	public void getTargets(int range, Set<Cell> targets){
		
		if (state == State.ROAD || state == State.TRAP) {
			targets.add(this);
		}
		
		if (range > 0) {
			for (Cell c : neighbours) {
				c.getTargets(range - 1, targets);
			}
		}
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
	public void setNeighbour(Cell n){
		neighbours.add(n);
	}
	
	public IPlaceAble getBuilding() {
		return this.building;

	}
	
	public void mountDoomSetter(){
		this.state = State.MOUNTDOOM;
	}

}
