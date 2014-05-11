
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.geom.*;

public class Menu_2 {
	
	ImageIcon saruman = null;
	ImageIcon enemy = null;
	ImageIcon tower = null;
	ImageIcon trap = null;
	
	int mana = 0;
	int enemyCount = 0;
	
	public Menu_2() {
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("saruman.png"));
		saruman = new ImageIcon(im1.getImage().getScaledInstance(40, 45, java.awt.Image.SCALE_DEFAULT));
		ImageIcon im2 = new ImageIcon(this.getClass().getResource("hobbit_v3.gif"));
		enemy = new ImageIcon(im2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
		ImageIcon im3 = new ImageIcon(this.getClass().getResource("torony.png"));
		tower = new ImageIcon(im3.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
		ImageIcon im4 = new ImageIcon(this.getClass().getResource("tra_v2.png"));
		trap = new ImageIcon(im4.getImage().getScaledInstance(40, 50, java.awt.Image.SCALE_DEFAULT));
	}
	
	public void paintComponent(Graphics g, JPanel panel) {
       
		saruman.paintIcon(panel, g, 540, 51);
		enemy.paintIcon(panel, g, 540, 110);
		tower.paintIcon(panel, g, 530, 150);
		trap.paintIcon(panel, g, 540, 230);
		
		Font font = new Font("Serif", Font.BOLD, 20);
		g.setFont(font);
		
		g.drawString("Saruman mana:", 585, 84);
		g.drawString("Enemy:", 585, 140);
		g.drawString("Tower mana cost:", 585, 200);
		g.drawString("Trap mana cost:", 585, 260);
		g.setColor(Color.BLUE);
		g.drawString(Integer.toString(mana), 750, 84);
		g.drawString("50", 750, 200);
		g.drawString("35", 750, 260);
		g.setColor(Color.RED);
		g.drawString(Integer.toString(enemyCount), 750, 140);

		

        
    }

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
}
