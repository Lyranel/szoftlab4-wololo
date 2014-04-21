import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class DiffTool {

	//TODO Egyelore Stringjei vannak, lehet, hogy fajlra kelle majd valtoztatni
	private String expected;
	private String actual;
	private File expectedFile;
	private File actualFile;
	
	public DiffTool(String expected, String actual){
		this.expected = expected;
		this.actual = actual;
	}
	
	public DiffTool(File expectedFile, File actualFile){
		this.expectedFile = expectedFile;
		this.actualFile = actualFile;
	}


	public int diffString(){
		return expected.compareTo(actual);
	}
	
	public int diffFile(){
		List<String> expectedList = fileToLines(expectedFile);
		List<String> actualList = fileToLines(actualFile);
		if(expectedList.size() != actualList.size()){
			return  -1;
		}
		int diff = 0;
		for(int i = 0; i < expectedList.size(); i++){
			diff = expectedList.get(i).compareTo(actualList.get(i));
			if(diff != 0){
				return -1;
			}
		}
		return diff;
	}
	
	  private static List<String> fileToLines(File filename) {
          List<String> lines = new LinkedList<String>();
          String line = "";
          try {
                  BufferedReader in = new BufferedReader(new FileReader(filename));
                  while ((line = in.readLine()) != null) {
                          lines.add(line);
                  }
          } catch (IOException e) {
                  e.printStackTrace();
          }
          return lines;
  }


}
