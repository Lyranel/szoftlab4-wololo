package skeleton;

import java.util.ArrayList;
import java.util.List;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:58
 */
public class MiddleEarth {

	private ArrayList<Cell> map;
	private Player saruman;
	private UpdateAbleList updateList;
	
	public MiddleEarth(){
		
	}
	
	//teszthez szukseges konstruktor (igy konynen tudjuk inicializalni a teszt palyat)
	public MiddleEarth(ArrayList<Cell> testMap, ArrayList<Road> testRoad){
		updateList = UpdateAble.getUpdateList();
		
		TDUtils.callerLog("MiddleEarth", "MiddleEarth", "ArrayList<Cell>, ArrayList<Road>", "");
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		this.map = testMap;
		TDUtils.createLog("List<Cell>", "map", "MiddleEarth", "puppetMaster", "");
		
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
			r.roadList.get(r.roadList.size()-1).setNext(null);
		}
		ArrayList<Cell> firstRoadElementsList = new ArrayList<Cell>();
		for(Road r : testRoad){
			firstRoadElementsList.add(r.roadList.get(0));
		}
		
		Spawn testSpawn = new Spawn(firstRoadElementsList,saruman);
		TDUtils.createLog("Spawn", "testSpawn", "MiddleEarth", "puppetMaster", "");
		Player testSaruman = new Player(this, testSpawn.getMaxCount());
		this.saruman = testSaruman;
		TDUtils.createLog("Player", "testSpawn", "MiddleEarth", "puppetMaster", "");
		
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
		return map.get(x);

	}

	public Player getPlayer(){
		return null;
	}

	public void lose(){
		TDUtils.callerLog("MiddelEarth", "lose", "", "Saruman elbukott");
		TDUtils.doLogging = false;
		//updateList.setGamePaused(true);
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		TDUtils.callerLog("MiddleEarth", "update", Float.toString(time), "elkezdodik az update");
		updateList.update(time);
	}

	public void win(){
		TDUtils.callerLog("MiddleEarth", "win", "", "az ellenseg elfogyott Szaruman epp fenyes gyozelmet arat!");
		TDUtils.Logging();
		//updateList.setGamePaused(true);
	}
	
	////Teszteleshez kello fuggvenyek:
	public List<Cell> getMap() {
		return map;
	}

