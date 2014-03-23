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
			
			else if (consoleInput.toLowerCase().equals("testupgradetower")) {
				testUpgradeTower();
			}
			
			else if (consoleInput.toLowerCase().equals("testupgradetrap")) {
				testUpgradeTrap();
			}

			else if (consoleInput.toLowerCase().equals("testinitialize")) {
				testInitialize();
			}
			
			else if (consoleInput.toLowerCase().equals("testupdate")) {
				testUpdate();
			}
			
			else if (consoleInput.toLowerCase().equals("testspawn")) {
				testSpawn();
			}
			
			else if (consoleInput.toLowerCase().equals("testmove")) {
				testMove();
			}
			
			else if (consoleInput.toLowerCase().equals("testlose")) {
				testLose();
			}
			
			if (consoleInput.toLowerCase().equals("testdeath")) {
				testDeath();
			}
			
			if (consoleInput.toLowerCase().equals("testwin")) {
				testWin();
			}
			
			if (consoleInput.toLowerCase().equals("exit")) {
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

	private static void testWin() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth();
		
		TDUtils.simpleLog("--Init Complete--");
		
		puppetMaster.initTestWin(testMap, testRoadList);
		
	}

	private static void testDeath() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth();
		
		TDUtils.simpleLog("--Init Complete--");
		
		puppetMaster.initTestDeath(testMap, testRoadList);
		
	}

	private static void testLose() {
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth();
		
		TDUtils.simpleLog("--Init Complete--");
		
		puppetMaster.initTestLose(testMap, testRoadList);
		
	}

	private static void testMove() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth();
		
		TDUtils.simpleLog("--Init Complete--");
		
		puppetMaster.initTestMove(testMap, testRoadList);
		
	}

	private static void testSpawn() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		TDUtils.simpleLog("--Init Complete--");
		
		puppetMaster.initTestSpawn(testMap, testRoadList);
		
		
		
	}

	private static void testUpdate() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		TDUtils.simpleLog("--Init Complete--");
		
		TDUtils.doLogging = true;
		
		TDUtils.simpleLog("--UpdateTeszt Start--");
		
		puppetMaster.initTestUpdate();
		puppetMaster.update(0.2f);
		
		TDUtils.simpleLog("--UpdateTeszt Complete--");
		
		
	}

	private static void testInitialize() {

		// Negyzetracsos 3*3 teszt palyank lesz
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));

		// Betolti a teszt terkepet
		// es beallitja a cellak szomszedait.
		// es beallitja az utakat is
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);

	}

	private static void testBuildTower() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		TDUtils.simpleLog("--Init Complete--");
		
		TDUtils.doLogging = true;
		
		puppetMaster.initTestBuild("tower");
		
	}
	
	private static void testBuildTrap() {

		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		TDUtils.simpleLog("--Init Complete--");
		
		TDUtils.doLogging = true;
		
		puppetMaster.initTestBuild("trap");

	}
	
	private static void testUpgradeTower() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		puppetMaster.initTestBuild("tower");
		
		TDUtils.simpleLog("--Init Complete--");
		
		TDUtils.doLogging = true;
		
		puppetMaster.initTestUpgrade("tower");

	}
	
	private static void testUpgradeTrap() {
		
		TDUtils.doLogging = false;
		
		TDUtils.simpleLog("--Init Start--");
		
		ArrayList<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());

		ArrayList<Road> testRoadList = new ArrayList<Road>();
		ArrayList<Cell> testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
		puppetMaster.initTestBuild("trap");
		
		TDUtils.simpleLog("--Init Complete--");
		
		TDUtils.doLogging = true;
		
		puppetMaster.initTestUpgrade("trap");

	}

}
