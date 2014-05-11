import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		boolean quit = false;
		String consoleInput = "";
		String[] command;
		MiddleEarth puppetMaster= null;;
		
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		
		View testView = new View();
		testView.setVisible(true);
		
		System.out.println("\nWelcome to WololoTD prototype.");
		System.out.println("For manual testing, please write a valid 'start' command to initialize the game.");
		System.out.println("Prepared tests can be run with the 'load' command.");
		System.out.println("The application can be closed with the 'quit' command.");
		
		while (!quit) {
			
			try {
				consoleInput = bufferRead.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Exiting WololoTD.");
				return;
			}
			
			try {
			
				command = consoleInput.split(" ");
				
				if (command[0].equals("start")) {
					
					Initialize(command);
					puppetMaster = new MiddleEarth();
					
					boolean exit = false;
					String cmdInput = "";
					String[] cmd;
					
					BufferedReader commandRead = new BufferedReader(new InputStreamReader(System.in));
					
					System.out.println("Game initialized.");
					System.out.println("To build new towers or traps, use the 'build' command.");
					System.out.println("To upgrade already existing towers or traps, use the 'upgrade' command.");
					System.out.println("To increase ingame time, use the 'update' command.");
					System.out.println("To leave the ongoing game, use the 'exit' command.");
					testView.setMap(puppetMaster.getMap());
					
					while (!exit && !TDUtils.end) {
					
						cmdInput = commandRead.readLine();
						cmd = cmdInput.split(" ");
						
						if (cmd[0].equals("exit")) {
							exit = true;
						}
						
						else {
							ExecuteCommand(puppetMaster, cmd);
							
							
						}
					}
					
					if (TDUtils.logfile != null) {
						TDUtils.logfile.close();
					}
					
					System.out.println("The game has ended.");
				}
				
				else if (command[0].equals("load")) {
					
					BufferedReader fileRead = new BufferedReader(new FileReader(command[1]));
					String line = fileRead.readLine();
					String[] cmd = line.split(" ");
					
					if (cmd[0].equals("start")) {	
						Initialize(cmd);
						puppetMaster = new MiddleEarth();
					}
					
					else {
						fileRead.close();
						throw new Exception("Test file does not start with initialization.");
					}
					
					while ((line = fileRead.readLine()) != null && !TDUtils.end) {
						cmd = line.split(" ");
						ExecuteCommand(puppetMaster, cmd);
					}
					
					if (TDUtils.logfile != null) {
						TDUtils.logfile.close();
					}
					
					System.out.println("The game has ended.");
					System.out.println("If you wish to validate your test results, please use the 'validate' command.");
					System.out.println("To exit, type 'exit'.");
					
					BufferedReader validateRead = new BufferedReader(new InputStreamReader(System.in));
					String validateInput = "";
					String[] validateCmd;
					boolean exit = false;
					
					while (!exit) {
						
						validateInput = validateRead.readLine();
						validateCmd = validateInput.split(" ");
						
						if (validateCmd[0].equals("validate")) {	
							DiffTool validator = new DiffTool(validateCmd[1], validateCmd[2]);
							int result = validator.diffFile();
							
							if (result == 0) {
								System.out.println("Test result: PASS");
							}
							else System.out.println("Test result: FAIL");
							
							exit = true;
							quit = true;
						}
						
						else if (validateCmd[0].equals("exit")) {
							exit = true;
							quit = true;
						}
						
						else throw new Exception("Unrecognized command.");
					}
					
					
				}
				
				else if (consoleInput.toLowerCase().equals("quit")) {
					quit = true;
				}
				
				else throw new Exception("Unrecognized command.");
		
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exiting WololoTD.");
				return;
			}
			
		}
		
		System.out.println("Exiting WololoTD.");
		return;
	}
	
	public static void Initialize(String[] command) throws Exception {
		
		TDUtils.end = false;
		
		for (int i = 1; i < command.length; i+=2) {
			
			if (command[i].equals("-M") || command[i].equals("--map")) {
				TDUtils.map = command[i+1];
			}
			
			else if (command[i].equals("-B") || command[i].equals("--branch")) {
				
				if (command[i+1].equals("random")) {
					TDUtils.branch = 0;
				}
				
				else if (command[i+1].equals("first")) {
					TDUtils.branch = 1;
				}
				
				else if (command[i+1].equals("rr")) {
					TDUtils.branch = 2;
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else if (command[i].equals("-S") || command[i].equals("--spawn")) {
				
				if (command[i+1].equals("random")) {
					TDUtils.spawn = 0;
				}
				
				else if (command[i+1].equals("first")) {
					TDUtils.spawn = 1;
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else if (command[i].equals("-E") || command[i].equals("--enemy")) {
				
				if (command[i+1].equals("random")) {
					TDUtils.enemy = 0;
				}
				
				else if (command[i+1].equals("dwarf")) {
					TDUtils.enemy = 1;
				}
				
				else if (command[i+1].equals("elf")) {
					TDUtils.enemy = 2;
				}
				
				else if (command[i+1].equals("hobbit")) {
					TDUtils.enemy = 3;
				}
				
				else if (command[i+1].equals("human")) {
					TDUtils.enemy = 4;
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else if (command[i].equals("-F") || command[i].equals("--fog")) {
				
				if (command[i+1].equals("random")) {
					TDUtils.fog = 0;
				}
				
				else if (command[i+1].equals("on")) {
					TDUtils.fog = 1;
				}
				
				else if (command[i+1].equals("off")) {
					TDUtils.fog = 2;
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else if (command[i].equals("-P") || command[i].equals("--split")) {
				
				if (command[i+1].equals("random")) {
					TDUtils.split = 0;
				}
				
				else if (command[i+1].equals("first")) {
					TDUtils.split = 1;
				}
				
				else if (command[i+1].equals("off")) {
					TDUtils.split = 2;
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else if (command[i].equals("-C") || command[i].equals("--count")) {
				
				int count = Integer.parseInt(command[i+1]);
				
				if (count >= 0) {
					TDUtils.enemyCount = count;
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else if (command[i].equals("-L") || command[i].equals("--log")) {
				TDUtils.logfile = new PrintWriter(command[i+1]);
			}
			
			else throw new Exception("Unrecognized command.");
		}
	}
	
	public static void ExecuteCommand(MiddleEarth puppetMaster, String[] command) throws Exception {
		
		if (command[0].equals("build")) {
			
			String type = null;
			String[] position = null;
			
			for (int i = 1; i < command.length; i+=2) {
				
				if (command[i].equals("-T") || command[i].equals("--type")) {
					type = command[i+1];
				}
				
				else if (command[i].equals("-P") || command[i].equals("--position")) { 
					position = command[i+1].split(",");
				}
			}
			
			PlayerControlled building;
			
			if (type != null && position != null) {
			
				if (type.equals("tower")) {
					puppetMaster.getPlayer().buildTower(Integer.parseInt(position[1]), Integer.parseInt(position[0]));
				}
			
				else if (type.equals("trap")) {
					puppetMaster.getPlayer().buildTrap(Integer.parseInt(position[1]), Integer.parseInt(position[0]));
				}
				
				else throw new Exception("Unrecognized command.");
			}
			
			else throw new Exception("Unrecognized command.");
			
		}
		
		else if (command[0].equals("upgrade")) {
			
			String type = null;
			String[] position = null;
			
			for (int i = 1; i < command.length; i+=2) {
				
				if (command[i].equals("-C") || command[i].equals("--crystal")) {
					type = command[i+1];
				}
				
				else if (command[i].equals("-P") || command[i].equals("--position")) { 
					position = command[i+1].split(",");
				}
				
				else throw new Exception("Unrecognized command.");
				
			}
			
			if (type != null && position != null) {
				
				if (type.equals("damage") && 
						puppetMaster.getCell(Integer.parseInt(position[1]), Integer.parseInt(position[0])).getState() == State.TOWER) {
					puppetMaster.getPlayer().upgradeTower(Integer.parseInt(position[1]), Integer.parseInt(position[0]), new DmgC());
				}
				
				else if (type.equals("range") && 
						puppetMaster.getCell(Integer.parseInt(position[1]), Integer.parseInt(position[0])).getState() == State.TOWER) {
					puppetMaster.getPlayer().upgradeTower(Integer.parseInt(position[1]), Integer.parseInt(position[0]), new RangeC());
				}
				
				else if (type.equals("speed") && 
						puppetMaster.getCell(Integer.parseInt(position[1]), Integer.parseInt(position[0])).getState() == State.TOWER) {
					puppetMaster.getPlayer().upgradeTower(Integer.parseInt(position[1]), Integer.parseInt(position[0]), new SpeedC());
				}
				
				else if (type.equals("trap") && 
						puppetMaster.getCell(Integer.parseInt(position[1]), Integer.parseInt(position[0])).getState() == State.TRAP) {
					puppetMaster.getPlayer().upgradeTrap(Integer.parseInt(position[1]), Integer.parseInt(position[0]), new TrapC());
				}
				
				else {
					System.out.println(type);
					System.out.println(position[0] + "," + position[1]);
					System.out.println(puppetMaster.getCell(Integer.parseInt(position[0]), Integer.parseInt(position[1])).getState().toString());
					throw new Exception("Unrecognized command.");
				}
			}
			
		}
		
		else if (command[0].equals("update")) {
			
			if (command.length == 1) {
				puppetMaster.update(1);
			}
			
			else if (command[1].equals("-T") || command[1].equals("--time")) {
				puppetMaster.update(Float.parseFloat(command[2]));
			}
			
			else throw new Exception("Unrecognized command.");
			
		}
		
		else throw new Exception("Unrecognized command.");
	}
	
	
}