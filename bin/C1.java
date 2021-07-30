import javax.swing.*;  
import java.awt.event.*;
import java.io.*;  
import java.awt.*;

public class C1 implements ActionListener{  
   
	JButton b2,b1,b3;
	JFrame f1;
	JPanel p1;
	JLabel background;
	
    C1(){
		f1 = new JFrame();
		f1.setSize(780,500);
		//f1.setLayout(new GridLayout(2, 1));
		f1.setTitle("ATM Project");
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background=new JLabel(new ImageIcon("1.gif"));
		
		background.setSize(400, 450);
        f1.add("Center", background);
		
		b1 = new JButton("isxy,");
		b1.setFont(new Font("FMBindumathi", Font.PLAIN, 14));
		b1.addActionListener(this);
		b2 = new JButton("English");
		b2.addActionListener(this);
		b3 = new JButton("Tamil");
		b3.addActionListener(this);
		
		p1 = new JPanel();
		p1.setBackground(Color.black);
		p1.setLayout(new FlowLayout());
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		f1.add("South", p1); 
		f1.setBackground(Color.black);
		//f1.pack();
		f1.setVisible(true);
	} 
	
    public void actionPerformed(ActionEvent e) {  
	
		if(e.getSource()==b2){
			System.out.println("English");
			new C2();
			f1.dispose();
		}
		else if(e.getSource()==b1){
			JOptionPane.showMessageDialog(null,"Sinhala Language mode is Not avalabel. Its Developing.","Attention",JOptionPane.WARNING_MESSAGE);
			System.out.println("Sinhala");
		}
		else {
			JOptionPane.showMessageDialog(null,"Tamil Language mode is Not avalabel. Its Developing.","Attention",JOptionPane.WARNING_MESSAGE);
			System.out.println("Tamil");
		}
    }  
	
	public static void main(String[] args) {  
		new C1();  
	} 
}  