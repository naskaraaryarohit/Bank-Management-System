package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {

	JButton login, clear, signUP;
	JTextField cardTF;
	JPasswordField pinTF;

	Login() {

		setTitle("Automated Teller Machinr");

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
											/*
											 	image can't be passed as a Label so We need to convert the image to
											 	ImageIcon first then add it to the label
											 */
		
		JLabel label = new JLabel(i3);
 
		label.setBounds(150, 10, 100, 100);

		add(label);

		JLabel text = new JLabel(" Welcome to ATM ");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(250, 40, 400, 40);
		add(text);

		JLabel cardno = new JLabel(" Card Number :");
		cardno.setFont(new Font("Raleway", Font.BOLD, 22));
		cardno.setBounds(120, 150, 200, 30);
		add(cardno);

		cardTF = new JTextField();
		cardTF.setBounds(300, 150, 230, 30);
		cardTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTF);

		JLabel pin = new JLabel(" PIN :");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(120, 220, 230, 30);
		add(pin);

		pinTF = new JPasswordField();
		pinTF.setBounds(300, 220, 230, 30);
		pinTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTF);

		login = new JButton(" Sign In ");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.white);
		login.setForeground(Color.black);
		
		login.addActionListener(this);
		add(login);

		clear = new JButton(" Clear ");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.white);
		clear.setForeground(Color.black);
		clear.addActionListener(this);
		add(clear);

		signUP = new JButton(" Sign Up ");
		signUP.setBounds(300, 350, 230, 30);
		signUP.setBackground(Color.white);
		signUP.setForeground(Color.black);
		signUP.addActionListener(this);
		add(signUP);

		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
		getContentPane().setBackground(Color.white);

	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTF.setText("");
			pinTF.setText("");

		} else if (ae.getSource() == login) {
			Conn c = new Conn();
			String cardDB = cardTF.getText();
			String pinDB = pinTF.getText();
			String query = "select * from bankmanagementsystem.login where Card_No = '" + cardDB + "' and Pin = '" + pinDB + "'";
			try {
				ResultSet res = c.s.executeQuery(query);
				if(res.next()) {
					setVisible(false); 
					new Transactions(pinDB).setVisible(true); 
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect information entered");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (ae.getSource() == signUP) {
			setVisible(false); 					// closes welcome page
			new SignupOne().setVisible(true); 	// opens SignUp Page (executes the SignUpOne Class)
		}
	}

	public static void main(String[] args) {

		new Login();
	}

}
