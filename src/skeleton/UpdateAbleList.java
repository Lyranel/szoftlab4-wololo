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
	/**
	 * letrehozom az uj updatelistat
	 */
	public UpdateAbleList(){
		TDUtils.callerLog("UpdateAbleList", "UpdateAbleList", "", " a konstruktor lefutott");
		
		toUpdate = new ArrayList<IUpdateAble>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * uj elemet adunk a listahoz
	 * @param upd
	 */
	public void add(IUpdateAble upd){
		TDUtils.callerLog("UpdateAbleList", "add", "IUpdateAble", " elemet adtunk hozza");
		
		toUpdate.add(upd);
	}

	/**
	 * elemet veszunk ki a listabol
	 * @param upd
	 */
	public void remove(IUpdateAble upd){
		TDUtils.callerLog("UpdateAbleList", "remove", "IUpdateAble", " elemet tavolitottunk el");
		
		toUpdate.remove(upd);
	}

	/**
	 * update-et meghivjuk az osszes elemen konkurrencia miatt egy masolat listan dolgozik
	 * @param time
	 */
	public void update(float time){
		
		TDUtils.callerLog("UpdateAbleList", "update", Float.toString(time), " a delta ido");
		//csinalunk egy masolat mert ha a lista valtozna menet kozben akkor az exception-t eredmenyezne
		ArrayList<IUpdateAble> cpyToUpdate = new ArrayList<IUpdateAble>(toUpdate);
		
		for(IUpdateAble e: cpyToUpdate)
		{
			if(!gamePaused)
			{
				e.update(time);
			}
		}
		
		
	}
	/**
	 * resetelem a listat mivel uj futtatas eseten ki kell uriteni
	 */
	public void reset()
	{
		toUpdate = new ArrayList<IUpdateAble>();
	
	}


}