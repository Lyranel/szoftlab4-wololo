import java.util.ArrayList;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class MiddleEarth {

	private ArrayList<Cell> map;
	private Player saruman;
	private UpdateAbleList updateList;

	public MiddleEarth(){
		updateList = UpdateAble.getUpdateList();
		TDUtils.map = "C:\\DefaultMap.xml";
		saruman = new Player(this);
		map = TDUtils.mapReader();
		//Spawn gonoszBugyor = new Spawn(saruman);
		
		Dwarf test1 = new Dwarf(Road.roadList.get(0),saruman);
		
	}

	public void finalize() throws Throwable {

	}

	public void generateRoad(){

	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	public Cell getCell(int y, int x){
		return map.get(TDUtils.mapSizeY * y + x);
	}

	public Player getPlayer(){
		return saruman;
	}

	public void lose(){
		System.out.println("Saruman lost");
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		updateList.update(time);
		
		for(int i = 0; i < map.size(); i++)
		{
			if(map.get(i).getEnemyCount() != 0)
			{
				System.out.println("Cella ID: "+i+" Ellenseg Szam:" + map.get(i).getEnemyCount());
			}
		}
		
	}

	public void win(){

	}

}