/*	public void setMap(List<Cell> testMap) {
		this.map = testMap;
	}*/
	
	public void initTestUpdate()
	{
		updateList.reset();
		
		Dwarf secondDwarfEnemy = new Dwarf();
		Dwarf thirdDwarfEnemy = new Dwarf();
		
		Elf secondElfEnemy = new Elf();
		Elf thirdElfEnemy = new Elf();
		
		Human secondHumanEnemy = new Human();
		Human thirdHumanEnemy = new Human();
		
		Hobbit secondHobbitEnemy = new Hobbit();
		Hobbit thirdHobbitEnemy = new Hobbit();
		
		Tower firstPlaceAble = new Tower();
		Trap  secondPlaceAble = new Trap();
		
	}

	
	public void initTestSpawn(ArrayList<Cell> testMap, ArrayList<Road> testRoad) {
		
		updateList = UpdateAble.getUpdateList();
		
		TDUtils.callerLog("MiddleEarth", "MiddleEarth", "ArrayList<Cell>, ArrayList<Road>", "");
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		this.map = testMap;
		TDUtils.createLog("List<Cell>", "map", "MiddleEarth", "puppetMaster", "");
		
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
		
		Spawn testSpawn = new Spawn(firstRoadElementsList,saruman);
		TDUtils.createLog("Spawn", "testSpawn", "MiddleEarth", "puppetMaster", "");
		Player testSaruman = new Player(this, testSpawn.getMaxCount());
		TDUtils.createLog("Player", "testSpawn", "MiddleEarth", "puppetMaster", "");
		
		TDUtils.doLogging = true;
		
		TDUtils.simpleLog("--SpawnTeszt Start--");
		
		
		testSpawn.update(0.6f);
		testSpawn.update(0.6f);
		testSpawn.update(0.6f);
		
		TDUtils.simpleLog("--SpawnTeszt Complete--");
		
		
	}

	public void initTestMove(ArrayList<Cell> testMap, ArrayList<Road> testRoad) {
		
		updateList = UpdateAble.getUpdateList();
		
		TDUtils.callerLog("MiddleEarth", "MiddleEarth", "ArrayList<Cell>, ArrayList<Road>", "");
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		this.map = testMap;
		TDUtils.createLog("List<Cell>", "map", "MiddleEarth", "puppetMaster", "");
		
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
		
		Player testSaruman = new Player(this, 1);
		TDUtils.createLog("Player", "testSpawn", "MiddleEarth", "puppetMaster", "");
		this.saruman = testSaruman;
		
		Spawn testSpawn = new Spawn(firstRoadElementsList,saruman);
		TDUtils.createLog("Spawn", "testSpawn", "MiddleEarth", "puppetMaster", "");
		
		
		Dwarf testDwarf = new Dwarf(map.get(0), saruman);
		
		map.get(0).setNext(map.get(1));

		TDUtils.doLogging = true;
		
		TDUtils.simpleLog("--MoveTeszt Start--");
		
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		
		
	
		
		TDUtils.simpleLog("--MoveTeszt Complete--");
		
	}

	public void initTestLose(ArrayList<Cell> testMap, ArrayList<Road> testRoad) {
		updateList = UpdateAble.getUpdateList();
		
		TDUtils.callerLog("MiddleEarth", "MiddleEarth", "ArrayList<Cell>, ArrayList<Road>", "");
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		this.map = testMap;
		TDUtils.createLog("List<Cell>", "map", "MiddleEarth", "puppetMaster", "");
		
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
		
		Player testSaruman = new Player(this, 1);
		TDUtils.createLog("Player", "testSpawn", "MiddleEarth", "puppetMaster", "");
		this.saruman = testSaruman;
		
		Spawn testSpawn = new Spawn(firstRoadElementsList,saruman);
		TDUtils.createLog("Spawn", "testSpawn", "MiddleEarth", "puppetMaster", "");
		
		
		Dwarf testDwarf = new Dwarf(map.get(0), saruman);
		
		map.get(0).setNext(map.get(1));
		
		TDUtils.doLogging = true;
		
		TDUtils.simpleLog("--DeathTeszt Start--");
		
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		testDwarf.update(0.6f);
		
		TDUtils.doLogging = true;
		
		TDUtils.simpleLog("--DeathTeszt Complete--");
		
	}

	public void initTestDeath(ArrayList<Cell> testMap,ArrayList<Road> testRoad) {
		updateList = UpdateAble.getUpdateList();
		
		TDUtils.callerLog("MiddleEarth", "MiddleEarth", "ArrayList<Cell>, ArrayList<Road>", "");
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		this.map = testMap;
		TDUtils.createLog("List<Cell>", "map", "MiddleEarth", "puppetMaster", "");
		
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
		
		Player testSaruman = new Player(this, 2);
		TDUtils.createLog("Player", "testSpawn", "MiddleEarth", "puppetMaster", "");
		this.saruman = testSaruman;
		
		Spawn testSpawn = new Spawn(firstRoadElementsList,saruman);
		TDUtils.createLog("Spawn", "testSpawn", "MiddleEarth", "puppetMaster", "");
		
		
		Dwarf testDwarf = new Dwarf(map.get(0), saruman);
		
		map.get(0).setNext(map.get(1));
		
		TDUtils.doLogging = true;
		
		
		TDUtils.simpleLog("--DeathTeszt Start--");
		
		testDwarf.damage(10);
		
		TDUtils.simpleLog("--DeathTeszt Complete--");
		
	}

	public void initTestWin(ArrayList<Cell> testMap,ArrayList<Road> testRoad) {
		
		updateList = UpdateAble.getUpdateList();
		
		TDUtils.callerLog("MiddleEarth", "MiddleEarth", "ArrayList<Cell>, ArrayList<Road>", "");
		
		//A teszt soran kapja a cella-listat
		//a jatek folyaman ezt file-bol fogja olvasni 
		this.map = testMap;
		TDUtils.createLog("List<Cell>", "map", "MiddleEarth", "puppetMaster", "");
		
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
		
		Player testSaruman = new Player(this, 1);
		TDUtils.createLog("Player", "testSpawn", "MiddleEarth", "puppetMaster", "");
		this.saruman = testSaruman;
		
		Spawn testSpawn = new Spawn(firstRoadElementsList,saruman);
		TDUtils.createLog("Spawn", "testSpawn", "MiddleEarth", "puppetMaster", "");
		
		
		Dwarf testDwarf = new Dwarf(map.get(0), saruman);
		
		map.get(0).setNext(map.get(1));
		
		TDUtils.doLogging = true;
		
		
		TDUtils.simpleLog("--WinTeszt Start--");
		
		testDwarf.damage(10);
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--WinTeszt Complete--");
		
	}
	
	public void initTestBuild(String type) {
		
		this.saruman.testBuild(type);
		
	}
	
	public void initTestUpgrade(String type) {
		
		this.saruman.testUpgrade(type);
		
	}
	

}