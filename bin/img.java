import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class img{
	
	JFrame f3;
	JLabel titleTrans,background3;
	JPanel titlePanel,img3;
	
	img(){

		f3 = new JFrame();
		f3.setSize(610,340);
		f3.setTitle("ATM Transaction");
		f3.setLocationRelativeTo(null);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleTrans = new JLabel("Please Select Your Transaction");
		titleTrans.setFont(new Font("", 5, 30));
		titleTrans.setForeground(Color.white);
		
		titlePanel = new JPanel(); //flow layout
		titlePanel.setBackground(Color.blue);
		titlePanel.add(titleTrans);
		f3.add("North",titlePanel);
		
		img3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		img3.setBackground(Color.blue);
		background3=new JLabel(new ImageIcon("3.jpg"));
		f3.add("East", background3);
		// we can add East, South, North, West, center. it add image can be seen that position
		
		f3.pack();
		f3.setVisible(true);
	}
	public static void main(String[] args) {
		new img();
	}
	
}
	