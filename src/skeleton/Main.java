package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

			if (consoleInput.toLowerCase().equals("testbuildtrap")) {
				testBuildTrap();
			}

			if (consoleInput.toLowerCase().equals("testinitialize")) {
				testInitialize();
			}
			
			if (consoleInput.toLowerCase().equals("testupdate")) {
				testUpdate();
			}
			
			if (consoleInput.toLowerCase().equals("testspawn")) {
				testSpawn();
			}
			
			if (consoleInput.toLowerCase().equals("testmove")) {
				testMove();
			}
			
			if (consoleInput.toLowerCase().equals("exit")) {
				exit = true;
			}
			if (consoleInput.toLowerCase().equals("quit")) {
				exit = true;
			}
		}
		System.out.println("Veget vetett a teszteknek.");
		return;
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
		ArrayList testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));
		
		
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);
		
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
		ArrayList testRoad = new ArrayList<Cell>();
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
		ArrayList testRoad = new ArrayList<Cell>();
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
		ArrayList testRoad = new ArrayList<Cell>();
		testRoad.add(testMap.get(0));
		testRoad.add(testMap.get(1));
		testRoadList.add(new Road(testRoad));

		// Betolti a teszt terkepet
		// es beallitja a cellak szomszedait.
		// es beallitja az utakat is
		MiddleEarth puppetMaster = new MiddleEarth(testMap, testRoadList);

	}

	private static void testBuildTrap() {
		MiddleEarth puppetMaster = new MiddleEarth();
	}
	private static void testBuildTower() {
		MiddleEarth puppetMaster = new MiddleEarth();

	}

}
