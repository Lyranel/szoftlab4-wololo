
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.geom.*;

public class View extends JFrame implements MouseListener{

	DrawPane dp;
	
	
	public View()
	{
		super("Wololo TD");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dp = new DrawPane();
		add(dp);
		dp.addMouseListener(this);
		addMouseListener(this);

	}
	
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		System.out.printf("Mouse pressed; # of clicks: "
                + e.getClickCount() + "	" + e.getX() + "	" + e.getY() + "\n", e);
		if((e.getX() >= 50) && (e.getX() <= 530)){
			if((e.getY() >= 50) && (e.getY() <= 530)){
				int cell_x = (int) ((e.getX()  - 50) / 80);
				int cell_y = (int) ((e.getY()  - 50) / 80);
				System.out.printf("Cella x:" + cell_x + "\n");
				System.out.printf("Cella y:" + cell_y + "\n");
		}
	}
	}
	
	public void repaint()
	{
		dp.repaint();
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
