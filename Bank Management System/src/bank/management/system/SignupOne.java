package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class SignupOne extends JFrame implements ActionListener {

	JLabel formno, personalDetails, name, fname, dob, gender, email, martialStatus, address, city, state, pinCode;
	JTextField nameTF, fnameTF, emailTF, addressTF, cityTF, stateTF, pinTF;
	JDateChooser dobDC;
	JRadioButton male, female, married, single, divorced;
	ButtonGroup genderGrp, maritalGrp;
	JButton next;
	long formNo;

	SignupOne() {

		setLayout(null);

		Random ran = new Random();
		formNo = Math.abs(ran.nextLong() % 9000L + 1000L);
		formno = new JLabel("Application Form No: " + formNo);
		formno.setFont(new Font("Osward", Font.BOLD, 38));
		formno.setBounds(155, 20, 600, 40);
		add(formno);

		personalDetails = new JLabel("Page 1: Personal Details ");
		personalDetails.setFont(new Font("Osward", Font.BOLD, 18));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);

		name = new JLabel("Name: ");
		name.setFont(new Font("Osward", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nameTF = new JTextField();
		nameTF.setBounds(300, 140, 400, 20);
		nameTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(nameTF);

		fname = new JLabel("Fathers Name: ");
		fname.setFont(new Font("Osward", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);

		fnameTF = new JTextField();
		fnameTF.setBounds(300, 190, 400, 20);
		fnameTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(fnameTF);

		dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("Osward", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		dobDC = new JDateChooser();
		dobDC.setBounds(300, 240, 400, 20);
		dobDC.setFont(new Font("Osward", Font.BOLD, 15));
		dobDC.setForeground(Color.BLACK);
		add(dobDC);

		gender = new JLabel("Gender: ");
		gender.setFont(new Font("Osward", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 100, 30);
		male.setBackground(Color.white);
		add(male);

		female = new JRadioButton("Female");
		female.setBounds(450, 290, 100, 30);
		female.setBackground(Color.white);
		add(female);

		genderGrp = new ButtonGroup();
		genderGrp.add(male);
		genderGrp.add(female);

		email = new JLabel("Email: ");
		email.setFont(new Font("Osward", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		emailTF = new JTextField();
		emailTF.setBounds(300, 340, 400, 20);
		emailTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(emailTF);

		martialStatus = new JLabel("Marital Status: ");
		martialStatus.setFont(new Font("Osward", Font.BOLD, 20));
		martialStatus.setBounds(100, 390, 200, 30);
		add(martialStatus);

		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.white);
		add(married);

		single = new JRadioButton("Single");
		single.setBounds(450, 390, 100, 30);
		single.setBackground(Color.white);
		add(single);

		divorced = new JRadioButton("Divorced");
		divorced.setBounds(600, 390, 100, 30);
		divorced.setBackground(Color.white);
		add(divorced);

		maritalGrp = new ButtonGroup();
		maritalGrp.add(married);
		maritalGrp.add(single);
		maritalGrp.add(divorced);

		address = new JLabel("Address: ");
		address.setFont(new Font("Osward", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		addressTF = new JTextField();
		addressTF.setBounds(300, 440, 400, 20);
		addressTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(addressTF);

		city = new JLabel("City: ");
		city.setFont(new Font("Osward", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		cityTF = new JTextField();
		cityTF.setBounds(300, 490, 400, 20);
		cityTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(cityTF);

		state = new JLabel("State: ");
		state.setFont(new Font("Osward", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		stateTF = new JTextField();
		stateTF.setBounds(300, 540, 400, 20);
		stateTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(stateTF);

		pinCode = new JLabel("Pin Code: ");
		pinCode.setFont(new Font("Osward", Font.BOLD, 20));
		pinCode.setBounds(100, 590, 200, 30);
		add(pinCode);

		pinTF = new JTextField();
		pinTF.setBounds(300, 590, 400, 20);
		pinTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTF);

		next = new JButton(" Next ");
		next.setBackground(Color.WHITE);
		next.setForeground(Color.BLACK);
		next.setFont(new Font("Arial", Font.BOLD, 14));
		next.setBounds(600, 650, 200, 40);
		add(next);
		
		next.addActionListener(this);

		setSize(850, 800);
		setVisible(true);
		setLocation(350, 10);
		getContentPane().setBackground(Color.white);

	}

	public void actionPerformed(ActionEvent ae) {

		String formnoDB = " "+ formNo;	//long(""+ :converts integer value to string)
		String name = nameTF.getText();	//setText
		String fname = fnameTF.getText();
		String dob = ((JTextField) dobDC.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		String email = emailTF.getText();
		String maritalStatus=null;
		if(married.isSelected()) {
			maritalStatus="Married";
		}
		else if (single.isSelected()) {
			maritalStatus="Single";
		}
		else if (divorced.isSelected()) {
			maritalStatus="Divorced";
		}
		String address = addressTF.getText();
		String city = cityTF.getText();
		String state = stateTF.getText();
		String pinCode = pinTF.getText();

		try {
			if(name.equals("")) {

				JOptionPane.showMessageDialog(null, "Name is Required");
				
			}else if(fname.equals("")) {

				JOptionPane.showMessageDialog(null, "Fathers Name is Required");
				
			}else if(email.equals("")) {

				JOptionPane.showMessageDialog(null, "Email is Required");
				
			}else if(address.equals("")) {

				JOptionPane.showMessageDialog(null, "Address is Required");
				
			}else if(city.equals("")) {

				JOptionPane.showMessageDialog(null, "City is Required");
				
			}else if(state.equals("")) {

				JOptionPane.showMessageDialog(null, "State is Required");
				
			}else if(pinCode.equals("")) {

				JOptionPane.showMessageDialog(null, "PinCode is Required");
				
			}
			else {
				
				Conn c = new Conn();
				String query = "insert into signup values ('"+formnoDB+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
				c.s.executeUpdate(query);
				setVisible(false);						 
				new SignupTwo(formnoDB).setVisible(true);
			}
			
		} catch (Exception e) {

			System.out.println(e);
		}
				
	}

	public static void main(String[] args) {

		new SignupOne();
	}

}
