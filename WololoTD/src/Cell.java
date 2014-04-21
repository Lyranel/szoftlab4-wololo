import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-�pr.-2014 16:46:26
 */
public class Cell {

	//Milyen epulet van a cellan
	private IPlaceAble building;
	//Milyen ellensegek vannak a cellan
	private ArrayList<Enemy> enemies;
	//Kik a cella szomszedai (ezeket a TDUtils.readMap allitja be)
	private ArrayList<Cell> neighbours;
	//Amennyiben a cella egy ut resze, ki koveti ot az uton
	private ArrayList<Cell> nextRoad;
	private State state;

	//Minden cella alapbol ures allapotu, azaz nincs rajta semmi
	private int RR = 0;
	
	public Cell(){
		enemies = new ArrayList<Enemy>();
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
		state = State.ROAD;
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
	//A torony az egesz cellat sebzi, tehat a rajta talalhato osszes ellenseget
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

	public ArrayList<Enemy> getEnemyList(){
		return enemies;
	}

	//Azon vella kivalasztasa, hogy az ellenseg melyiken menjen tovabb
	//amennyiben tobb szomszedja van, akkor random valasztas tortenik
	public Cell getNext(){
		
		if(TDUtils.branch == 0)
		{
			if(this.nextRoad.size() != 0)
			{
				return nextRoad.get(new Random().nextInt(nextRoad.size()));
			}
		}
		else if(TDUtils.branch == 1)
		{
			if(this.nextRoad.size() != 0)
			{
				return this.nextRoad.get(0);
			}
		}
		else if(TDUtils.branch == 2)
		{
			
			if(this.nextRoad.size() != 0)
			{
				if(this.nextRoad.size() == 1)
				{
					return this.nextRoad.get(0);
				}
				else
				{
					
					if(RR < this.nextRoad.size())
					{
						RR++;
						return this.nextRoad.get(RR-1);
					}
					else if(RR >= this.nextRoad.size())
					{
						RR = 0;
						return this.nextRoad.get(RR);
					}
					
				}
			}
			
		}
		
		return null;
	}
	
	/**
	 * Kedves comment.
	 * 
	 * This function is called by Tower objects on their home attribute to populate their targets, which contains the roads in their range.
	 * The function gets propagated by the recursive call from the home Cell, adding each Cell which has either ROAD or TRAP state.
	 * The parameter targets is a Set for all Cells to be added only once. 
	 * 
	 * @param range
	 * @param targets
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
	
	public void spawnPointSetter() {
		this.state = State.SPAWNPOINT;
		
	}

	public State getState(){
		return state;
	}


	public String print(int i) {
		int posX = i % TDUtils.mapSizeX;
		int posY = (i - posX) / TDUtils.mapSizeX;
		String print = "Cell(" + posX + "," + posY + ") " + this.state;
		if(getEnemyList().size() != 0){
			print += "\n\tENEMIES: ";
			for(int j = 0; j < getEnemyList().size(); j++){
				print += "\n\t\t" + getEnemyList().get(j).print();
			}
		}
		if(this.building != null)
		{
			print += "\n\tBUILDING: ";
			print += "\n\t\t" + this.building.print();
		}
		
		return print;
	}



}
