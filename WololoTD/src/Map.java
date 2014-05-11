
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.geom.*;

public class Map {

	BufferedImage grass;
	BufferedImage road;
	
	private ArrayList<Cell> map;
	
	public ArrayList<Cell> getMap() {
		return map;
	}

	public void setMap(ArrayList<Cell> map) {
		this.map = map;
		
	}

	public Map()
	{
		URL url = this.getClass().getResource("grass.jpg");
		URL url2 = this.getClass().getResource("stone.jpg");
		try {
			grass = ImageIO.read(url);
			road = ImageIO.read(url2);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g) {
       
        
		Graphics2D g2 = (Graphics2D)g;
		
		//Nagy Kocka Rajzolasa
        g2.draw(new Line2D.Double(50, 50, 530, 50));
        g2.draw(new Line2D.Double(50, 50, 50, 530));
        g2.draw(new Line2D.Double(50, 530, 530, 530));
        g2.draw(new Line2D.Double(530, 50, 530, 530));
        
        //fuggoleges csikok
        g2.draw(new Line2D.Double(130, 50, 130, 530));
        g2.draw(new Line2D.Double(210, 50, 210, 530));
        g2.draw(new Line2D.Double(290, 50, 290, 530));
        g2.draw(new Line2D.Double(370, 50, 370, 530));
        g2.draw(new Line2D.Double(450, 50, 450, 530));
        
        //vizszintes csikok
        g2.draw(new Line2D.Double(50, 130, 530, 130));
        g2.draw(new Line2D.Double(50, 210, 530, 210));
        g2.draw(new Line2D.Double(50, 290, 530, 290));
        g2.draw(new Line2D.Double(50, 370, 530, 370));
        g2.draw(new Line2D.Double(50, 450, 530, 450));
        
        
        if(map != null)
		{
			for(int i = 0; i < 6; i++)
			{
				for(int l = 0; l < 6; l++)
				{
					State curr = map.get(i + 6 * l).getState();
					
					if((curr == State.EMPTY) || (curr == State.TOWER))
					{
						g2.drawImage(grass, 50 + (i*80),50 + (l*80),80,80,null);
					}
					else
					{
						g2.drawImage(road, 50 + (i*80),50 + (l*80),80,80,null);
					}
					
				}
			}
			
			
		}
        
        
    }
	
	public int getMapIndex(Cell c)
	{
		
		return map.indexOf(c);
		
	}
	
}
