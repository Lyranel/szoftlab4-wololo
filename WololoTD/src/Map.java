
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.geom.*;

public class Map {

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
        
        
        
    }
	
    //addMouseListener(this);



}

