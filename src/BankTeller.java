
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankTeller extends BankAccount implements ActionListener {

	//Variables
	private String name;
	private String number;
	private String transaction;
	private double balance;
	
	//Fonts
	private Font bankFont = new Font("Helvetica", Font.BOLD, 16);
	private Font bankFont2 = new Font("Helvetica", Font.BOLD + Font.ITALIC, 14);
	
	//Labels
	private JLabel lbl_name1 = new JLabel("Account Holder Name:"),
				   lbl_name2 = new JLabel("Account Holder Name:"),
				   lbl_acctNum1 = new JLabel("Account Number:"),
				   lbl_acctNum2 = new JLabel("Account Number"),
				   lbl_trans1 = new JLabel("Deposit Amount:"),
				   lbl_trans2 = new JLabel("Current Balance:"),
				   lbl_acsName = new JLabel(),
				   lbl_acsNum = new JLabel(),
				   lbl_acsBal = new JLabel();
	
	//Text Fields
	private JTextField txt_name = new JTextField(12),
					   txt_acctNum = new JTextField(12),
					   txt_trans = new JTextField(12);
	
	//Buttons
	private JButton btn_submit = new JButton("Submit");
	
	//Panels
	private JPanel pnl_center = new JPanel(),
				   pnl_button = new JPanel(),
				   pnl_name1 = new JPanel(),
				   pnl_txt1 = new JPanel(),
				   pnl_num1 = new JPanel(),
				   pnl_txt2 = new JPanel(),
				   pnl_trans1 = new JPanel(), 
				   pnl_txt3 = new JPanel(),
				   pnl_blank = new JPanel(),
				   pnl_name2 = new JPanel(),
				   pnl_acsName = new JPanel(),
				   pnl_num2 = new JPanel(),
				   pnl_acsNum = new JPanel(),
				   pnl_trans2 = new JPanel(),
				   pnl_acsBal = new JPanel();
	
	//Images
	private ImageIcon icon = new ImageIcon("bank.png");
	
	//Container
	private Container content = getContentPane();
	
	
	public BankTeller() {
		this.setTitle("Bank Teller");
		this.setSize(500,500);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
		
		content.setLayout(new BorderLayout());
		content.add(BorderLayout.CENTER,pnl_center);
		
		pnl_center.setBackground(Color.lightGray);
		pnl_center.setLayout(new GridLayout(7,2));
		
		pnl_center.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(20,20,20,20,Color.black),
				BorderFactory.createEmptyBorder(15, 15, 15, 15)
				));
		
		lbl_name1.setFont(bankFont);
		pnl_name1.add(lbl_name1);
		pnl_center.add(pnl_name1);
		
		txt_name.setFont(bankFont);
		pnl_txt1.add(txt_name);
		pnl_center.add(pnl_txt1);
		
		lbl_acctNum1.setFont(bankFont);
		pnl_num1.add(lbl_acctNum1);
		pnl_center.add(pnl_num1);
		
		txt_acctNum.setFont(bankFont);
		pnl_txt2.add(txt_acctNum);
		pnl_center.add(pnl_txt2);
		
		lbl_trans1.setFont(bankFont);
		pnl_trans1.add(lbl_trans1);
		pnl_center.add(pnl_trans1);
		
		txt_trans.setFont(bankFont);
		pnl_txt3.add(txt_trans);
		pnl_center.add(pnl_txt3);
		
		btn_submit.setForeground(Color.white);
		btn_submit.setBackground(Color.black);
		btn_submit.setFont(bankFont2);
		pnl_button.add(btn_submit);
		pnl_center.add(pnl_button);
		
		pnl_center.add(pnl_blank);
		
		lbl_name2.setFont(bankFont);
		pnl_name2.add(lbl_name2);
		pnl_center.add(pnl_name2);
		
		lbl_acsName.setFont(bankFont);
		pnl_acsName.add(lbl_acsName);
		pnl_center.add(pnl_acsName);
		
		lbl_acctNum2.setFont(bankFont);
		pnl_num2.add(lbl_acctNum2);
		pnl_center.add(pnl_num2);
		
		lbl_acsNum.setFont(bankFont);
		pnl_acsNum.add(lbl_acsNum);
		pnl_center.add(pnl_acsNum);
		
		lbl_trans2.setFont(bankFont);
		pnl_trans2.add(lbl_trans2);
		pnl_center.add(pnl_trans2);
		
		lbl_acsBal.setFont(bankFont);
		pnl_acsBal.add(lbl_acsBal);
		pnl_center.add(pnl_acsBal);
		
		btn_submit.addActionListener(this);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.pack();
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btn_submit) {
			name = txt_name.getText();
			number = txt_acctNum.getText();
			transaction = txt_trans.getText();
			
			balance = Double.parseDouble(transaction) + getCurrentAmt() ;
			String balance2 = String.format("%.2f", balance);
			
			setName(name);
			setAcctNumber(number);
			setCurrentAmt(balance);
			
			lbl_acsName.setText(getName());
			lbl_acsNum.setText(getAcctNumber());
			lbl_acsBal.setText("$" + balance2);			
		}
	}
	
	
	public static void main(String[] args) {
		BankTeller myFrame = new BankTeller();
		myFrame.setVisible(true);
	}

}
