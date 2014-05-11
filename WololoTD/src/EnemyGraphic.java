
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.geom.*;

public class EnemyGraphic {

	ImageIcon im2 = null;
	int posX = 0;
	int posY = 0;
	
	public EnemyGraphic(int posX, int posY, int type) {
		
		this.posX = posX+10;
		this.posY = posY+10;
		
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
		im2 = new ImageIcon(im.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
	}
	
	public void paintComponent(Graphics g, JPanel panel) {
       
		im2.paintIcon(panel, g, posX, posY);
        
    }

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
	
}
