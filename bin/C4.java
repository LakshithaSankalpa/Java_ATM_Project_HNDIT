import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;


public class C4 implements ActionListener {
	JFrame f5;
	JLabel titleLabel1,titleLabel2,rsText;
	JPanel titlePanel,title1Panel,title2Panel,buttonP2,withTextPanel;
	JButton backButton,withButton,exitButton,clearButton;
	JTextField withText;
	public String FBal=null;
	
	C4(){
		
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
		
		f5 = new JFrame();
		f5.setSize(575,240);
		f5.setTitle("ATM Withdrawal");
		f5.setLocationRelativeTo(null);
		f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel1 = new JLabel("Please Enter Your Withdrawal Amount");
		titleLabel1.setFont(new Font("", 5, 30));
		titleLabel1.setForeground(Color.white);
		titleLabel2 = new JLabel("Maximum Daly Withdrawal is Rs.100000.00");
		titleLabel2.setFont(new Font("", 1, 20));
		titleLabel2.setForeground(Color.blue);
		
		titlePanel = new JPanel(new GridLayout(2, 1));
		titlePanel.setBackground(Color.blue);
		
		title1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title1Panel.setBackground(Color.blue);
		title1Panel.add(titleLabel1);
		titlePanel.add(title1Panel);
		title2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		title2Panel.setBackground(Color.red);
		title2Panel.add(titleLabel2);
		titlePanel.add(title2Panel);
		
		f5.add("North", titlePanel);
				
		buttonP2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonP2.setBackground(Color.blue);
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		withButton = new JButton("Withdrawal");
		withButton.addActionListener(this);
		withButton.setForeground(Color.blue);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setForeground(Color.red);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonP2.add(withButton);
		buttonP2.add(clearButton);
		buttonP2.add(backButton);
		buttonP2.add(exitButton);
		
		f5.add("South",buttonP2);
		
		withText = new JTextField(10);
		withText.setFont(new Font("", 1, 20));
		rsText = new JLabel("Rs.");
		rsText.setFont(new Font("", 1, 20));
		
		withTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		withTextPanel.add(rsText);
		withTextPanel.add(withText);
		
		f5.add("Center",withTextPanel);
		f5.pack();
		f5.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {  
	
		if(e.getSource()==backButton){
			System.out.println("backButton");
			new C3();
			f5.dispose(); 
		}
		else if(e.getSource()==exitButton){
			System.out.println("exitButton");
			new C7();
			f5.dispose();
			//System.exit(0);
		}
		else if(e.getSource()==withButton){
			System.out.println("withButton");
			
			
			String withdraw = withText.getText();
			try {
				FileWriter withdrawFile = new FileWriter("withdraw.txt");
				withdrawFile.write(withdraw);
				withdrawFile.close();
				System.out.println("Successfully wrote withdraw Value "+ withdraw + "to the file.");
				} catch (IOException ett) {
					System.out.println("An error occurred.");
					ett.printStackTrace();
					}
					//>>>>withdraw store
			
			//##########################################################################################

				System.out.println("******************************************************");
				
				String amountr=null;

			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  get withdraw
			try {
				File withdrawRead = new File("withdraw.txt");
				
				Scanner withdrawScan= new Scanner(withdrawRead);
				
				while (withdrawScan.hasNextLine()) {
				amountr = withdrawScan.nextLine();
				//System.out.println(amountr);
				}
				withdrawScan.close();
				} catch (FileNotFoundException t) {
				System.out.println("An error occurred.");
				t.printStackTrace();
				}

				Float balance1 = Float.parseFloat(FBal);
				Float amount = Float.parseFloat(amountr);
				//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				  
					//System.out.println("Withdraw");
					if(amount>100000){
						System.out.println("Maximum Withdrawal is Rs.100000.00\n\n");
						JOptionPane.showMessageDialog(null, "Maximum Withdrawal is Rs.100000.00");
						new C4();
						f5.dispose();
					}
					else if(amount > balance1 || amount == 0 ){
						System.out.println("You have insufficient Balance\n\n");
						JOptionPane.showMessageDialog(null, "You have insufficient Balance");
						new C4();
						f5.dispose();
					}else {
						balance1 = balance1 - amount;
						System.out.println("You have withdrawn "+amount+" and your new balance is "+balance1+"\n");
						JOptionPane.showMessageDialog(null, "Withdrawal Successfully!. You have withdrawn "+amount+" and your new balance is "+balance1);
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
					f5.dispose();
					}

		}
		else {
			System.out.println("clearButton");
			new C4();
			f5.dispose();
		}
    }
	
	public static void main(String[] args) {
		
		new C4();
	}
	
	
}