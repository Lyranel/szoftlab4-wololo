
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.geom.*;

public class View extends JFrame{

	DrawPane dp;
	
	
	public View()
	{
		super("Wololo TD");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dp = new DrawPane();
		add(dp);
	}
	
	public void setMap(ArrayList<Cell> map)
	{
		dp.setMap(map);
	}
	
	public void addEnemyG(EnemyGraphic e)
	{
		dp.addEnemyG(e);
	}
	
	public void removeEnemyG(EnemyGraphic e)
	{
		dp.removeEnemyG(e);
	}
	
	
}
