import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.geom.*;


public class DrawPane extends JPanel{

	Map map;
	EnemyGraphic enemy;
	Menu_2 menu;
	
	public DrawPane() {
        setPreferredSize(new Dimension(600, 600));
        map = new Map();
        enemy = new EnemyGraphic(130,130,2);
        menu = new Menu_2();
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.paintComponent(g);
        enemy.paintComponent(g, this);
        menu.paintComponent(g, this, 120, 40);
    }
	
	public void setMap(ArrayList<Cell> mapC)
	{
		map.setMap(mapC);
	}
	
}
