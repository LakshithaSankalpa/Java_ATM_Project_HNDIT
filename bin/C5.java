import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;

public class C5 implements ActionListener{
	JFrame f4;
	JLabel titleLabel1,titleLabel2,rsText;
	JPanel titlePanel,title1Panel,title2Panel,buttonP2,depoTextPanel;
	JButton backButton,depoButton,exitButton,clearButton;
	JTextField depoText;
	public String FBal=null;
	
	C5(){
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
			
	
		f4 = new JFrame();
		f4.setSize(575,240);
		f4.setTitle("ATM Deposit");
		f4.setLocationRelativeTo(null);
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel1 = new JLabel("Enter Amount You Want to Deposit");
		titleLabel1.setFont(new Font("", 5, 30));
		titleLabel1.setForeground(Color.white);
		titleLabel2 = new JLabel("Maximum Deposit is Rs.200000.00");
		titleLabel2.setFont(new Font("", 1, 20));
		titleLabel2.setForeground(Color.blue);
		
		titlePanel = new JPanel(new GridLayout(2, 1));
		titlePanel.setBackground(Color.blue);
		
		title1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title1Panel.setBackground(Color.blue);
		title1Panel.add(titleLabel1);
		titlePanel.add(title1Panel);
		title2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title2Panel.setBackground(Color.green);
		title2Panel.add(titleLabel2);
		titlePanel.add(title2Panel);
		
		f4.add("North", titlePanel);
		
		buttonP2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonP2.setBackground(Color.blue);
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		depoButton = new JButton("Deposit");
		depoButton.addActionListener(this);
		depoButton.setForeground(Color.blue);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setForeground(Color.red);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonP2.add(depoButton);
		buttonP2.add(clearButton);
		buttonP2.add(backButton);
		buttonP2.add(exitButton);
		
		f4.add("South",buttonP2);
		
		depoText = new JTextField(10);
		depoText.setFont(new Font("", 1, 20));
		rsText = new JLabel("Rs.");
		rsText.setFont(new Font("", 1, 20));
		
		depoTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		depoTextPanel.add(rsText);
		depoTextPanel.add(depoText);
		
		f4.add("Center",depoTextPanel);
		
		f4.pack();
		f4.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {  
	
		if(e.getSource()==backButton){
			System.out.println("backButton");
			new C3();
			f4.dispose(); 
		}
		else if(e.getSource()==exitButton){
			System.out.println("exitButton");
			new C7();
			f4.dispose();
			//System.exit(0);
		}
		else if(e.getSource()==depoButton){
		System.out.println("depoButton");
			
			//>>>>deposite store
			String deposite = depoText.getText();
			try {
				FileWriter depoFile = new FileWriter("deposite.txt");
				depoFile.write(deposite);
				depoFile.close();
				System.out.println("Successfully wrote deposite Value "+ deposite + "to the file.");
				} catch (IOException ett) {
					System.out.println("An error occurred.");
					ett.printStackTrace();
					}
					
			
			//##########################################################################################

				System.out.println("******************************************************");
				
				String amountr=null;

			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  get withdraw
			try {
				File depoRead = new File("deposite.txt");
				
				Scanner depoScan= new Scanner(depoRead);
				
				while (depoScan.hasNextLine()) {
				amountr = depoScan.nextLine();
				System.out.println(amountr);
				}
				depoScan.close();
				} catch (FileNotFoundException t) {
				System.out.println("An error occurred.");
				t.printStackTrace();
				}

				Float balance1 = Float.parseFloat(FBal);
				Float amount = Float.parseFloat(amountr);
				//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				  
					//System.out.println("Withdraw");
					if(amount > 200000 ){
						System.out.println("Maximum Deposit is Rs.200000.00\n\n");
						JOptionPane.showMessageDialog(null, "Maximum Deposit is Rs.200000.00");
						new C5();
						f4.dispose();
					}else {
						balance1 = balance1 + amount;
						System.out.println("You have deposited "+amount+" and your new balance is "+balance1+"\n");
						JOptionPane.showMessageDialog(null, "Deposite Successfully!. You have deposited "+amount+" and your new balance is "+balance1);
						//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Blance Store

						String balances=String. valueOf(balance1); // balance value convert to String value	
		
						try {
							FileWriter myWriter2 = new FileWriter("Bal.txt");
							myWriter2.write(balances);
							myWriter2.close();
							System.out.println("Successfully wrote Balance Value to the file.");
							} catch (IOException ett) {
							System.out.println("An error occurred.");
							ett.printStackTrace();
							}	
							//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
					
					new C3();
					f4.dispose();
					}

		}	
		else {
			System.out.println("clearButton");
			new C5();
			f4.dispose();
		}
    }
	
	public static void main(String[] args) {
		new C5();
		}
}