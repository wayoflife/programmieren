package moritz.event_aufgaben;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BMI extends JFrame {
	JTextField txtbmi, txtdiagnose, txtgewicht, txtgroesse;
	JLabel lblgewicht, lblgroesse;
	JRadioButton rbtman, rbtwoman;
	JButton btberechne;

	public double berechneBMI(double gewicht, double groesseincm) {
		double bmi = 0.0;
		bmi = gewicht / (Math.pow(groesseincm / 100, 2));

		return bmi;
	}

	public BMI() {
		// TODO Auto-generated constructor stub
		super("BMI-Rechner");
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.setSize(300, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnlgewicht = new JPanel();
		this.add(pnlgewicht);
		JLabel lblgewicht = new JLabel("Gewicht in kg:");
		pnlgewicht.add(lblgewicht);
		txtgewicht = new JTextField(5);
		pnlgewicht.add(txtgewicht);

		JPanel pnlgroesse = new JPanel();
		this.add(pnlgroesse);
		JLabel lblgroesse = new JLabel("Groesse in cm:");
		pnlgroesse.add(lblgroesse);
		txtgroesse = new JTextField(5);
		pnlgroesse.add(txtgroesse);

		JPanel pnlgender = new JPanel();
		pnlgender.setLayout(new BorderLayout());
		this.add(pnlgender);
		ButtonGroup btgrp = new ButtonGroup();
		rbtman = new JRadioButton("männlich");
		rbtwoman = new JRadioButton("weiblich");
		btgrp.add(rbtwoman);
		btgrp.add(rbtman);
		pnlgender.add(rbtman, BorderLayout.WEST);
		pnlgender.add(rbtwoman, BorderLayout.EAST);

		JPanel pnlberechne = new JPanel();
		this.add(pnlberechne);
		btberechne = new JButton("berechne");
		pnlberechne.add(btberechne);

		JPanel pnlbmi = new JPanel();
		this.add(pnlbmi);
		JLabel lblbmi = new JLabel("BMI: ");
		pnlbmi.add(lblbmi);
		txtbmi = new JTextField(15);
		pnlbmi.add(txtbmi);

		JPanel pnldiagnose = new JPanel();
		this.add(pnldiagnose);
		txtdiagnose = new JTextField(20);
		txtdiagnose.setEditable(false);
		pnldiagnose.add(txtdiagnose);

		btberechne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double bmi = berechneBMI(
						Double.parseDouble(txtgewicht.getText()),
						Double.parseDouble(txtgroesse.getText()));
				txtbmi.setText("" + bmi);
				if (rbtman.isSelected()) {
					if (bmi < 20) {
						txtdiagnose.setText("Untergewicht!");
					}
					if (bmi >= 20 && bmi <= 25) {
						txtdiagnose.setText("Normalgewicht!");
					}
					if (bmi > 25 && bmi <= 30) {
						txtdiagnose.setText("Übergewicht!");
					}
					if (bmi > 30 && bmi <= 40) {
						txtdiagnose.setText("Adipositas!");
					}
					if (bmi > 40) {
						txtdiagnose.setText("massive Adipositas!");
					}
				}
				if (rbtwoman.isSelected()) {
					if (bmi < 19) {
						txtdiagnose.setText("Untergewicht!");
					}
					if (bmi >= 19 && bmi <= 24) {
						txtdiagnose.setText("Normalgewicht!");
					}
					if (bmi > 24 && bmi <= 30) {
						txtdiagnose.setText("Übergewicht!");
					}
					if (bmi > 30 && bmi <= 40) {
						txtdiagnose.setText("Adipositas!");
					}
					if (bmi > 40) {
						txtdiagnose.setText("massive Adipositas!");
					}
				}
			}

		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BMI();
	}

}
