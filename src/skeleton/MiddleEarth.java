package skeleton;

import java.util.ArrayList;
import java.util.List;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:58
 */
public class MiddleEarth {

	private List<Cell> map;
	private Player saruman;
	private UpdateAbleList updateList;

	public Cell m_Cell;
	public UpdateAbleList m_UpdateAbleList;

	public MiddleEarth(){

	}
	
	//teszthez szukseges konstruktor (igy konynen tudjuk inicializalni a teszt palyat)
	public MiddleEarth(List<Cell> map){
		System.out.println("called: MiddleEarth_MiddleEarth: " + map.size() + " cellat kaptam.");
		
		this.map = map;
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		System.out.println("created: ArrayList<Cell> Named:map_by_MiddleEarth Named: puppetMaster");
		
		//test palya megteremetese 
		map.get(0).setNeighbour(map.get(1),1);
		map.get(0).setNeighbour(map.get(2),2);
		map.get(0).setNeighbour(map.get(3),3);
		map.get(0).setNeighbour(map.get(4),4);	
		
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
	public void getCell(int y, int x){

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

	}

	public void win(){

	}
	
	////Teszteleshez kello fuggvenyek:
	public List<Cell> getMap() {
		return map;
	}

/*	public void setMap(List<Cell> testMap) {
		this.map = testMap;
	}*/

}