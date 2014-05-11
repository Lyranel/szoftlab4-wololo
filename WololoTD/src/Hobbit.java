

/**
 * @author HonorDragon
 * @version 1.0
 * @created 19-ápr.-2014 16:46:26
 */
public class Hobbit extends Enemy {

	//Hobbit elleneseg, gyors, de nagyon gyenge
	public Hobbit(){
		
	}

	public Hobbit(Cell sPoint, Player saruman) {
		super(sPoint,saruman);
		this.manaCost = 7;
		this.setHealth(TDUtils.HobbitHP);
		this.maxDelta = TDUtils.HobbitSpeed;
		int pos = saruman.getMapIndex(sPoint)+1;
		this.myGraph = new EnemyGraphic(pos % 6, (int)(pos/6)+1, 2);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 * 
	 * @param amount
	 */
	public void damage(int amount){
		super.damage(amount);
		if(getHealth()!=0)
			myGraph.setHealth(TDUtils.HobbitHP/getHealth());
	}

	public void move(){
		super.move();
	}

	
	public String print(){
		String print = "Hobbit - " + getHealth() + "/" + TDUtils.HobbitHP + " speed: " + ((1/maxDelta)*speed);
		return print;
	}
	
	protected void split(int health, Cell cLocation){
		Hobbit Clone = new Hobbit(cLocation, saruman);
		Clone.setHealth(health);
	}

}