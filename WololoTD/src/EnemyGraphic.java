
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.geom.*;
/**
 * Ez az ellenseg grafikus objektuma
 * @author HonorDragon
 *
 */
public class EnemyGraphic {

	ImageIcon im2 = null;
	int posX = 60;
	int posY = 60;
	int newPosX = 0;
	int newPosY = 0;
	float percent = 0;
	DrawPane container = null;
	float health = 1;

	public DrawPane getContainer() {
		return container;
	}

	public void setContainer(DrawPane container) {
		this.container = container;
	}

	/**
	 * Konstruktor
	 * @param posX	Az X. pozicio
	 * @param posY	Az Y. pozicio
	 * @param type	Az ellenseg tipusa
	 */
	public EnemyGraphic(int posX, int posY, int type) {
		
		setPosX(posX-1);
		setPosY(posY-1);
		DrawPane.addEnemyG(this);
		
		if(type == 0)
		{
		ImageIcon im = new ImageIcon(this.getClass().getResource("szakkalas_torpe.gif"));
		im2 = new ImageIcon(im.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
		}
		else if(type == 1)
		{
			ImageIcon im = new ImageIcon(this.getClass().getResource("elf_v2.gif"));
			im2 = new ImageIcon(im.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
		}
		else if(type == 2)
		{
			ImageIcon im = new ImageIcon(this.getClass().getResource("hobbit_v3.gif"));
			im2 = new ImageIcon(im.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
		}
		else if(type == 3)
		{
			ImageIcon im = new ImageIcon(this.getClass().getResource("human.gif"));
			im2 = new ImageIcon(im.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
		}
	}
	
	public EnemyGraphic() {
		ImageIcon im = new ImageIcon(this.getClass().getResource("szakkalas_torpe.gif"));
		im2 = new ImageIcon(im.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_DEFAULT));
	}
	/**
	 * Ez rajzolja ki a kepeket
	 * @param g
	 * @param panel
	 */
	public void paintComponent(Graphics g, JPanel panel) {
       try
       {
		if(panel != null && g != null)
			
			im2.paintIcon(panel, g, (int)(percent*newPosX+(1-percent)*posX), (int)(percent*newPosY+(1-percent)*posY));
       }
       catch (Exception e)
       {
    	   
       }
    }

	/**
	 * vissza adja az X poz-t
	 * @return
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * beallitja az X poz-t
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = 60 + posX*80;
	}
	/**
	 * visza adja az Y poz-t
	 * @return
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * beallitja az Y poz-t
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = 60 + posY*80;
	}
	/**
	 * vissza adja a %-ot
	 * @return
	 */
	public float getPercent() {
		return percent;
	}
	/**
	 * beallitja a %-ot
	 * @param percent
	 */
	public void setPercent(float percent) {
		this.percent = percent;
	}

	public int getNewPosX() {
		return newPosX;
	}

	public void setNewPosX(int newPosX) {
		this.newPosX = newPosX;
	}

	public int getNewPosY() {
		return newPosY;
	}

	public void setNewPosY(int newPosY) {
		this.newPosY = newPosY;
	}
	/**
	 * a halott ellenseg kepet eltuntetjuk
	 */
	public void dead()
	{
		DrawPane.removeEnemyG(this);
	}
	/**
	 * beallitjuk az ellenseg eletet ez altal lesz meretezve
	 * @param hp
	 */
	public void setHealth(float hp)
	{
		health = hp;
		im2 = getScale(im2, 60/hp);
	}
	/**
	 * vissza adja a megadott meretu kepet
	 * @param orig az eredeti kep
	 * @param size amekkorara meretezni kell
	 * @return
	 */
	private ImageIcon getScale(ImageIcon orig, float size)
	{
		return new ImageIcon(orig.getImage().getScaledInstance((int)size, (int)size, java.awt.Image.SCALE_DEFAULT));
	}
	
}
