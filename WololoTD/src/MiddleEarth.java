import java.util.ArrayList;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-�pr.-2014 16:46:26
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
		Spawn gonoszBugyor = new Spawn(saruman);
		
		
		
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
		return null;
	}

	public Player getPlayer(){
		return null;
	}

	public void lose(){

	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		updateList.update(time);
	}

	public void win(){

	}

}