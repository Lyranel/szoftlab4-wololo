package skeleton;

import java.util.ArrayList;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:02:10
 */
public class UpdateAbleList {

	private ArrayList<IUpdateAble> toUpdate;
	private boolean gamePaused = false;

	/**
	 * @return the gamePaused
	 */
	public boolean isGamePaused() {
		return gamePaused;
	}

	/**
	 * @param gamePaused the gamePaused to set
	 */
	public void setGamePaused(boolean gamePaused) {
		this.gamePaused = gamePaused;
	}

	public UpdateAbleList(){
		TDUtils.callerLog("UpdateAbleList", "UpdateAbleList", "", " a konstruktor lefutott");
		
		toUpdate = new ArrayList<IUpdateAble>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param upd
	 */
	public void add(IUpdateAble upd){
		TDUtils.callerLog("UpdateAbleList", "add", "IUpdateAble", " elemet adtunk hozza");
		
		toUpdate.add(upd);
	}

	/**
	 * 
	 * @param upd
	 */
	public void remove(IUpdateAble upd){
		TDUtils.callerLog("UpdateAbleList", "remove", "IUpdateAble", " elemet tavolitottunk el");
		
		toUpdate.remove(upd);
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		
		TDUtils.callerLog("UpdateAbleList", "update", Float.toString(time), " a delta ido");
		
		for(IUpdateAble e: toUpdate)
		{
			if(!gamePaused)
			{
				e.update(time);
			}
		}
		
		
	}


}