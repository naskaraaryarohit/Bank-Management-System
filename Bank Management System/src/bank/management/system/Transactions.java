package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Transactions extends JFrame implements ActionListener {

	String pinDB;
	JLabel text;
	JButton deposit, cashWithdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;

	public Transactions(String pinDB) {

		setLayout(null);
		this.pinDB = pinDB;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 950);
		add(image);

		text = new JLabel("Please select your Transanction");
		text.setBounds(215, 300, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		image.add(text);

		deposit = new JButton("Deposit");
		deposit.setBounds(150, 440, 150, 35);
		deposit.setFont(new Font("System", Font.BOLD, 12));
		deposit.setBackground(Color.gray);
		deposit.setForeground(Color.blue);
		deposit.addActionListener(this);
		image.add(deposit);

		cashWithdrawl = new JButton("Cash Withdrawl");
		cashWithdrawl.setBounds(370, 440, 150, 35);
		cashWithdrawl.setFont(new Font("System", Font.BOLD, 12));
		cashWithdrawl.setBackground(Color.gray);
		cashWithdrawl.setForeground(Color.blue);
		cashWithdrawl.addActionListener(this);
		image.add(cashWithdrawl);

		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(150, 475, 149, 35);
		fastCash.setFont(new Font("System", Font.BOLD, 12));
		fastCash.setBackground(Color.gray);
		fastCash.setForeground(Color.blue);
		fastCash.addActionListener(this);
		image.add(fastCash);

		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(370, 475, 149, 35);
		miniStatement.setFont(new Font("System", Font.BOLD, 12));
		miniStatement.setBackground(Color.gray);
		miniStatement.setForeground(Color.blue);
		miniStatement.addActionListener(this);
		image.add(miniStatement);

		pinChange = new JButton("Pin Change");
		pinChange.setBounds(150, 510, 149, 35);
		pinChange.setFont(new Font("System", Font.BOLD, 12));
		pinChange.setBackground(Color.gray);
		pinChange.setForeground(Color.blue);
		pinChange.addActionListener(this);
		image.add(pinChange);

		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(370, 510, 149, 35);
		balanceEnquiry.setFont(new Font("System", Font.BOLD, 12));
		balanceEnquiry.setBackground(Color.gray);
		balanceEnquiry.setForeground(Color.blue);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);

		exit = new JButton("Exit");
		exit.setBounds(370, 545, 149, 35);
		exit.setFont(new Font("System", Font.BOLD, 12));
		exit.setBackground(Color.gray);
		exit.setForeground(Color.blue);
		exit.addActionListener(this);
		image.add(exit);

		setSize(900, 880);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == deposit) {

			setVisible(false);
			new Deposit(pinDB).setVisible(true);

		} else if (e.getSource() == cashWithdrawl) {

			setVisible(false);
			new CashWithdrawl(pinDB).setVisible(true);

		} else if (e.getSource() == fastCash) {

			setVisible(false);
			new FastCash(pinDB).setVisible(true);

		} else if (e.getSource() == miniStatement) {
			
			new MiniStatement(pinDB).setVisible(true);

		} else if (e.getSource() == pinChange) {
			
			setVisible(false);
			new PinChange(pinDB).setVisible(true);

		} else if (e.getSource() == balanceEnquiry) {
			
			setVisible(false);
			new BalanceEnquiry(pinDB).setVisible(true);


		} else if (e.getSource() == exit) {
			System.exit(0);
//			setVisible(false);
//			new Login().setVisible(true);
		}

	}

	public static void main(String[] args) {

		new Transactions("");
	}

}