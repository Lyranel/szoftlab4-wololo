
public class TDUtils {

	//logolunk vagy nem ha false akkor nem lesz logolva semmi
		public static boolean doLogging = true;

		/**
		 * Ez az egyszeru kiiratas formazva metodusok ezt hivjak meg a logolashoz
		 * @param className	az osztaly neve
		 * @param methodName a metodus neve
		 * @param input	az input amit a metodus kap
		 * @param comment komment a kiiratashoz
		 */
		 public static void callerLog(String className, String methodName, String input, String comment){
			 if(doLogging)
			 System.out.println("called: " + className + "::" + methodName + "(" + input + ")" + (comment.length() != 0 ? " -- " + comment : ""));
		 }

		 /**
		  * a create logolas formazasa
		  * @param className az osztaly neve
		  * @param instanceName az osztaly peldanyanak neve
		  * @param creatorClassName letrehozo osztaly neve
		  * @param creatorInstanceName a letrehozo osztaly peldanyanak neve
		  * @param comment komment
		  */
		 public static void createLog(String className, String instanceName, String creatorClassName, String creatorInstanceName, String comment){
			 if(doLogging)
			 System.out.println("created: " + className + ":" + instanceName + " by " + creatorClassName + ":" + creatorInstanceName + (comment.length() != 0 ? " -- " + comment : ""));
		 }
		 /**
		  * az alap logolas 
		  * @param log a szoveg amit ki akarunk iratni
		  */
		 public static void simpleLog(String log){
			 if(doLogging)
			 System.out.println(log);
		 }
		 /**
		  * kapcsolo a doLogging-nak
		  */
		 public static void Logging() {
			doLogging = !doLogging;
		}
	
	
}
