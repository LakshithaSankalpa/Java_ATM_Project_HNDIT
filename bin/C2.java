import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;

public class C2 implements ActionListener{
	
	JFrame f2;
	JLabel titleL1,background2,accNoLable,pinNoLable,nulLable1;
	JPanel buttonP1,titleP4,img2,labelText,accNoTPanel,accNoLPanel,pinNoTPanel,pinNoLPanel;
	JButton backButton,nextButton,clearButton,exitButton;
	JTextField accNoText;
	JPasswordField pinNoText;

	public String uname1="sankalpa";
	public String uname2="lakshitha";
	public String uname3="admin";
	public String pw1="1234";
	public String pw2="4321";
	public String pw3="0000";
		
	C2(){
		f2 = new JFrame();
		f2.setSize(610,340);
		//f2.setLayout(new GridLayout(2, 1));
		f2.setTitle("ATM Login");
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleL1 = new JLabel("Please Enter Account Name & PIN Number");
		titleL1.setFont(new Font("", 2, 30));
		titleL1.setForeground(Color.white);
		titleP4 = new JPanel(); //flow layout
		titleP4.setBackground(Color.blue);
		titleP4.add(titleL1);
		f2.add("North",titleP4);
		
		buttonP1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonP1.setBackground(Color.blue);
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setForeground(Color.blue);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setForeground(Color.red);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setForeground(Color.red);
		exitButton.setFont(new Font("", 1, 14));
		buttonP1.add(backButton);
		buttonP1.add(nextButton);
		buttonP1.add(clearButton);
		buttonP1.add(exitButton);
		f2.add("South",buttonP1);
		
		img2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		img2.setBackground(Color.blue);
		background2=new JLabel(new ImageIcon("2.jpg"));
		f2.add("East", background2);	
		
		accNoLable = new JLabel("Acc.Name.");
		accNoLable.setFont(new Font("", 1, 20));
		//accNoLable.setForeground(Color.blue);
		pinNoLable = new JLabel("PIN.No.");
		pinNoLable.setFont(new Font("", 1, 20));
		nulLable1 = new JLabel(" ");
		
		accNoText = new JTextField(8);
		accNoText.setHorizontalAlignment(JTextField.CENTER);
		//JTextField pinNoText = new JTextField(8);
		accNoText.setFont(new Font("", 1, 20));
		pinNoText = new JPasswordField(4);
		pinNoText.setHorizontalAlignment(JPasswordField.CENTER);
		pinNoText.setFont(new Font("", 1, 20));
		pinNoText.setEchoChar('*');
		labelText = new JPanel(new GridLayout(5, 1));
		
		labelText.add(nulLable1);
		
		accNoTPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		accNoTPanel.add(accNoText);
		labelText.add(accNoTPanel);
		
		accNoLPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		accNoLPanel.add(accNoLable);
		labelText.add(accNoLPanel);
		
		pinNoTPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pinNoTPanel.add(pinNoText);
		labelText.add(pinNoTPanel);
		
		pinNoLPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pinNoLPanel.add(pinNoLable);
		labelText.add(pinNoLPanel);
		
		f2.add("Center", labelText);
		
		f2.pack();
		f2.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {  
	
		
	
		if(e.getSource()==backButton){
			System.out.println("backButton");
			new C1();
			f2.dispose(); 
		}
		else if(e.getSource()==exitButton){
			System.out.println("exitButton");
			new C7();
			f2.dispose();
			//System.exit(0);
		}
		else if(e.getSource()==clearButton){
			System.out.println("clearButton");
			new C2();
			f2.dispose();
		}
		else if(e.getSource()==nextButton){
			System.out.println("nextButton");
			
			String name=accNoText.getText();
			try {
				FileWriter myWriter2 = new FileWriter("user_name.txt");
				myWriter2.write(name);
				myWriter2.close();
				System.out.println("Successfully wrote u_name Value to the file.");
				} catch (IOException ett) {
					System.out.println("An error occurred.");
					ett.printStackTrace();
					}
					//>>>>user_name store
			String pw=pinNoText.getText();
			try {
				FileWriter myWriter3 = new FileWriter("pw.txt");
				myWriter3.write(pw);
				myWriter3.close();
				System.out.println("Successfully wrote pw Value to the file.");
				} catch (IOException ett) {
						System.out.println("An error occurred.");
						ett.printStackTrace();
						}
					//>>>>>pw store
					
			//##########################################################################################

				System.out.println("user_name is " + name );
				System.out.println("Pw is  " + pw );
				System.out.println("******************************************************");
				
				if (pinNoText.getText().replaceAll("\u00A0", "").length() != 4 ) {
                System.out.println("INCORRECT Pin must be 4 digits");
                JOptionPane.showMessageDialog(null, "Password is INCORRECT. Pin must be 4 digits","Attention",JOptionPane.WARNING_MESSAGE);
                return;
				}
				else if (name.equalsIgnoreCase(uname1) || name.equalsIgnoreCase(uname2) || name.equalsIgnoreCase(uname3))
				{
					if((name.equalsIgnoreCase(uname1)&& pw.equalsIgnoreCase(pw1)) || (name.equalsIgnoreCase(uname2) && pw.equalsIgnoreCase(pw2)) || (name.equalsIgnoreCase(uname3) && pw.equalsIgnoreCase(pw3)))
					{
					JOptionPane.showMessageDialog(null, "YOU ARE LOGIN CORRECTLY");
						if(name.equalsIgnoreCase(uname1)){
							try {
								FileWriter sankalpaBal = new FileWriter("Bal.txt");
								sankalpaBal.write("10000");
								sankalpaBal.close();
								System.out.println("Successfully wrote Rs.10000 to the sankalpaBal file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
							try {
								FileWriter sankalpaAccNo = new FileWriter("AccNo.txt");
								sankalpaAccNo.write("S-8200-2200-0123-6545");
								sankalpaAccNo.close();
								System.out.println("Successfully wrote S-8200-2200-0123-6545 to the sankalpaAccNo file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
							try {
								FileWriter sankalpaNIC = new FileWriter("NIC.txt");
								sankalpaNIC.write("972722650V");
								sankalpaNIC.close();
								System.out.println("Successfully wrote 972722650V to the sankalpaNIC file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
						}
						else if(name.equalsIgnoreCase(uname2)){
							try {
								FileWriter lakshithaBal = new FileWriter("Bal.txt");
								lakshithaBal.write("75000");
								lakshithaBal.close();
								System.out.println("Successfully wrote Rs.75000 to the lakshithaBal file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
							try {
								FileWriter lakshithaAccNo = new FileWriter("AccNo.txt");
								lakshithaAccNo.write("J-1113-1330-1237-5455");
								lakshithaAccNo.close();
								System.out.println("Successfully wrote J-1113-1330-1237-5455 to the lakshithaAccNo file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
							try {
								FileWriter lakshithaNIC = new FileWriter("NIC.txt");
								lakshithaNIC.write("902227998V");
								lakshithaNIC.close();
								System.out.println("Successfully wrote 902227998V to the lakshithaNIC file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
						}
						else if (name.equalsIgnoreCase(uname3)){
							try {
								FileWriter adminBal = new FileWriter("Bal.txt");
								adminBal.write("19999999");
								adminBal.close();
								System.out.println("Successfully wrote Rs.19999999 to the adminBal file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
							try {
								FileWriter adminAccNo = new FileWriter("AccNo.txt");
								adminAccNo.write("A-0000-0000-0000-0001");
								adminAccNo.close();
								System.out.println("Successfully wrote A-0000-0000-0000-0001 to the adminAccNo file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
							try {
								FileWriter adminNIC = new FileWriter("NIC.txt");
								adminNIC.write("000000000V");
								adminNIC.close();
								System.out.println("Successfully wrote 000000000V to the adminNIC file.");
								} catch (IOException ett) {
									System.out.println("An error occurred.");
									ett.printStackTrace();
									}
						}
					System.out.println("******************************************************");
					new C3();
					f2.dispose();;
					}
					else{
						JOptionPane.showMessageDialog(null, "You Enterd Password is INCORRECT", "Attention",JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					System.out.println("You Enterd User Name is INCORRECT");
					JOptionPane.showMessageDialog(null, "You Enterd User Name is INCORRECT", "Attention",JOptionPane.WARNING_MESSAGE);
				}
				
		}
    }
	
	public static void main(String[] args) {
		
		new C2();
		
	}
}