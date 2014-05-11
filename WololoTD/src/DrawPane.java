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
	//EnemyGraphic enemy;
	static ArrayList<EnemyGraphic> eList;
	static ArrayList<towerGraphic> towerList;
	static ArrayList<trapGraphic> trapList;
	
	public DrawPane() {
        setPreferredSize(new Dimension(600, 600));
        map = new Map();
       // enemy = new EnemyGraphic(0,0,2);
       // enemy.setPosX(1);
       // enemy.setPosY(2);
        eList = new ArrayList<EnemyGraphic>();
        towerList = new ArrayList<towerGraphic>();
        trapList = new ArrayList<trapGraphic>();
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        map.paintComponent(g);
        if(eList != null)
        {
        	for(EnemyGraphic e: eList)
        	{
        		e.paintComponent(g, this);
        	}
        }
        if(towerList != null)
        {
        	for(towerGraphic t: towerList)
        	{
        		t.paintComponent(g);
        	}
        }
        if(trapList != null)
        {
        	for(trapGraphic tr: trapList)
        	{
        		tr.paintComponent(g);
        	}
        }
        
     //   enemy.paintComponent(g, this);
    }
	
	public void setMap(ArrayList<Cell> mapC)
	{
		map.setMap(mapC);
	}
	
	public static void addEnemyG(EnemyGraphic e)
	{
		eList.add(e);
	}
	
	public static void removeEnemyG(EnemyGraphic e)
	{
		eList.remove(e);
	}

	public static void addTowerG(towerGraphic e)
	{
		towerList.add(e);
	}
	
	public static void addTrapG(trapGraphic e)
	{
		trapList.add(e);
	}
	
}
