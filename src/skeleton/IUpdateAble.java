package skeleton;



/**
 * @author HonorDragon
 * @version 1.0
 * @created 08-márc.-2014 18:01:57
 */
public interface IUpdateAble {

	/**
	 * noveli a delta idot
	 * @param time
	 */
	public void incDelta(float time);

	/**
	 * update metodus
	 * @param time
	 */
	public void update(float time);

}