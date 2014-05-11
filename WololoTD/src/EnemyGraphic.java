
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.geom.*;

public class EnemyGraphic {

	ImageIcon im2 = null;
	int posX = 60;
	int posY = 60;
	int newPosX = 0;
	int newPosY = 0;
	float percent = 0;
	DrawPane container = null;
	

	public DrawPane getContainer() {
		return container;
	}

	public void setContainer(DrawPane container) {
		this.container = container;
	}

	public EnemyGraphic(int posX, int posY, int type) {
		
		
		
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
	
	public void paintComponent(Graphics g, JPanel panel) {
       
		im2.paintIcon(panel, g, (int)(percent*newPosX+(1-percent)*posX), (int)(percent*newPosY+(1-percent)*posY));
        
    }

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = 60 + posX*80;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = 60 + posY*80;
	}
	
	public float getPercent() {
		return percent;
	}

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
	
	
}
