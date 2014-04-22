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
	private boolean gameEnd = false;

	public MiddleEarth(){
		updateList = UpdateAble.getUpdateList();
		saruman = new Player(this);
		map = TDUtils.mapReader();
		Spawn gonoszBugyor = new Spawn(saruman);
		if(TDUtils.enemyCount == 0)
		{
			saruman.setEnemyCount(TDUtils.getMapSizeX()*TDUtils.getMapSizeY());
			gonoszBugyor.setMaxCount(TDUtils.getMapSizeX()*TDUtils.getMapSizeY());
		}
		else if(TDUtils.enemyCount > 0)
		{
			saruman.setEnemyCount(TDUtils.enemyCount);
			gonoszBugyor.setMaxCount(TDUtils.enemyCount);
		}
		
		TDUtils.sLog("********** START **********");
		//Kiirjuk, hogy mennyi Mana-ja van meg Sarumannak
		TDUtils.sLog("CURRENT MANA: " + saruman.getMana());
		//Kiirjuk, hogy mennyi ellenseg van meg a palyan
		TDUtils.sLog("REMAINING ENEMIES: " + saruman.getEnemyCount());
		//Kiirjuk, hogy melyik cellan mi talalhato (MD ES SP csak a START-nal irjuk ki)
		for(int i = 0; i < map.size(); i++)
			{
				if(map.get(i).getEnemyCount() != 0 || map.get(i).getBuilding() != null || map.get(i).getState()!=State.EMPTY)
					{
						TDUtils.sLog(map.get(i).print(i));
					}
			}
		
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

	/**
	 * Update fuggveny
	 * @param time
	 */
	public void update(float time){
		if(!gameEnd)
		{
			updateList.update(time);
			
			//Kiirjuk, hogy update esemeny tortent:
			TDUtils.sLog("******** UPDATE " + time + " ********" );
			//Kiirjuk, hogy mennyi Mana-ja van meg Sarumannak
			TDUtils.sLog("CURRENT MANA: " + saruman.getMana());
			//Kiirjuk, hogy mennyi ellenseg van meg a palyan
			TDUtils.sLog("REMAINING ENEMIES: " + saruman.getEnemyCount());
			for(int i = 0; i < map.size(); i++)
			{
				if(map.get(i).getEnemyCount() != 0 || map.get(i).getBuilding() != null)
				{
					TDUtils.sLog(map.get(i).print(i));
				}
			}
		}
	}
	
	public void lose(){
		if(gameEnd != true)
		{
			TDUtils.sLog("********** LOSE **********");
		}
		
		TDUtils.end = true;
		gameEnd = true;
	}

	public void win(){
		//Kiirjuk, hogy nyertunk
		TDUtils.sLog("********** WIN **********");
		TDUtils.end = true;
		gameEnd = true;
	}
}
