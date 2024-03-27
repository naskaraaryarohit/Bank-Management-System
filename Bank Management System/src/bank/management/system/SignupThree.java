package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class SignupThree extends JFrame implements ActionListener {

	JLabel l1, type, card, c_number, pin, p_number, c_info, p_info, servicesReq;
	JRadioButton savingRB, recurringRB, currentRB, fixeddepRB;
	ButtonGroup accountBG;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;

	public SignupThree(String formno) {

		setLayout(null);
		this.formno = formno;

		l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);

		type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100, 140, 200, 30);
		add(type);

		savingRB = new JRadioButton("Saving");
		savingRB.setFont(new Font("Raleway", Font.BOLD, 16));
		savingRB.setBounds(100, 180, 150, 20);
		savingRB.setBackground(Color.white);
		add(savingRB);

		recurringRB = new JRadioButton("Recurring");
		recurringRB.setFont(new Font("Raleway", Font.BOLD, 16));
		recurringRB.setBounds(275, 180, 150, 20);
		recurringRB.setBackground(Color.white);
		add(recurringRB);

		currentRB = new JRadioButton("Current");
		currentRB.setFont(new Font("Raleway", Font.BOLD, 16));
		currentRB.setBounds(450, 180, 150, 20);
		currentRB.setBackground(Color.white);
		add(currentRB);

		fixeddepRB = new JRadioButton("Fixed Deposit");
		fixeddepRB.setFont(new Font("Raleway", Font.BOLD, 16));
		fixeddepRB.setBounds(625, 180, 150, 20);
		fixeddepRB.setBackground(Color.white);
		add(fixeddepRB);

		accountBG = new ButtonGroup();
		accountBG.add(currentRB);
		accountBG.add(recurringRB);
		accountBG.add(savingRB);
		accountBG.add(fixeddepRB);

		card = new JLabel("Card Number: ");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 250, 200, 30);
		add(card);

		c_number = new JLabel("XXXX-XXXX-XXXX-1234 ");
		c_number.setFont(new Font("Raleway", Font.BOLD, 22));
		c_number.setBounds(330, 250, 300, 30);
		add(c_number);

		c_info = new JLabel("Your 16 digit card number ");
		c_info.setFont(new Font("Raleway", Font.BOLD, 10));
		c_info.setBounds(101, 270, 300, 30);
		add(c_info);

		pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 300, 200, 30);
		add(pin);

		p_info = new JLabel("Your 4 digit PIN number ");
		p_info.setFont(new Font("Raleway", Font.BOLD, 10));
		p_info.setBounds(101, 320, 300, 30);
		add(p_info);

		p_number = new JLabel("XXXX");
		p_number.setFont(new Font("Raleway", Font.BOLD, 22));
		p_number.setBounds(330, 300, 300, 30);
		add(p_number);

		servicesReq = new JLabel("Services Required: ");
		servicesReq.setFont(new Font("Raleway", Font.BOLD, 22));
		servicesReq.setBounds(100, 375, 400, 30);
		add(servicesReq);

		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(100, 415, 200, 30);
		add(c1);

		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(300, 415, 200, 30);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(500, 415, 200, 30);
		add(c3);

		c4 = new JCheckBox("EMAIL & SMS Alerts");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(100, 455, 200, 30);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(300, 455, 200, 30);
		add(c5);

		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(500, 455, 200, 30);
		add(c6);

		c7 = new JCheckBox("I hear by declare that the above entered details are correct to the best of my knowledge");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100, 600, 1000, 20);
		add(c7);

		submit = new JButton("Submit");
		submit.setBackground(Color.WHITE);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Arial", Font.BOLD, 14));
		submit.setBounds(120, 660, 200, 40);
		add(submit);
		submit.addActionListener(this);

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.WHITE);
		cancel.setForeground(Color.BLACK);
		cancel.setFont(new Font("Arial", Font.BOLD, 14));
		cancel.setBounds(550, 660, 200, 40);
		add(cancel);
		cancel.addActionListener(this);

		getContentPane().setBackground(Color.white);
		setSize(850, 770);
		setVisible(true);
		setLocation(350, 10);
		getContentPane().setBackground(Color.white);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			String accountTypeDB = null;
			if (savingRB.isSelected()) {
				accountTypeDB = "Savings Account";
			} else if (recurringRB.isSelected()) {
				accountTypeDB = "Reccuring Account";
			} else if (currentRB.isSelected()) {
				accountTypeDB = "Current Account";
			} else if (fixeddepRB.isSelected()) {
				accountTypeDB = "Fixed Deposit Account";
			}

			Random random = new Random();

			String cardNumDB = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

			String pinNumDB = "" + Math.abs((random.nextLong() % 9000L) + 1000l);

			String facilityDB = "";
			if (c1.isSelected()) {
				facilityDB = facilityDB + " ATM Card";
			} else if (c2.isSelected()) {
				facilityDB = facilityDB + " Internet Banking";
			} else if (c3.isSelected()) {
				facilityDB = facilityDB + " Mobile Banking";
			} else if (c4.isSelected()) {
				facilityDB = facilityDB + " EMAIL & SMS Alerts";
			} else if (c5.isSelected()) {
				facilityDB = facilityDB + " Cheque Book";
			} else if (c6.isSelected()) {
				facilityDB = facilityDB + " E-Statement";
			}

			try {

				if (accountTypeDB.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required");

				} else {
					Conn c = new Conn();
					String query = "insert into signupThree values('" + formno + "','" + accountTypeDB + "','"
							+ cardNumDB + "','" + pinNumDB + "','" + facilityDB + "')";

					String query2 = "insert into login values('" + formno + "','"+ cardNumDB + "','" + pinNumDB + "')";
					c.s.executeUpdate(query);
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Card Number: "+cardNumDB+"\n Pin: "+pinNumDB);	

				}

			} catch (Exception e2) {

				System.out.println(e2);

			}
			setVisible(false);
			new Transactions(pinNumDB).setVisible(true);

		} else if (e.getSource() == cancel) {

			setVisible(false);
			new Login().setVisible(true);
		}

	}

	public static void main(String[] args) {

		new SignupThree("");
	}

}
