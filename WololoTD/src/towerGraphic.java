import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.geom.*;

/**
 * Ez felelos a torony kirajzolasaert
 * @author HonorDragon
 *
 */
public class towerGraphic {
	
	BufferedImage im2 = null;
	int posX = 60;
	int posY = 60;
	int upgrade1 = 0;
	int upgrade2 = 0;
	int upgrade3 = 0;
	
	/**
	 * torony konstruktor
	 * @param posX	x poz
	 * @param posY	y poz
	 */
	public towerGraphic(int posX, int posY)
	{
		setPosX(posX-1);
		setPosY(posY-1);
		DrawPane.addTowerG(this);
		
		URL url = this.getClass().getResource("torony.png");
		
		try {
			im2 = ImageIO.read(url);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * kirajzolja a tornyot
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		
		g.drawImage(im2, posX,posY,80,80,null);
		
		if(upgrade1 == 0)
		{
			g.setColor(Color.GRAY);
			g.fillRect(posX+15, posY+5, 8, 8);
		}
		if(upgrade1 == 1)
		{
			g.setColor(Color.red);
			g.fillRect(posX+15, posY+5, 8, 8);
		}
		if(upgrade1 == 2)
		{
			g.setColor(Color.blue);
			g.fillRect(posX+15, posY+5, 8, 8);
		}
		if(upgrade1 == 3)
		{
			g.setColor(Color.green);
			g.fillRect(posX+15, posY+5, 8, 8);
		}
		
		if(upgrade2 == 0)
		{
			g.setColor(Color.GRAY);
			g.fillRect(posX+35, posY+5, 8, 8);
		}
		if(upgrade2 == 1)
		{
			g.setColor(Color.red);
			g.fillRect(posX+35, posY+5, 8, 8);
		}
		if(upgrade2 == 2)
		{
			g.setColor(Color.blue);
			g.fillRect(posX+35, posY+5, 8, 8);
		}
		if(upgrade2 == 3)
		{
			g.setColor(Color.green);
			g.fillRect(posX+35, posY+5, 8, 8);
		}
		
		if(upgrade3 == 0)
		{
			g.setColor(Color.GRAY);
			g.fillRect(posX+55, posY+5, 8, 8);
		}
		if(upgrade3 == 1)
		{
			g.setColor(Color.red);
			g.fillRect(posX+55, posY+5, 8, 8);
		}
		if(upgrade3 == 2)
		{
			g.setColor(Color.blue);
			g.fillRect(posX+55, posY+5, 8, 8);
		}
		if(upgrade3 == 3)
		{
			g.setColor(Color.green);
			g.fillRect(posX+55, posY+5, 8, 8);
		}
		
	}
	
	public int getPosX() {
		return posX;
	}
	/**
	 * Setter hogy konnyebb legyen a pozicio szamitasa
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = 50 + posX*80;
	}

	public int getPosY() {
		return posY;
	}
	/**
	 * Setter hogy konnyebb legyen a pozicio szamitasa
	 * @param posX
	 */
	public void setPosY(int posY) {
		this.posY = 50 + posY*80;
	}
	/**
	 * Hozza az egy upgrade-et
	 * @param i
	 */
	public void addUpgrade(int i)
	{
		if(upgrade1 == 0)
			upgrade1 = i;
		else if(upgrade2 == 0)
		{
			upgrade2 = i;
		}
		else if(upgrade3 == 0)
		{
			upgrade3 = i;
		}
	}
	
}
