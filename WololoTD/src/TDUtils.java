import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class TDUtils {

		/**
		 *  Turn on more extensive logging
		 */
		public static boolean debug = false;
		
		public static boolean end = false;
		
		/**
		 *  param of --map switch
		 */
		public static String map = "DefaultMap.xml";
		public static int mapSizeX;
		public static int mapSizeY;
		
		public static int towerCost = 50;
		public static int trapCost = 35;
		public static int towerCrystalCost = 25;
		public static int trapCrystalCost = 20;
		
		/**
		 * param of --count switch
		 * number of enemies to kill
		 * 0 : calculated from map size
		 */
		public static int enemyCount = 0;
		
		/**
		 *  param of --branch switch
		 *  0 : random
		 *  1 : first
		 *  2 : round-robin
		 */
		public static int branch = 0;
		
		public static int getMapSizeX() {
			return mapSizeX;
		}

		public static void setMapSizeX(int mapSizeX) {
			TDUtils.mapSizeX = mapSizeX;
		}

		public static int getMapSizeY() {
			return mapSizeY;
		}

		public static void setMapSizeY(int mapSizeY) {
			TDUtils.mapSizeY = mapSizeY;
		}


		/**
		 *  param of --spawn switch
		 *  0 : random
		 *  1 : first
		 */
		public static int spawn = 0;
		
		/**
		 *  param of --enemy switch
		 *  0 : random
		 *  1 : dwarf
		 *  2 : elf
		 *  3 : hobbit
		 *  4 : human
		 */
		public static int enemy = 0;
		
		/**
		 *  param of --fog switch
		 *  0 : random
		 *  1 : on
		 *  2 : off
		 */
		public static int fog = 0;
		
		/**
		 *  param of --split switch
		 *  0 : random
		 *  1 : first
		 *  2 : off
		 */
		public static int split = 0;
		
		/**
		 *  param of --log switch
		 *  if null, log only to console
		 */
		public static PrintWriter logfile;

		 /**
		  * Syslogging 
		  * @param log event to log
		  */
		public static void sLog(String log) {
			System.out.println(log);
			if (logfile != null){
				logfile.println(log);
				logfile.flush();
			}
		}
		
		/**
		  * Debug logging 
		  * @param log event to log
		  */
		public static void dLog(String log) {
			if (debug)
				sLog("[DEBUG] " + log);
		}
		
		public static int ElfHP = 50;
		public static int DwarfHP = 65;
		public static int HumanHP = 50;
		public static int HobbitHP = 30;
	
		public static float ElfSpeed = 1.f/1.1f;
		public static float DwarfSpeed = 1.f/.8f;
		public static float HumanSpeed = 1.f/1.f;
		public static float HobbitSpeed = 1.f/1.2f;
	
		public static ArrayList<Cell> mapReader(){	
			File file = new File(map);
			//Map letrehozasa
			ArrayList<Cell> map = new ArrayList<Cell>();
			
			try {	 
				//XML beolvasasa:
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);
			 	doc.getDocumentElement().normalize();
//				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
			 	//Map meretenek megallapitasa a beolvasott XML Map tagjebol:
				NodeList nListMap = doc.getElementsByTagName("Map");
				Node nNodeMap = nListMap.item(0);
				Element eElementMap = (Element) nNodeMap;
				int mapSizeX = Integer.parseInt(eElementMap.getAttribute("size_x"));
				int mapSizeY = Integer.parseInt(eElementMap.getAttribute("size_y"));
//				System.out.println("Map size x: " + mapSizeX);
//				System.out.println("Map size y: " + mapSizeY);
				setMapSizeX(mapSizeX);
				setMapSizeY(mapSizeY);
				
				
				//map feltoltese annyi default cellaval, amekkora a palya
				for (int i = 0; i < mapSizeX*mapSizeY; i++){
					Cell c = new Cell();
					map.add(c);
				}
				
				NodeList nList = doc.getElementsByTagName("Cell");
			 
//				System.out.println("----------------------------");
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
			 
					Node nNode = nList.item(temp);
			 
//					System.out.println("\nCurrent Element :" + nNode.getNodeName());
			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 
						Element eElement = (Element) nNode;
			 
//						System.out.println("Pos x : " + eElement.getElementsByTagName("Pos_x").item(0).getTextContent());
//						System.out.println("Pos y : " + eElement.getElementsByTagName("Pos_y").item(0).getTextContent());
						int posX = Integer.parseInt(eElement.getElementsByTagName("Pos_x").item(0).getTextContent());
						int posY = Integer.parseInt(eElement.getElementsByTagName("Pos_y").item(0).getTextContent());
//						System.out.println("En vagyok a " + (posX + posY*mapSizeY) +".ik cella");
						
						//A Cella szomszedainak beallitas:
						if(posX != 0 ){
							map.get(posX+ posY*mapSizeY).setNeighbour(map.get((posX + posY*mapSizeY)-1));
//							System.out.println("Szomszedom: " + ((posX + posY*mapSizeY)-1) +".ik cella");
						}
						if(posX != (mapSizeX-1) ){
							map.get(posX + posY*mapSizeY).setNeighbour(map.get((posX + posY*mapSizeY)+1));
//							System.out.println("Szomszedom: " + ((posX + posY*mapSizeY)+1) +".ik cella");
						}
						if(posY != 0 ){
							map.get(posX + posY*mapSizeY).setNeighbour(map.get((posX + posY*mapSizeY)-mapSizeX));
//							System.out.println("Szomszedom: " + ((posX + posY*mapSizeY)-mapSizeX) +".ik cella");
						}
						if(posY != (mapSizeY-1)){
							map.get(posX + posY*mapSizeY).setNeighbour(map.get((posX + posY*mapSizeY)+mapSizeX));
//							System.out.println("Szomszedom: " + ((posX + posY*mapSizeY)+mapSizeX) +".ik cella");
						}
//						System.out.println("--------------------------------------------------------");
						
						if(eElement.getElementsByTagName("Next_road").getLength() != 0){
							for(int i = 0; i < eElement.getElementsByTagName("Next_road").getLength(); i++){
//								System.out.println("Next_road : ");
								Element nextRoadElement =(Element) eElement.getElementsByTagName("Next_road").item(i);
								
								int posXNeigh = Integer.parseInt(nextRoadElement.getElementsByTagName("Pos_x").item(0).getTextContent());
								int posYNeigh = Integer.parseInt(nextRoadElement.getElementsByTagName("Pos_y").item(0).getTextContent());
								map.get(posX + posY*mapSizeY).addNext(map.get(posXNeigh + posYNeigh*mapSizeY));
//								System.out.println("Az uton a szomszedom a : " + (posXNeigh*mapSizeX + posYNeigh) + ".ik cella.");
//	
//								System.out.println("\t" + "Pos x : " + nextRoadElement.getElementsByTagName("Pos_x").item(0).getTextContent());
//								System.out.println("\t" + "Pos y : " + nextRoadElement.getElementsByTagName("Pos_y").item(0).getTextContent());
						
							}
						}
						if(eElement.getElementsByTagName("Spawn_point").getLength() != 0){
//							System.out.println("Spawn_point vagyok!");
							Road.roadList.add(map.get(posX+ posY*mapSizeY));
							map.get(posX + posY*mapSizeY).spawnPointSetter();
						}
						if(eElement.getElementsByTagName("Mount_doom").getLength() != 0){
//							System.out.println("Mount_doom vagyok!");
							map.get(posX + posY*mapSizeY).mountDoomSetter();
						}
					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			
			
			return map;
		}
	
}
