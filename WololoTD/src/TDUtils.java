import java.io.PrintWriter;


public class TDUtils {

		/**
		 *  Turn on more extensive logging
		 */
		public static boolean debug = false;
		
		/**
		 *  param of --log switch
		 *  if null, log only to console
		 */
		public static PrintWriter logfile;
		
		/**
		 *  param of --branch switch
		 *  0 : random
		 *  1 : first
		 *  2 : round-robin
		 */
		public static int branch = 0;
		
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
	
	
}
