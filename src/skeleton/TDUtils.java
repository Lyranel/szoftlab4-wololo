package skeleton;

public class TDUtils {
	
	public static boolean doLogging = true;

	 public static void callerLog(String className, String methodName, String input, String comment){
		 if(doLogging)
		 System.out.println("called: " + className + "::" + methodName + "(" + input + ")" + (comment.length() != 0 ? " -- " + comment : ""));
	 }
	 
	 public static void createLog(String className, String instanceName, String creatorClassName, String creatorInstanceName, String comment){
		 if(doLogging)
		 System.out.println("created: " + className + ":" + instanceName + " by " + creatorClassName + ":" + creatorInstanceName + (comment.length() != 0 ? " -- " + comment : ""));
	 }
	 
	 public static void simpleLog(String log){
		 if(doLogging)
		 System.out.println(log);
	 }
	 
	 public static void Logging() {
		doLogging = !doLogging;
	}
	 

}
