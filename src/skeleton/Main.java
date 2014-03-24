package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		boolean exit = false;
		String consoleInput = "";

		while (!exit) {

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			try {
				consoleInput = bufferRead.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (consoleInput.toLowerCase().equals("testbuildtower")) {
				testBuildTower();
			}
			
			else if (consoleInput.toLowerCase().equals("testbuildtrap")) {
				testBuildTrap();
			}
			
			else if (consoleInput.toLowerCase().equals("testdeath")) {
				testDeath();
			}
			
			else if (consoleInput.toLowerCase().equals("testinitialize")) {
				testInitialize();
			}	
			
			else if (consoleInput.toLowerCase().equals("testlose")) {
				testLose();
			}
			
			else if (consoleInput.toLowerCase().equals("testmove")) {
				testMove();
			}
			
			else if (consoleInput.toLowerCase().equals("testspawn")) {
				testSpawn();
			}
			
			else if (consoleInput.toLowerCase().equals("testtowershoot")) {
				testTowerShoot();
			}
			
			else if (consoleInput.toLowerCase().equals("testtrapslow")) {
				testTrapSlow();
			}
			
			else if (consoleInput.toLowerCase().equals("testupdate")) {
				testUpdate();
			}
				
			else if (consoleInput.toLowerCase().equals("testupgradetower")) {
				testUpgradeTower();
			}
			
			else if (consoleInput.toLowerCase().equals("testupgradetrap")) {
				testUpgradeTrap();
			}
			
			else if (consoleInput.toLowerCase().equals("testwin")) {
				testWin();
			}
			
			// ---
			
			else if (consoleInput.toLowerCase().equals("exit")) {
				exit = true;
			}
			
			else if (consoleInput.toLowerCase().equals("quit")) {
				exit = true;
			}
			
			else System.out.println("Az utasitas nem ertelmezheto.");
		}
		
		System.out.println("Veget vetett a teszteknek.");
		return;
	}

	private static MiddleEarth testInit(ArrayList<Cell> testMap, ArrayList<Road> testRoadList, boolean log) {
		
		TDUtils.doLogging = log;
		
		TDUtils.simpleLog("--Init Start--");
		
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));

		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		TDUtils.simpleLog("--Init End--");
		
		TDUtils.doLogging = true;
		
		return puppetMaster;
		
	}
	
	private static void testBuildTower() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--BuildTowerTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestBuild("tower");

		TDUtils.simpleLog("--BuildTowerTeszt Complete--");
		
	}
	
	private static void testBuildTrap() {

		TDUtils.doLogging = true;
		TDUtils.simpleLog("--BuildTrapTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);	
		puppetMaster.initTestBuild("trap");

		TDUtils.simpleLog("--BuildTrapTeszt Complete--");

	}
	
	private static void testDeath() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--DeathTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestDeath(testMap,testRoadList);

		TDUtils.simpleLog("--DeathTeszt Complete--");
		
	}
	
	private static void testInitialize() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--InitializeTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,true);

		TDUtils.simpleLog("--InitializeTeszt Complete--");

	}
	
	private static void testLose() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--LoseTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestLose(testMap,testRoadList);

		TDUtils.simpleLog("--LoseTeszt Complete--");
		
	}
	
	private static void testMove() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--MoveTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestMove(testMap,testRoadList);

		TDUtils.simpleLog("--MoveTeszt Complete--");
		
	}
	
	private static void testSpawn() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--SpawnTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestSpawn(testMap,testRoadList);

		TDUtils.simpleLog("--SpawnTeszt Complete--");
			
	}
	
	private static void testTowerShoot() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--TowerShootTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestTowerShoot(testMap,testRoadList);

		TDUtils.simpleLog("--TowerShootTeszt Complete--");
		
	}
	
	private static void testTrapSlow() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--TrapSlowTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);		
		puppetMaster.initTestTrapSlow(testMap,testRoadList);

		TDUtils.simpleLog("--TrapSlowTeszt Complete--");
		
	}
	
	private static void testUpdate() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--UpdateTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);			
		puppetMaster.initTestUpdate();
		puppetMaster.update(0.2f);
		
		TDUtils.simpleLog("--UpdateTeszt Complete--");
		
	}
	
	private static void testUpgradeTower() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--UpgradeTowerTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);
		puppetMaster.initTestBuild("tower");
		puppetMaster.initTestUpgrade("tower");

		TDUtils.simpleLog("--UpgradeTowerTeszt Complete--");

	}
	
	private static void testUpgradeTrap() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--UpgradeTrapTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);
		puppetMaster.initTestBuild("trap");
		puppetMaster.initTestUpgrade("trap");

		TDUtils.simpleLog("--UpgradeTrapTeszt Complete--");

	}

	private static void testWin() {
		
		TDUtils.doLogging = true;
		TDUtils.simpleLog("--WinTeszt Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		ArrayList<Road> testRoadList = new ArrayList<Road>();	
		
		MiddleEarth puppetMaster = testInit(testMap,testRoadList,false);	
		puppetMaster.initTestWin(testMap,testRoadList);

		TDUtils.simpleLog("--WinTeszt Complete--");
		
	}

}
