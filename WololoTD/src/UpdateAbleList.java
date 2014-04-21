import java.util.ArrayList;


/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:27
 */
public class UpdateAbleList {

	private ArrayList<IUpdateAble> toUpdate;

	public UpdateAbleList(){
		toUpdate = new ArrayList<IUpdateAble>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param upd
	 */
	public void add(IUpdateAble upd){
		toUpdate.add(upd);
	}

	/**
	 * 
	 * @param upd
	 */
	public void remove(IUpdateAble upd){
		toUpdate.remove(upd);
	}

	/**
	 * 
	 * @param time
	 */
	public void update(float time){
		
		ArrayList<IUpdateAble> cpyToUpdate = new ArrayList<IUpdateAble>(toUpdate);
		
		for(IUpdateAble e: cpyToUpdate)
		{
			try
			{
				if(toUpdate.contains(e))
				{
					e.update(time);
				}
			}
			catch(NullPointerException a)
			{
				
			}
			
		}
		
		
		
	}

}