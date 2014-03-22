package skeleton;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	if(args.length ==0){
		System.out.println("Nem kaptam argomentumot");
	}
	else{
		
	if (args[0].equals("TestBuildTower")) {
	   testBuildTower();
	}

	if (args[0].equals("TestBuildTrap")) {
		   testBuildTrap();
		}
	
	if (args[0].equals("TestInitialize")) {
		   testInitialize();
		}
	}
	return;
	}

	private static void testInitialize() {	
		
		//Negyzetracsos 3*3 teszt palyank lesz
		List<Cell> testMap = new ArrayList<Cell>();
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
		testMap.add(new Cell());
	
		//Betolti a teszt terkepet
		//es beallitja a cellak szomszedait.
		MiddleEarth puppetMaster = new MiddleEarth(testMap);
		
		
		
		
		
		
		
	}

	private static void testBuildTrap() {
		MiddleEarth puppetMaster = new MiddleEarth();
		
	}

	private static void testBuildTower() {
		MiddleEarth puppetMaster = new MiddleEarth();
		
		
	}

}
