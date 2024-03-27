package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

@SuppressWarnings("serial")
public class BalanceEnquiry extends JFrame implements ActionListener {

	String pinDB;
	JLabel text, text2;
	JButton b1;
	long balance;

	public BalanceEnquiry(String pinDB) {

		setLayout(null);
		this.pinDB = pinDB;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 950);
		add(image);

		text = new JLabel("Your Current account balance is: ");
		text.setBounds(190, 310, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		image.add(text);

		b1 = new JButton("Back");
		b1.setBounds(370, 545, 149, 35);
		b1.setFont(new Font("System", Font.BOLD, 12));
		b1.setBackground(Color.gray);
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		image.add(b1);

		Conn c = new Conn();

		try {
			ResultSet rs = c.s.executeQuery("select * from bankmanagementsystem.bank where PIN = '" + pinDB + "'");

			while (rs.next()) {
				if (rs.getString("Type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("Amount"));
					System.out.println(balance);
				} else {
					balance -= Integer.parseInt(rs.getString("Amount"));
					System.out.println(balance);

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		text2 = new JLabel("" + balance);
		text2.setBounds(190, 340, 700, 35);
		text2.setFont(new Font("System", Font.BOLD, 16));
		text2.setForeground(Color.white);
		image.add(text2);

		setSize(900, 880);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		new Transactions(pinDB).setVisible(true);

	}

	public static void main(String[] args) {

		new BalanceEnquiry("");

	}

}

