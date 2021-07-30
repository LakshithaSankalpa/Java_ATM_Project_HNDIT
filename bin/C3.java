import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class C3 implements ActionListener{
	
	JFrame f3;
	JLabel titleTrans,background3;
	JPanel titlePanel,buttonP2,southPanel,img3;
	JButton withdrButton,depoButton,balButton,billButton,backButton,exitButton;
		
	C3(){

		f3 = new JFrame();
		f3.setSize(610,340);
		//f2.setLayout(new GridLayout(2, 1));
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
		
		buttonP2 = new JPanel(new GridLayout(2, 2,4,4));
		buttonP2.setBackground(Color.yellow);
		withdrButton = new JButton("WITHDRAWAL");
		withdrButton.addActionListener(this);
		withdrButton.setFont(new Font("", 1, 18));
		depoButton = new JButton("DEPOSIT");
		depoButton.addActionListener(this);
		depoButton.setFont(new Font("", 1, 18));
		balButton = new JButton("BALANCE");
		balButton.addActionListener(this);
		balButton.setFont(new Font("", 1, 18));
		billButton = new JButton("PAY BILL");
		billButton.addActionListener(this);
		billButton.setFont(new Font("", 1, 18));
		buttonP2.add(withdrButton);
		buttonP2.add(depoButton);
		buttonP2.add(balButton);
		buttonP2.add(billButton);
		f3.add("Center",buttonP2);
		
		southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		southPanel.setBackground(Color.blue);
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setForeground(Color.red);
		southPanel.add(backButton);
		southPanel.add(exitButton);
		f3.add("South",southPanel);
		
		img3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		img3.setBackground(Color.blue);
		background3=new JLabel(new ImageIcon("3.jpg"));
		f3.add("East", background3);
		
		f3.pack();
		f3.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {  
	
		if(e.getSource()==backButton){
			System.out.println("backButton");
			new C2();
			f3.dispose(); 
		}
		else if(e.getSource()==exitButton){
			System.out.println("exitButton");
			new C7();
			f3.dispose();
			//System.exit(0);
		}
		else if(e.getSource()==withdrButton){
			System.out.println("withdrButton");
			new C4();
			f3.dispose();
		}
		else if(e.getSource()==depoButton){
			System.out.println("depoButton");
			new C5();
			f3.dispose();
		}
		else if(e.getSource()==balButton){
			System.out.println("balButton");
			new C6();
			f3.dispose();
		}
		else {
			System.out.println("billButton");
			//new C*();
			//f3.dispose();
			JOptionPane.showMessageDialog(null,"This service is Not avalabel. Its Developing.","Attention",JOptionPane.WARNING_MESSAGE);
		}
    }
	
	public static void main(String[] args) {
		new C3();
	}
	
}