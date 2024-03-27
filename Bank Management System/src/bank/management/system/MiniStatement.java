package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MiniStatement extends JFrame implements ActionListener {

	JLabel text, bank, card, mini, balance;

	public MiniStatement(String pinDB) {

		setLayout(null);

		setTitle("Mini Statement");

		text = new JLabel();
		add(text);

		bank = new JLabel("Gareebo ka Bank");
		bank.setBounds(135, 20, 300, 20);
		bank.setFont(new Font("System", Font.BOLD, 16));
		bank.setForeground(Color.BLACK);
		add(bank);

		card = new JLabel();
		card.setBounds(20, 80, 400, 20);
		card.setFont(new Font("System", Font.BOLD, 16));
		card.setForeground(Color.BLACK);
		add(card);

		try {

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bankmanagementsystem.login where Pin = '" + pinDB + "'");

			while (rs.next()) {
				card.setText("Card Number: " + rs.getString("Card_No").substring(0, 4) + "-XXXX-XXXX-"
						+ rs.getString("Card_No").substring(12));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		mini = new JLabel();
		mini.setBounds(40, 100, 400, 500);
		mini.setFont(new Font("System", Font.ITALIC, 10));
		mini.setForeground(Color.BLACK);
		add(mini);

		balance = new JLabel();
		balance.setBounds(40, 500, 300, 20);
		balance.setFont(new Font("System", Font.ITALIC, 13));
		balance.setForeground(Color.BLACK);
		add(balance);

		try {
			Conn c = new Conn();
			int balanceDB = 0;

			ResultSet rs = c.s.executeQuery("select * from bankmanagementsystem.bank where Pin = '" + pinDB + "'");
			while (rs.next()) {

				mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("Amount") + "<br><br><html>");

				if (rs.getString("Type").equals("Deposit")) {
					balanceDB += Integer.parseInt(rs.getString("Amount"));
					System.out.println(balance);
				} else {
					balanceDB -= Integer.parseInt(rs.getString("Amount"));
					System.out.println(balance);
				}
			}
			balance.setText("Your Current Balance is: Rs." + balanceDB);

		} catch (Exception e2) {
			System.out.println(e2);
		}

		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.white);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {

		new MiniStatement("");
	}

}
