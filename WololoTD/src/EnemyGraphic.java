
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.geom.*;

public class EnemyGraphic {

	ImageIcon im2 = null;
	
	
	public EnemyGraphic() {
		ImageIcon im = new ImageIcon(this.getClass().getResource("szakkalas_torpe.gif"));
		im2 = new ImageIcon(im.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
	}
	
	public void paintComponent(Graphics g, JPanel panel) {
       
		im2.paintIcon(panel, g, 300, 300);
        
    }
	
	
}
