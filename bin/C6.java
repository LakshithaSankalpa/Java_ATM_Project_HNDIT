import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;

public class C6 implements ActionListener{
	JFrame f6;
	JLabel balrsText,titleLabel6,titleLabel7,titleLabel8,titleLabel9;
	JPanel titlePanel6,title6Panel,title7Panel,title8Panel,title9Panel,balPanel,buttonP6;
	JTextField balText;
	JButton backButton,exitButton;
	String nic,AccNo,name, FBal;
	public String abc="lakshitha";
	
	C6(){
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  AccNo Value Read
	
	try {
		File accFile = new File("AccNo.txt");
		Scanner accScn = new Scanner(accFile);
		while (accScn.hasNextLine()) {
			AccNo = accScn.nextLine();
			System.out.println("AccNo : " + AccNo);
			}
		accScn.close();
		} catch (FileNotFoundException t2) {
			System.out.println("An error occurred.");
			t2.printStackTrace();
			}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  NIC Value Read
	
	try {
		File nicFile = new File("NIC.txt");
		Scanner nicScn = new Scanner(nicFile);
		while (nicScn.hasNextLine()) {
			nic = nicScn.nextLine();
			System.out.println("NIC : " + nic);
			}
		nicScn.close();
		} catch (FileNotFoundException t2) {
			System.out.println("An error occurred.");
			t2.printStackTrace();
			}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Name Value Read
	
	try {
		File nameFile = new File("user_name.txt");
		Scanner nameScn = new Scanner(nameFile);
		while (nameScn.hasNextLine()) {
			name = nameScn.nextLine();
			System.out.println("OwnerName : " + name);
			}
		nameScn.close();
		} catch (FileNotFoundException t2) {
			System.out.println("An error occurred.");
			t2.printStackTrace();
			}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Balance Value Read
	
	try {
		File balFile = new File("Bal.txt");
		Scanner balScn = new Scanner(balFile);
		while (balScn.hasNextLine()) {
			FBal = balScn.nextLine();
			System.out.println("Balance : " + FBal);
			}
		balScn.close();
		} catch (FileNotFoundException t2) {
			System.out.println("An error occurred.");
			t2.printStackTrace();
			}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
		
		f6 = new JFrame();
		f6.setSize(500,300);
		f6.setTitle("ATM Balance");
		f6.setLocationRelativeTo(null);
		f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel6 = new JLabel("Your Account Details & Balance");
		titleLabel6.setFont(new Font("", 5, 30));
		titleLabel6.setForeground(Color.white);
		titleLabel7 = new JLabel("Account Number : " + AccNo);
		titleLabel7.setFont(new Font("", 1, 20));
		titleLabel7.setForeground(Color.blue);
		
		if (name.equalsIgnoreCase(abc)){
			titleLabel8 = new JLabel("NIC : " + nic + " & 972722650V");
			titleLabel9 = new JLabel("OwnerName : " + name + " & Sankalpa");
		}else{
			titleLabel8 = new JLabel("NIC : " + nic);
			titleLabel9 = new JLabel("OwnerName : " + name);
			
		}
		
		titleLabel8.setFont(new Font("", 1, 20));
		titleLabel8.setForeground(Color.blue);
		titleLabel9.setFont(new Font("", 1, 20));
		titleLabel9.setForeground(Color.blue);
		
		titlePanel6 = new JPanel(new GridLayout(4, 1));
		titlePanel6.setBackground(Color.blue);
		
		title6Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title6Panel.setBackground(Color.blue);
		title6Panel.add(titleLabel6);
		titlePanel6.add(title6Panel);
			
		title7Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title7Panel.setBackground(Color.yellow);
		title7Panel.add(titleLabel7);
		titlePanel6.add(title7Panel);
			
		title8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title8Panel.setBackground(Color.yellow);
		title8Panel.add(titleLabel8);
		titlePanel6.add(title8Panel);
			
		title9Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title9Panel.setBackground(Color.yellow);
		title9Panel.add(titleLabel9);
		titlePanel6.add(title9Panel);
					
		f6.add("North", titlePanel6);
		
		balText = new JTextField(FBal);
		balText.setEditable(false);
		balText.setFont(new Font("", 1, 26));
		balrsText = new JLabel("Balance : Rs.");
		balrsText.setFont(new Font("", 1, 26));
		
		balPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		balPanel.add(balrsText);
		balPanel.add(balText);
		
		f6.add("Center",balPanel);
		
		buttonP6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonP6.setBackground(Color.blue);
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setFont(new Font("", 1, 16));
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setFont(new Font("", 1, 16));
		exitButton.setForeground(Color.red);
		buttonP6.add(backButton);
		buttonP6.add(exitButton);
		
		f6.add("South",buttonP6);
		
		f6.pack();
		f6.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {  
	
	
	
	
	
		if(e.getSource()==backButton){
			System.out.println("backButton");
			new C3();
			f6.dispose(); 
		}
		else if(e.getSource()==exitButton){
			System.out.println("exitButton");
			new C7();
			f6.dispose();
			//System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new C6();
	}
}
		
		
		