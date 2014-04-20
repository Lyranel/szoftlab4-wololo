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
		
		/**
		 *  param of --map switch
		 */
		public static String map = "DefaultMap.xml";
		public static int mapSizeX;
		public static int mapSizeY;
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
		 *  2 : round-robin
		 */
		public static int spawn = 0;
		
		/**
		 *  param of --enemy switch
		 *  0 : random
		 *  1 : round-robin
		 *  2 : dwarf
		 *  3 : elf
		 *  4 : hobbit
		 *  5 : human
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
			if (logfile != null)
				logfile.println(log);
		}
		
		/**
		  * Debug logging 
		  * @param log event to log
		  */
		public static void dLog(String log) {
			if (debug)
				sLog("[DEBUG] " + log);
		}
	
	
		public static ArrayList<Cell> mapReader(){	
			File file = new File("C:/Users/Agi/Downloads/DefaultMap.xml");
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
