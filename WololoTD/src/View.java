
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
	public MiddleEarth puppetMaster;
	
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
				
				Cell toBuild = getCell(cell_y*6+cell_x);
				try{
				if(toBuild.getState() == State.EMPTY)
					puppetMaster.getPlayer().buildTower(cell_y, cell_x);
				else if(toBuild.getState() == State.ROAD)
					puppetMaster.getPlayer().buildTrap(cell_y, cell_x);
				else if(toBuild.getState() == State.TOWER)
				{
					if(getUpgrade() == 1)
						puppetMaster.getPlayer().upgradeTower(cell_y, cell_x, new DmgC());
					if(getUpgrade() == 2)
						puppetMaster.getPlayer().upgradeTower(cell_y, cell_x, new SpeedC());
					if(getUpgrade() == 3)
						puppetMaster.getPlayer().upgradeTower(cell_y, cell_x, new RangeC());
				}
				else if(toBuild.getState() == State.TRAP)
					puppetMaster.getPlayer().upgradeTrap(cell_y, cell_x, new TrapC());
				}
				catch(Exception c)
				{
					System.out.printf("Mana" + puppetMaster.getPlayer().getMana());
				}
				System.out.printf("Cella x:" + cell_x + "\n");
				System.out.printf("Cella y:" + cell_y + "\n");
		}
	}
	}
	
	public void repaint()
	{
		if(puppetMaster != null)
			dp.updateNumbers(puppetMaster.getPlayer().getMana(), puppetMaster.getPlayer().getEnemyCount());
		
		dp.repaint();
	}
	
	public void setMap(ArrayList<Cell> map)
	{
		dp.setMap(map);
	}
	
	public Cell getCell(int i)
	{
		return dp.getCell(i);
	}
	
	public void addEnemyG(EnemyGraphic e)
	{
		dp.addEnemyG(e);
	}
	
	public void removeEnemyG(EnemyGraphic e)
	{
		dp.removeEnemyG(e);
	}
	
	public int getUpgrade()
	{
		return dp.getUpgrade();
	}
	
}
