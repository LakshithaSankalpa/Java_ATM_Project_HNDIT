import javax.swing.*;  
import javax.swing.ImageIcon; 
import java.awt.event.*;
import java.io.*;  
import java.awt.*;
import java.awt.Image;
import java.lang.Object;
import javax.imageio.ImageIO;
import java.util.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class C0 {
	JFrame f1;
	JLabel background;
	
    C0(){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
        // Create a wrapper around 
        // the double value 
        Double newData1 = new Double(width);
		Double newData2 = new Double(height);		
  
        // convert into int 
        int value1 = newData1.intValue(); 
		int value2 = newData2.intValue();
  
        // print the int value 
        System.out.println("width : " + value1);
		System.out.println("height : " + value2);
	
		f1 = new JFrame();
		f1.setSize(value1,value2);
		f1.setBackground(Color.red);
		f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f1.setUndecorated(true);
		f1.setTitle("ATM Project");
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background=new JLabel();
		background.setSize(value1, value2);
		background.setIcon(resize(new ImageIcon("0.png"), value1, value2));
		f1.add("Center", background);
		
		/*		
		background=new JLabel(new ImageIcon("0.jpg"));
		
		background.setSize(1280, 780);
        	f1.add("Center", background);
		*/
		f1.setVisible(true);
	} 
	public static ImageIcon resize(ImageIcon im, int w, int h){
		BufferedImage bi=new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D gd=(Graphics2D)bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(),0,0,w,h,null);
		gd.dispose();
		return new ImageIcon(bi);
	}

	public static void main(String[] args) {  
		new C0(); 
		new C1();
	} 
}  