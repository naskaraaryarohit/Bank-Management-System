package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

@SuppressWarnings("serial")
public class FastCash extends JFrame implements ActionListener {

	String pinDB;
	JLabel text;
	JButton b1, b2, b3, b4, b5, b6, back;

	public FastCash(String pinDB) {

		setLayout(null);
		this.pinDB = pinDB;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 950);
		add(image);

		text = new JLabel("Select Withdrawl Amount");
		text.setBounds(240, 300, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		image.add(text);

		b1 = new JButton("Rs. 100");
		b1.setBounds(150, 440, 150, 35);
		b1.setFont(new Font("System", Font.BOLD, 12));
		b1.setBackground(Color.gray);
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		image.add(b1);

		b2 = new JButton("Rs. 500");
		b2.setBounds(370, 440, 150, 35);
		b2.setFont(new Font("System", Font.BOLD, 12));
		b2.setBackground(Color.gray);
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		image.add(b2);

		b3 = new JButton("Rs. 1000");
		b3.setBounds(150, 475, 149, 35);
		b3.setFont(new Font("System", Font.BOLD, 12));
		b3.setBackground(Color.gray);
		b3.setForeground(Color.blue);
		b3.addActionListener(this);
		image.add(b3);

		b4 = new JButton("Rs. 2000");
		b4.setBounds(370, 475, 149, 35);
		b4.setFont(new Font("System", Font.BOLD, 12));
		b4.setBackground(Color.gray);
		b4.setForeground(Color.blue);
		b4.addActionListener(this);
		image.add(b4);

		b5 = new JButton("Rs. 5000");
		b5.setBounds(150, 510, 149, 35);
		b5.setFont(new Font("System", Font.BOLD, 12));
		b5.setBackground(Color.gray);
		b5.setForeground(Color.blue);
		b5.addActionListener(this);
		image.add(b5);

		b6 = new JButton("Rs. 10000");
		b6.setBounds(370, 510, 149, 35);
		b6.setFont(new Font("System", Font.BOLD, 12));
		b6.setBackground(Color.gray);
		b6.setForeground(Color.blue);
		b6.addActionListener(this);
		image.add(b6);

		back = new JButton("BACK");
		back.setBounds(370, 545, 149, 35);
		back.setFont(new Font("System", Font.BOLD, 12));
		back.setBackground(Color.gray);
		back.setForeground(Color.blue);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 880);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			setVisible(false);
			new Transactions(pinDB).setVisible(true);
		} else {
			String amountDB = ((JButton) e.getSource()).getText().substring(4);
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from bankmanagementsystem.bank where PIN = '" + pinDB + "'");
				int balance = 0;

				while (rs.next()) {
					if (rs.getString("Type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("Amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("Amount"));
					}
				}
				if (e.getSource() != back && balance < Integer.parseInt(amountDB)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}

				Date dateDB = new Date();

				String query = "insert into bank values('" + pinDB + "','" + dateDB + "','Withdrawn','" + amountDB
						+ "')";

				c.s.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Rs. " + amountDB + " Debited Sucessfully");

				setVisible(false);
				new Transactions(pinDB).setVisible(true);

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}

	public static void main(String[] args) {

		new FastCash("");
	}

}
