package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SignupTwo extends JFrame implements ActionListener {

	JLabel additionalDetails, religion, category, income, educational, qualification, occupation, pan, aadhar, senCiti,
	exisAcc;
	JTextField panTF, aadharTF;
	JRadioButton yesSC, noSC, yesEA, noEA;
	JComboBox<?> religionJC, categoryJC, occupationJC, eduQuaJC, incomeJC;
	ButtonGroup scGrp, eaGrp;
	JButton next;
	String formno;

	SignupTwo(String formno) {

		this.formno = formno;
		setLayout(null);
		setTitle("New account Application Form - Page 2");

		additionalDetails = new JLabel("Page 2: Aditional Details ");
		additionalDetails.setFont(new Font("Osward", Font.BOLD, 18));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);

		religion = new JLabel("Religion: ");
		religion.setFont(new Font("Osward", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);

		String valReligion[] = { "Select", "Hindu", "Muslim", "Sikh", "Christian", "Jain", "Others" };
		religionJC = new JComboBox<Object>(valReligion);
		religionJC.setBounds(300, 140, 400, 20);
		religionJC.setFont(new Font("Arial", Font.BOLD, 14));
		religionJC.setBackground(Color.white);
		add(religionJC);

		category = new JLabel("Category: ");
		category.setFont(new Font("Osward", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);

		String valCategory[] = { "Select", "General", "SC", "ST", "OBC", "Others" };
		categoryJC = new JComboBox<Object>(valCategory);
		categoryJC.setBounds(300, 190, 400, 20);
		categoryJC.setFont(new Font("Arial", Font.BOLD, 14));
		categoryJC.setBackground(Color.white);
		add(categoryJC);

		income = new JLabel("Income: ");
		income.setFont(new Font("Osward", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);

		String valIncome[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
		incomeJC = new JComboBox<Object>(valIncome);
		incomeJC.setBounds(300, 240, 400, 20);
		incomeJC.setFont(new Font("Arial", Font.BOLD, 14));
		incomeJC.setBackground(Color.white);
		add(incomeJC);

		educational = new JLabel("Educational ");
		educational.setFont(new Font("Osward", Font.BOLD, 20));
		educational.setBounds(100, 290, 200, 30);
		add(educational);

		qualification = new JLabel("Qualification: ");
		qualification.setFont(new Font("Osward", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);

		String valEduQua[] = { "Null", "Non-Graduate", "Graduate", "Post Graduate", "Doctrate", "Others" };
		eduQuaJC = new JComboBox<Object>(valEduQua);
		eduQuaJC.setBounds(300, 315, 400, 20);
		eduQuaJC.setFont(new Font("Arial", Font.BOLD, 14));
		eduQuaJC.setBackground(Color.white);
		add(eduQuaJC);

		occupation = new JLabel("Occupation: ");
		occupation.setFont(new Font("Osward", Font.BOLD, 20));
		occupation.setBounds(100, 365, 200, 30);
		add(occupation);

		String valOccupation[] = { "Null", "Salaried", "Business", "Self-Employed", "Student", "Retired", "Others" };
		occupationJC = new JComboBox<Object>(valOccupation);
		occupationJC.setBounds(300, 365, 400, 20);
		occupationJC.setFont(new Font("Arial", Font.BOLD, 14));
		occupationJC.setBackground(Color.white);
		add(occupationJC);

		pan = new JLabel("PAN Number: ");
		pan.setFont(new Font("Osward", Font.BOLD, 20));
		pan.setBounds(100, 420, 200, 30);
		add(pan);

		panTF = new JTextField();
		panTF.setBounds(300, 420, 400, 20);
		panTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(panTF);

		aadhar = new JLabel("Aadhar No: ");
		aadhar.setFont(new Font("Osward", Font.BOLD, 20));
		aadhar.setBounds(100, 470, 200, 30);
		add(aadhar);

		aadharTF = new JTextField();
		aadharTF.setBounds(300, 470, 400, 20);
		aadharTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(aadharTF);

		senCiti = new JLabel("Senior Citizen: ");
		senCiti.setFont(new Font("Osward", Font.BOLD, 20));
		senCiti.setBounds(100, 520, 200, 30);
		add(senCiti);

		yesSC = new JRadioButton("Yes");
		yesSC.setBounds(300, 520, 100, 30);
		yesSC.setBackground(Color.white);
		add(yesSC);

		noSC = new JRadioButton("No");
		noSC.setBounds(450, 520, 150, 30);
		noSC.setBackground(Color.white);
		add(noSC);

		scGrp = new ButtonGroup();
		scGrp.add(yesSC);
		scGrp.add(noSC);

		exisAcc = new JLabel("Existing Account: ");
		exisAcc.setFont(new Font("Osward", Font.BOLD, 20));
		exisAcc.setBounds(100, 570, 200, 30);
		add(exisAcc);

		yesEA = new JRadioButton("Yes");
		yesEA.setBounds(300, 570, 100, 30);
		yesEA.setBackground(Color.white);
		add(yesEA);

		noEA = new JRadioButton("No");
		noEA.setBounds(450, 570, 100, 30);
		noEA.setBackground(Color.white);
		add(noEA);

		eaGrp = new ButtonGroup();
		eaGrp.add(yesEA);
		eaGrp.add(noEA);

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

		String formnoDB = " " + formno; // long(""+ :converts integer value to string)

		String religionDB = (String) religionJC.getSelectedItem();
		String categoryDB = (String) categoryJC.getSelectedItem();
		String incomeDB = (String) incomeJC.getSelectedItem();
		String eduQuaDB = (String) eduQuaJC.getSelectedItem();
		String occuDB = (String) occupationJC.getSelectedItem();

		String seniorCitizenDB = null;
		if (yesSC.isSelected()) {
			seniorCitizenDB = "Yes";
		} else if (noSC.isSelected()) {
			seniorCitizenDB = "No";
		}
		String existingAccontDB = null;
		if (yesEA.isSelected()) {
			existingAccontDB = "Yes";
		} else if (noEA.isSelected()) {
			existingAccontDB = "No";
		}
		String panDB = panTF.getText();
		String aadharDB = aadharTF.getText();

		try {
			Conn c = new Conn();
			String query = "insert into signupTwo values ('" + formnoDB + "','" + religionDB + "','" + categoryDB
					+ "','" + incomeDB + "','" + eduQuaDB + "','" + occuDB + "','" + panDB + "','" + aadharDB + "','"
					+ seniorCitizenDB + "','" + existingAccontDB + "')";
			c.s.executeUpdate(query);

			setVisible(false);
			new SignupThree(formno).setVisible(true);


		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		new SignupTwo("");
	}

}
