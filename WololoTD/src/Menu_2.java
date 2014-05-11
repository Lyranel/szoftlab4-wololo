
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

	JButton u_green;
	JButton u_blue;
	JButton u_red;
	
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
		
		u_green = new JButton("Speed upgrade");
		u_green.setBackground(new Color(100,238,17));
		u_green.setForeground(Color.black);
		u_green.setToolTipText("Upgrade tower with speed for 25 mana.");
		u_green.setFocusPainted(false);
		
		u_red = new JButton("Power upgrade");
		u_red.setBackground(new Color(252,77,1));
		u_red.setForeground(Color.black);
		u_red.setToolTipText("Upgrade tower with power for 25 mana.");
		u_red.setFocusPainted(false);
		
		u_blue = new JButton("Range upgrade");
		u_blue.setBackground(new Color(7,168,251));
		u_blue.setForeground(Color.black);
		u_blue.setToolTipText("Upgrade the tower's range for 25 mana.");
		u_blue.setFocusPainted(false);
		
        u_blue.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
              
                System.out.println("You clicked the button");
            }
        });   
	}

	public void paintComponent(Graphics g, JPanel panel) {
       
		u_blue.setLocation(540, 415);
		u_red.setLocation(540, 375);
		u_green.setLocation(540, 335);
		
		u_green.setSize(235, 30);
		u_red.setSize(235, 30);
		u_blue.setSize(235, 30);
		
		panel.add(this.u_blue);
		panel.add(this.u_green);
		panel.add(this.u_red);
		
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
		g.drawString("Tower upgrade cost:", 540, 320);
		g.drawString("Trap upgrade cost:", 540, 490);
		
		g.setColor(Color.BLUE);
		g.drawString(Integer.toString(mana), 750, 84);
		g.drawString("50", 750, 200);
		g.drawString("35", 750, 260);
		g.drawString("25", 750, 320);
		g.drawString("20", 750, 490);
		
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
