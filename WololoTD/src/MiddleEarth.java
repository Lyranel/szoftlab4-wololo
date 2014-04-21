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
		//TDUtils.map = "C:\\DefaultMap.xml";
		saruman = new Player(this);
		map = TDUtils.mapReader();
		Spawn gonoszBugyor = new Spawn(saruman);
		saruman.setEnemyCount(10);
		gonoszBugyor.setMaxCount(10);
		
		
		
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
		//Kiirjuk, hogy veszitettunk
		System.out.println("********** LOSE **********");
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		updateList.update(time);
		//Kiirjuk, hogy update esemeny tortent:
		System.out.println("******** UPDATE " + time + " ********" );
		//Kiirjuk, hogy mennyi Mana-ja van meg Sarumannak
		System.out.println("CURRENT MANA: " + saruman.getMana());
		//Kiirjuk, hogy mennyi ellenseg van meg a palyan
		System.out.println("REMAINING ENEMIES: " + saruman.getEnemyCount());
		for(int i = 0; i < map.size(); i++)
		{
			if(map.get(i).getEnemyCount() != 0 || map.get(i).getBuilding() != null)
			{
				System.out.println(map.get(i).print(i));
			}
		}
		
	}

	public void win(){
		//Kiirjuk, hogy nyertunk
		System.out.println("********** WIN **********");
	}

	
	
}
