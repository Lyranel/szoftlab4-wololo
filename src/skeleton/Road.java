package skeleton;

import java.util.ArrayList;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 15-márc.-2014 13:11:02
 */
public class Road {

	public ArrayList<Cell> roadList;	//cella list az egyma utani cellakot tartalmazza

	public Road(ArrayList<Cell> roadList){
		this.roadList = roadList;
	}
	public Road(){

	}

	public void finalize() throws Throwable {

	}

}