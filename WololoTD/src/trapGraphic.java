import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.geom.*;

public class trapGraphic {

	BufferedImage im2 = null;
	int posX = 60;
	int posY = 60;
	int upgradeLvl = 0;
	
	public trapGraphic(int posX, int posY)
	{
		setPosX(posX-1);
		setPosY(posY-1);
		DrawPane.addTrapG(this);
		
		URL url = this.getClass().getResource("tra_v2.png");
		
		try {
			im2 = ImageIO.read(url);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		if(upgradeLvl == 0)
		{
			g.drawImage(im2, posX,posY,80,80,null);
		}
		else if(upgradeLvl == 1)
		{
			g.drawImage(im2, posX,posY,80/2,80/2,null);
			g.drawImage(im2, posX+80/2,posY,80/2,80/2,null);
			g.drawImage(im2, posX,posY+80/2,80/2,80/2,null);
			g.drawImage(im2, posX+80/2,posY+80/2,80/2,80/2,null);
		}
		else if(upgradeLvl == 2)
		{
			for(int i = 0; i < 4; i++)
			{
				for(int l = 0; l < 4; l++)
				{
					g.drawImage(im2, posX+i*80/4,posY+l*80/4,80/4,80/4,null);
				}
			}
		}
		else if(upgradeLvl == 3)
		{
			for(int i = 0; i < 8; i++)
			{
				for(int l = 0; l < 8; l++)
				{
					g.drawImage(im2, posX+i*80/8,posY+l*80/8,80/8,80/8,null);
				}
			}
		}
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = 50 + posX*80;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = 50 + posY*80;
	}
	
	public void upgrade()
	{
		upgradeLvl++;
	}
	
}
