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
	public MiddleEarth(List<Cell> testMap, ArrayList<Road> testRoad){
		System.out.println("called: MddleEarth_MiddleEarth: " + testMap.size() + " cellat kaptam.");
		
		this.map = testMap;
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		System.out.println("created: ArrayList<Cell> Named:map_by_MiddleEarth Named: puppetMaster");
		
		//test palya megteremetese 
		map.get(0).setNeighbour(map.get(1),1);
		map.get(0).setNeighbour(map.get(2),2);
		map.get(0).setNeighbour(map.get(3),3);
		map.get(0).setNeighbour(map.get(4),4);	
		
		//Vegig megy az uton, es az aktualis cellanak beallitja
		//az uton a kovetkezot kovetkezonek
		for(Road r : testRoad){
		
			for (int i = 0; i < r.roadList.size()-1; ++i){
				r.roadList.get(i).setNext(r.roadList.get(i+1));
			}
		}
		ArrayList<Cell> firstRoadElementsList = new ArrayList<Cell>();
		for(Road r : testRoad){
			firstRoadElementsList.add(r.roadList.get(0));
		}
		
		Spawn testSpawn = new Spawn(firstRoadElementsList);
		Player testSaruman = new Player();
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