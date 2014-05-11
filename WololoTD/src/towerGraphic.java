import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.geom.*;


public class towerGraphic {
	
	BufferedImage im2 = null;
	int posX = 60;
	int posY = 60;

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
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(im2, posX,posY,80,80,null);
		
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
}
