import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class C7 implements ActionListener{
	JFrame f7;
	JLabel thankLabel,thankLabel2,background7;
	JPanel thankPanel,subPanel1,subPanel2,mainBuPanel,img7;
	JButton mainButton,exitButton;

	C7(){
		f7 = new JFrame();
		f7.setSize(600,500);
		f7.setTitle("ATM Thank You");
		f7.setLocationRelativeTo(null);
		//f7.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thankLabel = new JLabel("Thank You Banking With Us");
		thankLabel.setFont(new Font("", 5, 30));
		thankLabel.setForeground(Color.white);
		thankLabel2 = new JLabel("Come to Back Transactions Again With Us");
		thankLabel2.setFont(new Font("", 1, 20));
		thankLabel2.setForeground(Color.blue);
		
		thankPanel = new JPanel(new GridLayout(2, 1));
		thankPanel.setBackground(Color.blue);
		
		subPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		subPanel1.setBackground(Color.blue);
		subPanel1.add(thankLabel);
		thankPanel.add(subPanel1);
		subPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		subPanel2.setBackground(Color.pink);
		subPanel2.add(thankLabel2);
		thankPanel.add(subPanel2);
		
		f7.add("North", thankPanel);
		
		mainBuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainBuPanel.setBackground(Color.blue);
		mainButton = new JButton("Main Menu");
		mainButton.addActionListener(this);
		mainButton.setFont(new Font("", 1, 16));
		mainButton.setForeground(Color.red);
		mainBuPanel.add(mainButton);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setFont(new Font("", 1, 16));
		exitButton.setForeground(Color.red);
		mainBuPanel.add(exitButton);
		
		f7.add("South",mainBuPanel);
		
		img7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		img7.setBackground(Color.blue);
		background7 = new JLabel(new ImageIcon("4.gif"));
		f7.add("Center", background7);
		
		f7.pack();
		f7.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {  
	
		if(e.getSource()==mainButton){
			System.out.println("mainButton");
			new C1();
			f7.dispose(); 
		}
		else if(e.getSource()==exitButton){
			System.out.println("exitButton");
			ImageIcon abc = new ImageIcon("5.jpg");
			Image abcImage = abc.getImage();
			Image modifiedAbcImage = abcImage.getScaledInstance(180,170 , java.awt.Image.SCALE_SMOOTH);
			abc = new ImageIcon(modifiedAbcImage);
			f7.dispose();
			//JOptionPane.showOptionDialog(null, "Do you like this answer?","Feedback", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Yes I do", "No I don't"},"default");
			
			JOptionPane.showMessageDialog(null,"# : All Right Received...\r\n# : ©-Lakshitha Sankalpa.\r\n# : 2020.03.19\r\n# : HNDIT20-(GALLE).","Thank You!!!!!!!!!!!!!!",JOptionPane.INFORMATION_MESSAGE,abc);
			System.exit(0);
			
		}
	}
	
	public static void main(String[] args) {
		new C7();
	}	
}
