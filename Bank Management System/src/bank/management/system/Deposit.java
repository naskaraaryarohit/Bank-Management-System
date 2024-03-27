package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Deposit extends JFrame implements ActionListener {

	JLabel text;
	JTextField amountTF;
	JButton deposit, back;
	String pinDB;

	public Deposit(String pinDB) {
		setLayout(null);
		this.pinDB = pinDB;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 950);
		add(image);

		text = new JLabel("Enter amount: ");
		text.setBounds(170, 330, 400, 20);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		image.add(text);

		amountTF = new JTextField();
		amountTF.setBounds(167, 370, 337, 25);
		amountTF.setFont(new Font("System", Font.BOLD, 22));
		amountTF.setForeground(Color.white);
		amountTF.setBackground(Color.DARK_GRAY);
		image.add(amountTF);

		deposit = new JButton("Deposit");
		deposit.setBounds(370, 510, 149, 35);
		deposit.setFont(new Font("System", Font.BOLD, 12));
		deposit.setBackground(Color.gray);
		deposit.setForeground(Color.blue);
		deposit.addActionListener(this);
		image.add(deposit);

		back = new JButton("Back");
		back.setBounds(370, 545, 149, 35);
		back.setFont(new Font("System", Font.BOLD, 12));
		back.setBackground(Color.gray);
		back.setForeground(Color.blue);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == deposit) {
			String amountDB = amountTF.getText();
			Date dateDB = new Date();
			if (amountDB.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount");
			} else {
				try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pinDB+"','"+ dateDB+"','Deposit','"+ amountDB +"')";
					c.s.executeUpdate(query);
					setVisible(false);
					new Transactions(pinDB).setVisible(true);
					
					JOptionPane.showMessageDialog(null, "Rs."+amountDB+" deposited Successfully");
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}

		} else if (e.getSource() == back) {
			setVisible(false);
			new Transactions(pinDB).setVisible(true);
		}
	}

	public static void main(String[] args) {

		new Deposit("");

	}

}
