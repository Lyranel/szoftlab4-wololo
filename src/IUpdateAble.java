

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public interface IUpdateAble {

	/**
	 * 
	 * @param time
	 */
	public void incDelta(float time);

	/**
	 * 
	 * @param time
	 */
	public void update(float time);

}