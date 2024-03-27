package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PinChange extends JFrame implements ActionListener {

	String pinDB;
	JLabel text, pin, re_pin;
	JPasswordField pinTF, re_pinTF;
	JButton b1, b2;

	public PinChange(String pinDB) {

		setLayout(null);
		this.pinDB = pinDB;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 950);
		add(image);

		text = new JLabel("Change your PIN");
		text.setBounds(270, 300, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		image.add(text);

		pin = new JLabel("Enter New PIN");
		pin.setBounds(167, 350, 180, 25);
		pin.setFont(new Font("System", Font.BOLD, 14));
		pin.setForeground(Color.white);
		image.add(pin);

		pinTF = new JPasswordField();
		pinTF.setBounds(165, 380, 180, 20);
		pinTF.setFont(new Font("System", Font.BOLD, 16));
		pinTF.setForeground(Color.white);
		pinTF.setBackground(Color.DARK_GRAY);
		image.add(pinTF);

		re_pin = new JLabel("Re-enter New PIN");
		re_pin.setBounds(167, 410, 180, 25);
		re_pin.setFont(new Font("System", Font.BOLD, 14));
		re_pin.setForeground(Color.white);
		image.add(re_pin);

		re_pinTF = new JPasswordField();
		re_pinTF.setBounds(165, 440, 180, 20);
		re_pinTF.setFont(new Font("System", Font.BOLD, 16));
		re_pinTF.setForeground(Color.white);
		re_pinTF.setBackground(Color.DARK_GRAY);
		image.add(re_pinTF);

		b1 = new JButton("Change");
		b1.setBounds(370, 510, 149, 35);
		b1.setFont(new Font("System", Font.BOLD, 12));
		b1.setBackground(Color.gray);
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		image.add(b1);

		b2 = new JButton("Back");
		b2.setBounds(370, 545, 149, 35);
		b2.setFont(new Font("System", Font.BOLD, 12));
		b2.setBackground(Color.gray);
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		image.add(b2);

		setSize(900, 880);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);

	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			try {

				String new_pinDB = pinTF.getText();
				String new_repinDB = re_pinTF.getText();

				if (!new_pinDB.equals(new_repinDB)) {
					JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
					return;
				}

				if (new_pinDB.equals(" ")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
				}

				if (new_repinDB.equals(" ")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
				}

				Conn c = new Conn();

				String query1 = "update bankmanagementsystem.bank set PIN = '" + new_pinDB + "' where PIN = '" + pinDB
						+ "';";

				String query2 = "update bankmanagementsystem.login set PIN = '" + new_pinDB + "' where PIN = '" + pinDB
						+ "';";

				String query3 = "update bankmanagementsystem.signupThree set PIN = '" + new_pinDB + "'  where PIN = '"
						+ pinDB + "';";

				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN Changed Sucessfully");
				
				setVisible(false);
				new Transactions(new_pinDB).setVisible(true);

			} catch (Exception e2) {
				System.out.println(e);
			}

		} else if(e.getSource() == b2) {
			setVisible(false);
			new Transactions(pinDB).setVisible(true);
		}

	}

	public static void main(String[] args) {

		new PinChange("").setVisible(true);
	}

}

